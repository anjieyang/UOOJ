package com.anjieyang.uooj.common.exception;

import lombok.Data;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@Data
public class RuntimeError extends Exception {
    private String message;
    private String stdout;
    private String stderr;

    public RuntimeError(String message, String stdout, String stderr) {
        super(message);
        this.message = message;
        this.stdout = stdout;
        this.stderr = stderr;
    }
}