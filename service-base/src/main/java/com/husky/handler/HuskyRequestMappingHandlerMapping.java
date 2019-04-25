package com.husky.handler;

import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * Created by gexiaobing on 2019-04-25
 *
 * @description
 * 1. 重写RequestMappingHandlerMapping：只将有Controller注解的bean判定为handler,解决了FeignClient和它的Hystrix fallback注册到mappingRegistry的问题
 */
public class HuskyRequestMappingHandlerMapping extends RequestMappingHandlerMapping {

    @Override
    protected boolean isHandler(Class<?> beanType) {
        return AnnotatedElementUtils.hasAnnotation(beanType, Controller.class);
    }

}
