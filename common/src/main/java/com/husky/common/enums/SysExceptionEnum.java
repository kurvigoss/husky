package com.husky.common.enums;

import com.husky.common.exception.IExceptionEnum;

/**
 * Created by gexiaobing on 2019-04-19
 *
 * @description
 *  系统异常枚举(001-999)，其中'1**'~'5**'保留给http,其它可自行调配
 *  其他业务模块异常从1000开始
 *  比如:
 *      A模块：1000~1999
 *      B模块：2000~2999
 *      C模块：3000~3999
 */
public enum SysExceptionEnum implements IExceptionEnum {

    UNKNOW_ERROR("001","系统未知异常");

    private String code;

    private String message;

    SysExceptionEnum(String code, String message) {
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
