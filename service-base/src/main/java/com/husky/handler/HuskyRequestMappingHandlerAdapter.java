package com.husky.handler;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod;

/**
 * Created by gexiaobing on 2019-04-28
 *
 * @description
 *  1. 重写RequestMappingHandlerAdapter中createInvocableHandlerMethod方法，替换为HuskyInvocableHandleMethod
 */
public class HuskyRequestMappingHandlerAdapter extends RequestMappingHandlerAdapter {

    @Override
    protected ServletInvocableHandlerMethod createInvocableHandlerMethod(HandlerMethod handlerMethod) {
        return new HuskyInvocableHandleMethod(handlerMethod);
    }
}
