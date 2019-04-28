package com.husky.handler;

import com.husky.helper.MUOContext;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod;

import java.lang.reflect.Method;

/**
 * Created by gexiaobing on 2019-04-28
 *
 * @description 自定义InvocableHandleMethod,发生异常时将handlerMethod的参数设置到MUOContext中，方便获取
 */
public class HuskyInvocableHandleMethod extends ServletInvocableHandlerMethod {

    public HuskyInvocableHandleMethod(Object handler, Method method) {
        super(handler, method);
    }

    public HuskyInvocableHandleMethod(HandlerMethod handlerMethod) {
        super(handlerMethod);
    }

    @Override
    protected Object doInvoke(Object... args) throws Exception {
        MUOContext.setHandlerMethodArgs(null);
        try {
            return super.doInvoke(args);
        }catch (Exception e){
            MUOContext.setHandlerMethodArgs(args);
            throw e;
        }
    }
}
