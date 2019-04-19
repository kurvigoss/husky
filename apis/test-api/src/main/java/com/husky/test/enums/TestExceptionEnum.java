package com.husky.test.enums;

import com.husky.common.exception.IExceptionEnum;

/**
 * Created by gexiaobing on 2019-04-19
 *
 * @description 测试异常枚举
 */
public enum TestExceptionEnum implements IExceptionEnum {

    ;
    private String code;

    private String message;

    TestExceptionEnum(String code, String message) {
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
