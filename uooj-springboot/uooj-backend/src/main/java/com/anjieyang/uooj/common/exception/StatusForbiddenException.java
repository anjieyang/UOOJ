package com.anjieyang.uooj.common.exception;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
public class StatusForbiddenException extends Exception{

    public StatusForbiddenException() {
    }

    public StatusForbiddenException(String message) {
        super(message);
    }

    public StatusForbiddenException(String message, Throwable cause) {
        super(message, cause);
    }

    public StatusForbiddenException(Throwable cause) {
        super(cause);
    }

    public StatusForbiddenException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}