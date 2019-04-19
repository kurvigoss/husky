package com.husky.common.exception;

/**
 * Created by gexiaobing on 2019-04-19
 *
 * @description 异常枚举需要实现的接口
 */
public interface IExceptionEnum {

    String getCode();

    String getMessage();

    /**
     * 获取异常
     * @return
     */
    default HuskyException get(){
        return new HuskyException(getCode(),getMessage());
    }

    /**
     * 获取异常
     * @param cause
     * @return
     */
    default HuskyException get(Throwable cause){
        return new HuskyException(getCode(),getMessage(),cause);
    }
}
