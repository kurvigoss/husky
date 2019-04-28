package com.husky.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

/**
 * Created by gexiaobing on 2019-04-28
 *
 * @description 基于路径的拦截器
 */
public interface PathPatternInterceptor extends HandlerInterceptor {

    /**
     * 获取拦截的url
     *
     * @return
     */
    String getPathPattern();
}
