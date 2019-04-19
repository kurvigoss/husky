package com.husky.common.exception;

/**
 * Created by gexiaobing on 2019-04-19
 *
 * @description 异常类
 */
public class HuskyException extends RuntimeException {

    private String code;

    private String message;

    public HuskyException(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public HuskyException(String code, String message,Throwable cause) {
        super(message, cause);
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
