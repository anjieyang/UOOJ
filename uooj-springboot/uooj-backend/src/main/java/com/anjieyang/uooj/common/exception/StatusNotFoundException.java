package com.anjieyang.uooj.common.exception;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
public class StatusNotFoundException extends Exception{

    public StatusNotFoundException() {
    }

    public StatusNotFoundException(String message) {
        super(message);
    }

    public StatusNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public StatusNotFoundException(Throwable cause) {
        super(cause);
    }

    public StatusNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}