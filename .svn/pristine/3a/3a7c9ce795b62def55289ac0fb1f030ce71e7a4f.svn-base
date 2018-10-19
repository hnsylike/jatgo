package com.kafang.atgo;

import lombok.Getter;
import org.springframework.util.StringUtils;

/**
 * Created by User on 2018/9/10.
 */
public class AtgoException extends RuntimeException {

    private static final long serialVersionUID = 1460028338026084653L;

    @Getter
    private AtgoErrorCode atgoErrorCode = AtgoErrorCode.OTHER_ERROR;

    @Getter
    private String errorMessage;

    @Getter
    private Throwable throwable;

    public AtgoException(){
        super();
    }

    public AtgoException(String message) {
        super(message);
        this.errorMessage = message;
    }

    public AtgoException(String message, Throwable cause) {
        super(message, cause);
        this.errorMessage = message;
        this.throwable = cause;
    }

    public AtgoException(AtgoErrorCode atgoErrorCode, String message) {
        super(message);
        this.atgoErrorCode = atgoErrorCode;
        if(StringUtils.isEmpty(message) && atgoErrorCode != null) {
            message = atgoErrorCode.getDefaultErrorMsg();
        }
        this.errorMessage = message;
    }

    public AtgoException(AtgoErrorCode atgoErrorCode, String message, Throwable throwable) {
        super(message,throwable);
        this.atgoErrorCode = atgoErrorCode;
        this.throwable = throwable;
        if(StringUtils.isEmpty(message) && atgoErrorCode != null) {
            message = atgoErrorCode.getDefaultErrorMsg();
        }
        this.errorMessage = message;
    }

    public AtgoException(AtgoErrorCode atgoErrorCode,Throwable throwable) {
        super(atgoErrorCode.getDefaultErrorMsg(),throwable);
        this.atgoErrorCode = atgoErrorCode;
        this.throwable = throwable;
    }

    public AtgoException(Throwable cause) {
        super(cause);
    }

}
