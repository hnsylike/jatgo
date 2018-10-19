package com.kafang.atgo.restful.filter;

import com.kafang.atgo.AtgoErrorCode;
import com.kafang.atgo.AtgoException;
import com.kafang.atgo.restful.bean.rep.PermissionConfigBean;
import com.kafang.atgo.restful.bean.req.SendCodeBean;
import com.kafang.atgo.restful.config.PermissionConfig;
import com.kafang.atgo.restful.entity.WsRolePermission;
import com.kafang.atgo.restful.resource.OrderRestfulApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author like
 * @description 过滤token
 * @data 2018/9/29
 */
@Slf4j
@Component
public class AuthorizationFilter implements ContainerRequestFilter {

    @Autowired
    private OrderRestfulApi orderRestfulApi;

    @Autowired
    private PermissionConfig permissionConfig;

    //白名单
    private static String[] whiteArray = {"user/check", "sms/send", "sms/validate", "order/login", "swagger.json", "webSocket/", "user/login"};

    @Value("${atgo.token.enable}")
    private Boolean tokenEnable;

    @Override
    public void filter(ContainerRequestContext requestContext) {
        String authorization = requestContext.getHeaderString("Authorization");
        String method = requestContext.getMethod();
        String url = requestContext.getUriInfo().getPath();

        if (null != method && method.equals("OPTIONS")) {
            return;//如果是预处理则不校验token
        }
        if (null != tokenEnable && !tokenEnable) {
            return;//开发测试用
        }

        boolean bol = true;
        for (String white : whiteArray) {
            if (url.contains(white)) {
                bol = false;
                break;
            }
        }
        if (!bol) {
            return;//白名单不需要校验token
        }

        PermissionConfigBean wsPermission = getPerMissionList(url, method);
//        if (null == wsPermission) {
//            return; //资源未配置，随意访问
//        }
        if (wsPermission.getWhite()) {
            return;//白名单不需要校验token
        }


        if (!StringUtils.isEmpty(authorization)) {
            String token = authorization.contains("token") ? authorization.substring(5).trim() : authorization;

            SendCodeBean sendCodeBean = orderRestfulApi.getSendCodeBean(token);
            if (null == sendCodeBean || !token.equals(sendCodeBean.getToken()) || LocalDateTime.now().isAfter(sendCodeBean.getTokenTime())) {
                log.info("token已过期!!!");
                throw new AtgoException(AtgoErrorCode.AUTHORIZATION_ERROR, "token已过期!!!");
            }
            checkPermission(wsPermission, sendCodeBean);
        } else {
            log.info("请先登录 !!!");
            throw new AtgoException(AtgoErrorCode.AUTHORIZATION_ERROR, "请先登录 !!!");
        }
    }

    /**
     * 根据请求url和method获取资源信息
     *
     * @param url
     * @param method
     * @return
     */
    private PermissionConfigBean getPerMissionList(String url, String method) {
        String urlArray[] = url.split("/");
        String path = "";
        if (urlArray.length > 1) {
            path = urlArray[0] + "/" + urlArray[1];
        } else {
            path = urlArray[0];
        }

        List<PermissionConfigBean> permissionConfigBeans = permissionConfig.querAllPermission();
        PermissionConfigBean bean = null;
        for (PermissionConfigBean permissionConfigBean : permissionConfigBeans) {
            if (permissionConfigBean.getPermissionUrl().contains(path) &&
                    permissionConfigBean.getPermissionMethod().toUpperCase().equals(method.toUpperCase())) {
                bean = permissionConfigBean;
                break;
            }
        }

        if (bean == null) {
            throw new AtgoException(AtgoErrorCode.PERMISSION_ERROR, "该资源未配置，请先配置资源！");
        }
        return bean;
    }


    /**
     * 校验权限
     *
     * @param wsPermission
     * @param sendCodeBean
     */
    private void checkPermission(PermissionConfigBean wsPermission, SendCodeBean sendCodeBean) {
        if (null == sendCodeBean || sendCodeBean.getWsUser() == null) {
            return;
        }

        if (CollectionUtils.isEmpty(wsPermission.getWsRolePermissions())) {
            throw new AtgoException(AtgoErrorCode.PERMISSION_ERROR, "该资源未配置角色，请先配置资源所属角色！");
        } else {
            if (CollectionUtils.isEmpty(sendCodeBean.getWsUserRoleList())) {
                throw new AtgoException(AtgoErrorCode.PERMISSION_ERROR, "该用户未配置角色，请先配置用户所属角色！");
            }
            List<WsRolePermission> wsRolePermissionList = wsPermission.getWsRolePermissions();
            if (!CollectionUtils.isEmpty(wsRolePermissionList)) {
                List<Long> roleId = sendCodeBean.getWsUserRoleList().stream().map(p -> p.getRoleId()).collect(Collectors.toList());
                boolean bol = false;
                for (WsRolePermission wsRolePermission : wsRolePermissionList) {
                    if (roleId.contains(wsRolePermission.getRoleId())) {
                        bol = true;
                        break;
                    }
                }
                if (!bol) {
                    throw new AtgoException(AtgoErrorCode.PERMISSION_ERROR, "该用户无权限访问！");
                }
            }
        }
    }


}
