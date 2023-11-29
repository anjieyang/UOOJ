package com.anjieyang.uooj.common.exception;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
public class StatusAccessDeniedException extends Exception {

    public StatusAccessDeniedException() {
    }

    public StatusAccessDeniedException(String message) {
        super(message);
    }

    public StatusAccessDeniedException(String message, Throwable cause) {
        super(message, cause);
    }

    public StatusAccessDeniedException(Throwable cause) {
        super(cause);
    }

    public StatusAccessDeniedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}