package com.husky.user.enums;

import com.husky.common.exception.IExceptionEnum;

/**
 * Created by gexiaobing on 2019-04-19
 *
 * @description 用户异常枚举
 */
public enum UserExceptionEnum implements IExceptionEnum {

    ;
    private String code;

    private String message;

    UserExceptionEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
