package com.kafang.atgo;


import lombok.Getter;

/**
 * @author xuejian.sun
 * @date 2018/10/10 12:58
 */
public enum AtgoErrorCode {

    /**
     * 验证失败
     */
    VALIDATION_ERROR("验证出错",-1),

    /**
     * 认证失败，未登录
     */
    AUTHORIZATION_ERROR("认证失败",-2,401),

    /**
     * mq 参数错误
     */
    MQ_PARAMETER_ERROR("MQ参数错误",-1),

    /**
     * mq连接失败
     */
    MQ_CONNECT_ERROR("MQ连接错误",-1),

    /**
     * web请求参数错误
     */
    REQUEST_PARAMETER_ERROR("请求参数错误",-1,400),

    /**
     * 权限认证失败，无权限
     */
    PERMISSION_ERROR("权限认证失败",-1,403),

    /**
     * 查询数据库错误
     */
    QUERY_DATABASE_ERROR("查询数据库出错",-1,500),

    /**
     * 更新数据库出错
     */
    UPDATE_DATABASE_ERROR("更新数据库出错",-1,500),
    /**
     * 用户误操作
     */
    USER_MALOPERATION_ERROR("误操作",-2,200),
    /**
     * other error
     */
    OTHER_ERROR("",-1,500);

    @Getter
    private String defaultErrorMsg;

    @Getter
    private int errorCode;

    @Getter
    private int httpStatusCode;


    AtgoErrorCode(String defaultErrorMsg,int errorCode) {
        this.errorCode = errorCode;
        this.defaultErrorMsg = defaultErrorMsg;
    }

    AtgoErrorCode(String defaultErrorMsg, int errorCode, int httpStatusCode) {
        this.defaultErrorMsg = defaultErrorMsg;
        this.errorCode = errorCode;
        this.httpStatusCode = httpStatusCode;
    }
}
