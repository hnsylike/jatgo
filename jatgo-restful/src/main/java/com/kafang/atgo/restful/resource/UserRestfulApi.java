package com.kafang.atgo.restful.resource;

import com.kafang.atgo.AtgoErrorCode;
import com.kafang.atgo.AtgoException;
import com.kafang.atgo.persistence.db.entity.AgAccount;
import com.kafang.atgo.restful.base.AtgoRestfulApi;
import com.kafang.atgo.restful.bean.rep.LogonResult;
import com.kafang.atgo.restful.bean.req.LogonReq;
import com.kafang.atgo.restful.bean.req.SendCodeBean;
import com.kafang.atgo.restful.bean.req.UserAddReq;
import com.kafang.atgo.restful.dto.rep.ResponseTemplate;
import com.kafang.atgo.restful.entity.*;
import com.kafang.atgo.restful.service.api.*;
import com.kafang.atgo.restful.util.Md5Encrypt;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDateTime;
import java.util.*;

@Api(value = "admin role Rest Api测试")
@Slf4j
@Path("/user")
@Component
public class UserRestfulApi extends AtgoRestfulApi {

    @Value("${atgo.defult.broker}")
    private String broker;

    @Value("${atgo.defult.adaptorType}")
    private String adaptorType;

    @Autowired
    private UserService userService;

    @Autowired
    private AgCustomerService customerService;

    @Autowired
    private WsUserCustomerMpService wcmService;

    @Autowired
    private AgClientService agClientService;

    @Autowired
    private AgAccountService agAccountService;

    @Autowired
    private SmsRestfulApi smsRestfulApi;

    @Value("${login.username.enable:true}")
    private boolean usernameEnable;

    @Value("${login.phone.enable:true}")
    private boolean phoneEnable;

    @Value("${login.smsCode.enable:true}")
    private boolean smsCodeEnable;

    @Autowired
    private OrderRestfulApi orderRestfulApi;

    @Autowired
    private WsAuditTrailService waService;

    /**
     * admin角色页面显示所有客户名
     *
     * @return
     */
    @GET
    @Path("/queryCustomer")
    @Produces(JSON_UTF8)
    @Consumes(JSON_UTF8)
    public ResponseTemplate<List<AgCustomer>> findAll() {
        return ResponseTemplate.ok(customerService.getAll());
    }

    /**
     * admin角色页面显示所有客户名对应的产品
     *
     * @param customerid
     * @return
     */
    @GET
    @Path("/getCustomer/{customerid}")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "展示所有客户名对应的产品rest api", notes = "rest api")
    @ApiImplicitParam(paramType = "path", required = true, name = "机构名id")
    @Consumes(JSON_UTF8)
    public ResponseTemplate<List<AgClient>> getCustomer(@PathParam("customerid") int customerid) {
        List<AgClient> list = agClientService.getByCustomerId(customerid);
        return ResponseTemplate.ok(list);
    }

    /**
     * admin角色页面显示所有客户名对应的用户信息
     *
     * @param customerid
     * @return
     */
    @GET
    @Path("/getUser/{customerid}")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "展示所有客户名对应的用户信息rest api", notes = "rest api")
    @ApiImplicitParam(paramType = "path", required = true, name = "机构名id")
    @Consumes(JSON_UTF8)
    public ResponseTemplate<List<WsUser>> getUser(@PathParam("customerid") int customerid) {
        List<WsUser> wu = userService.getUser(customerid);
        return ResponseTemplate.ok(wu);
    }

    /**
     * admin角色页面显示所有客户名对应的手机
     *
     * @param customerid
     * @return
     */
    @GET
    @Path("/getPhone/{customerid}")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "展示所有客户名对应的手机号码rest api", notes = "rest api")
    @ApiImplicitParam(paramType = "path", required = true, name = "机构名id")
    @Consumes(JSON_UTF8)
    public ResponseTemplate<List<WsPhone>> getPhone(@PathParam("customerid") int customerid) {
        List<WsPhone> wplist = userService.getPhone(customerid);
        return ResponseTemplate.ok(wplist);
    }

    /**
     * admin角色页面删除客户对应的用户信息，手机号
     *
     * @param id
     * @return
     */
    @GET
    @Path("/delCustomerUser/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "删除机构对应的用户信息，手机号码rest api", notes = "rest api")
    @ApiImplicitParam(paramType = "path", required = true, name = "用户id")
    @Consumes(JSON_UTF8)
    public ResponseTemplate<Void> delCustomerUser(@PathParam("id") int id) {
        log.info("REST: delCustomerUser by userId /delCustomerUser/userId " + id);
        List<AgClient> agClient = agClientService.getByUserId(id);
        if(agClient.size() > 0) {
            //删除用户前先查询有没有账户信息
            return ResponseTemplate.failed(Response.Status.INTERNAL_SERVER_ERROR, "请先删除该机构下的账户信息");
        }
        customerService.delCustomerUser(id);
        return ResponseTemplate.ok();
    }

    /**
     * admin角色页面删除客户对应的产品，策略
     *
     * @param id
     * @return
     */
    @GET
    @Path("/delClient/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "删除机构对应的产品，策略rest api", notes = "rest api")
    @ApiImplicitParam(paramType = "path", required = true, name = "机构名id")
    @Consumes(JSON_UTF8)
    public ResponseTemplate<Void> delClient(@PathParam("id") int id) {
        log.info("REST: delCustomerClient by userId /delClient/userId " + id);
        customerService.delClient(id);
        return ResponseTemplate.ok();
    }

    /**
     * admin角色页面删除客户机构
     *
     * @param id
     * @return
     */
    @GET
    @Path("/delCustomer/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "删除机构rest api", notes = "rest api")
    @ApiImplicitParam(paramType = "path", required = true, name = "机构名id")
    @Consumes(JSON_UTF8)
    public ResponseTemplate<Void> delCustomer(@PathParam("id") int id) {
        log.info("REST: delCustomer by id /delCustomer/id " + id);
        WsUserCustomerMp wsUserCustomerMp = wcmService.getCustomerId(id);
        if(wsUserCustomerMp != null) {
            throw new AtgoException(AtgoErrorCode.USER_MALOPERATION_ERROR,"请先删除用户信息");
        }
        List<AgClient> agClient = agClientService.getByCustomerId(id);
        if(agClient.size() > 0) {
            throw new AtgoException(AtgoErrorCode.USER_MALOPERATION_ERROR,"请先删除账户信息");
        }
        customerService.delCustomer(id);
        return ResponseTemplate.ok();
    }



    /**
     * admin角色页面添加客户
     *
     * @param customerName
     * @return
     */
    @GET
    @Path("/addCustomer/{customerName}")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "添加机构rest api", notes = "rest api")
    @ApiImplicitParam(paramType = "path", required = true, name = "机构名称")
    @Consumes(JSON_UTF8)
    public ResponseTemplate<AgCustomer> addCustomer(@PathParam("customerName") String customerName) {
        log.info("REST: addCustomer by customerName /addCustomer/customerName " + customerName);
        List<AgCustomer> list = customerService.getCustomerName(customerName);
        AgCustomer ac = null;
        if(list.isEmpty()) {
            ac = new AgCustomer();
            ac.setCustomerName(customerName);
            //查询表数据最新customerid
            String customerid = customerService.selectCustomerId();
            if(StringUtils.isBlank(customerid)) {
                ac.setCustomerId(1);
            } else {
                //string转int
                int cid = Integer.parseInt(customerid);
                ac.setCustomerId(++cid);
            }
            customerService.insert(ac);
            ac = customerService.selectByCustomerName(ac.getCustomerName());
            return ResponseTemplate.ok(ac);
        }
        return ResponseTemplate.failed(Response.Status.INTERNAL_SERVER_ERROR, "添加失败,该机构已存在!");
    }


    /**
     * admin角色页面添加客户所对应的用户信息-手机号 userid,  username,  password,  phone, role
     *
     * @param wsUser
     * @return
     * @throws Exception
     */
    @POST
    @Path("/addUser")
    @Produces(JSON_UTF8)
    @Consumes(JSON_UTF8)
    public ResponseTemplate<Void> addUser(UserAddReq wsUser) throws Exception {
        log.info("REST: addCustomerUser /addUser " + wsUser);
        List<WsUser> list = userService.getUsername(wsUser.getUsername());
        if(list.isEmpty()) {
            int a = 1;
            //查询表数据最新userid
            String userid = userService.selectUserId();
            if(StringUtils.isBlank(userid)) {
                long uid = new Long(a);
                wsUser.setUserid(uid);
            } else {
                int b = Integer.parseInt(userid);
                long uid = new Long(b);
                wsUser.setUserid(++uid);
            }
            String pwd = DigestUtils.md5Hex(Md5Encrypt.getContentBytes(wsUser.getPassword(), "UTF-8"));
            wsUser.setPassword(pwd);
            userService.insert(handlerUser(wsUser));
            WsPhone wphone = new WsPhone();
            wphone.setPhone(wsUser.getPhone());
            wphone.setUserId(wsUser.getUserid());
            userService.insertphone(wphone);
            WsUserCustomerMp w = new WsUserCustomerMp();
            w.setUserId(wsUser.getUserid());
            w.setCustomerId(wsUser.getCustomerId());
            wcmService.insert(w);

            saveUserRole(wsUser);
            return ResponseTemplate.ok();
        }
        return ResponseTemplate.failed(Response.Status.BAD_REQUEST, "添加失败,该用户已经存在!");
    }

    /**
     * 保存用户角色信息
     * @param wsUser
     */
    private void saveUserRole(UserAddReq wsUser){
        List<Long> orderIds = wsUser.getOrderIds() == null ? new ArrayList<>() : wsUser.getOrderIds();
        if(StringUtils.isNotEmpty(wsUser.getRole())) {
            if (wsUser.getRole().toLowerCase().equals("admin")) {
                orderIds.add(1L);
            } else if (wsUser.getRole().toLowerCase().equals("trader")) {
                orderIds.add(2L);
            } else if (wsUser.getRole().toLowerCase().equals("censor")) {
                orderIds.add(3L);
            }
        }

        if(!CollectionUtils.isEmpty(orderIds)) {
            List<WsUserRole> wsUserRoleList = new ArrayList<>();
            for (Long roleId : orderIds) {
                WsUserRole wsUserRole = new WsUserRole();
                wsUserRole.setRoleId(roleId);
                wsUserRole.setUserId(wsUser.getUserid());
                wsUserRoleList.add(wsUserRole);
            }
            userService.saveUserRoles(wsUserRoleList);
        }
    }

    private WsUser handlerUser(UserAddReq userAddReq) {
        WsUser wsUser = new WsUser();
        wsUser.setCustomerId(userAddReq.getCustomerId());
        wsUser.setId(userAddReq.getId());
        wsUser.setPassword(userAddReq.getPassword());
        wsUser.setPhone(userAddReq.getPhone());
        wsUser.setRole(userAddReq.getRole());
        wsUser.setUserid(userAddReq.getUserid());
        wsUser.setUsername(userAddReq.getUsername());
        return wsUser;
    }

    /**
     * admin角色页面添加客户产品所对应的账户
     *
     * @return
     * @throws Exception
     */
    @POST
    @Path("/addClient")
    @Produces(JSON_UTF8)
    @Consumes(JSON_UTF8)
    public ResponseTemplate<Void> addClient(AgClient ac) {
        //查询表数据最新clientId
        String clientId = agClientService.selectid();
        int newClientId = StringUtils.isBlank(clientId) ? 1 : Integer.parseInt(clientId) + 1;
        ac.setClientId(newClientId);
        ac.setBroker(broker);
        ac.setAdaptorType(adaptorType);
        agClientService.insert(ac);

        AgAccount account = new AgAccount();
        //查询表数据最新accountId
        String accountId = agAccountService.selectid();
        int newAccountId = StringUtils.isBlank(accountId) ? 1 : Integer.parseInt(clientId) + 1;
        //string转int
        account.setAccountId(newAccountId);
        account.setClientId(ac.getClientId());
        account.setActive(false);
        account.setEnableBalance(0);
        account.setCreditBalance(0);
        agAccountService.insert(account);
        return ResponseTemplate.ok();
    }


    /**
     * 下母单页面显示当前登录用户的产品名
     *
     * @param userid
     * @return
     */
    @GET
    @Path("/findCustomer/{userid}")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "展示当前用户产品名rest api", notes = "rest api")
    @ApiImplicitParam(paramType = "path", required = true, name = "用户id")
    @Consumes(JSON_UTF8)
    public ResponseTemplate<List<AgClient>> findCustomer(@ApiParam(required = true, name = "用户id") @PathParam("userid") int userid) {
        List<AgClient> list = userService.getCustomer(userid);
        return ResponseTemplate.ok(list);
    }


    /**
     * 下母单页面显示当前登录用户的产品名所对应的策略
     *
     * @param clientId
     * @return
     */
    @GET
    @Path("/findStrategy/{clientId}")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "下母单展示当前产品对应的策略rest api", notes = "rest api")
    @ApiImplicitParam(paramType = "path", required = true, name = "账户id")
    @Consumes(JSON_UTF8)
    public ResponseTemplate<List<AgAccount>> findStrategy(@ApiParam(required = true, name = "账户id") @PathParam("clientId") int clientId) {
        List<AgAccount> list = userService.getStrategy(clientId);
        return ResponseTemplate.ok(list);
    }

    /**
     * 验证用户所对应的手机
     *
     * @param phone
     * @param username
     * @return
     */
    @GET
    @Path("/check/{phone}/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "验证用户对应的手机rest api", notes = "rest api")
    @Consumes(JSON_UTF8)
    public ResponseTemplate<Void> checkPhone(@ApiParam(name = "手机号码", required = true) @PathParam("phone") String phone, @ApiParam(name = "用户名", required = true) @PathParam("username") String username) {
        log.info("REST: checkPhone /check " + phone, username);
        WsUser user = userService.getPhone(phone, username);
        if(user != null && user.getUsername().equals(username)) {
            // 代表返回正确
            return ResponseTemplate.ok();
        }
        // 代表没找到这个手机号对应用户
        return ResponseTemplate.failed(Response.Status.BAD_REQUEST, "没找到这个手机号");
    }

    /**
     * 给登录页面提供的一次握手
     *
     * @return
     */
    @GET
    @Path("/login")
    @ApiOperation(value = "给登录页面提供的一次握手 api", notes = "rest api")
    @Produces(JSON_UTF8)
    public ResponseTemplate<Void> loginTest() {
        return ResponseTemplate.ok();
    }

    /**
     * 登录
     *
     * @return
     */
    @POST
    @Path("/login")
    @ApiOperation(value = "登录", notes = "rest api")
    @Produces(JSON_UTF8)
    @Consumes(JSON_UTF8)
    public ResponseTemplate<LogonResult> login(LogonReq logonReq) {
        LogonResult result = new LogonResult(true);

        log.info("REST: user/login , {}", logonReq.toString());
        if(usernameEnable) {
            String pwd = DigestUtils.md5Hex(Md5Encrypt.getContentBytes(logonReq.getPassword(), "UTF-8"));
            result = userService.logon(logonReq.getUsername(), pwd);
            if(!result.isSuccess() || !result.getWsUser().isPresent()) {
                return ResponseTemplate.failed(Response.Status.INTERNAL_SERVER_ERROR, "用户名或密码错误");
            }
        }

        if(phoneEnable) {
            WsPhone wsPhone = userService.getPhone(logonReq.getPhone());
            if(null == wsPhone) {
                return ResponseTemplate.failed(Response.Status.INTERNAL_SERVER_ERROR, "手机号不存在");
            }

            if(usernameEnable) {
                if(!wsPhone.getUserId().equals(result.getWsUser().get().getUserid())) {
                    return ResponseTemplate.failed(Response.Status.INTERNAL_SERVER_ERROR, "该用户没有这个手机号");
                }
            } else {
                WsUser wsUser = userService.getid(wsPhone.getUserId());
                if(null == wsUser) {
                    return ResponseTemplate.failed(Response.Status.INTERNAL_SERVER_ERROR, "该手机号没有对应用户");
                }
                result.setWsUser(wsUser);
            }
        }

        if(smsCodeEnable) {
            SendCodeBean sendCode = smsRestfulApi.getSendCodeBean(logonReq.getPhone());
            if(null == sendCode) {
                return ResponseTemplate.failed(Response.Status.INTERNAL_SERVER_ERROR, "请先获取验证码");
            } else {
                if(!logonReq.getSmsCode().equals(sendCode.getCode())) {
                    return ResponseTemplate.failed(Response.Status.INTERNAL_SERVER_ERROR, "验证码错误");
                }
                if(LocalDateTime.now().isAfter(sendCode.getExpiredTime())) {
                    return ResponseTemplate.failed(Response.Status.INTERNAL_SERVER_ERROR, "验证码过期");
                }
            }
        }

        // 生成一个随机整数
        Random random = new Random();
        String token = logonReq.getUsername() + logonReq.getPassword() + random.nextInt();
        log.info(
                "REST: get login message token/login" + DigestUtils.md5Hex(Md5Encrypt.getContentBytes(token, "UTF-8")));
        result.setToken(DigestUtils.md5Hex(Md5Encrypt.getContentBytes(token, "UTF-8")));
        SendCodeBean sendCodeBean = SendCodeBean.newToken(result.getToken(), LocalDateTime.now().plusMinutes(120));

        if(result.getWsUser() != null && result.getWsUser().isPresent()) {
            sendCodeBean.setWsUser(result.getWsUser().get());
            List<WsUserRole> wsUserRoleList = userService.queryByUserId(Arrays.asList(result.getWsUser().get().getUserid()));
            sendCodeBean.setWsUserRoleList(wsUserRoleList);
        }
        orderRestfulApi.putSendCodeBean(result.getToken(), sendCodeBean);

        WsAuditTrail wat = new WsAuditTrail();
        wat.setUsername(logonReq.getUsername());
        wat.setOpType(OpType.Login);
        wat.setDescribe("登录操作");
        wat.setTime(new Date());
        waService.insert(wat);
        return ResponseTemplate.ok(result);
    }

}
