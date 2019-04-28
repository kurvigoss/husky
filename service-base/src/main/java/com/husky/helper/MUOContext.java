package com.husky.helper;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gexiaobing on 2019-04-28
 *
 * @description 用户请求上下文
 */
public abstract class MUOContext {

    private static ThreadLocal<Map<String,Object>> threadLocal = new ThreadLocal<>();

    public static final String HANDLER_METHOD_ARGS = "handler_method_args";

    private static Map<String, Object> getMap() {
        Map<String, Object> map = (Map)threadLocal.get();
        if (map == null) {
            map = new HashMap();
            threadLocal.set(map);
        }

        return (Map)map;
    }

    public static void setValue(String key, Object val) {
        getMap().put(key, val);
    }

    public static <T> T getValue(String key) {
        Object val = getMap().get(key);
        return val == null ? null : (T)val;
    }

    public static Object[] getHandleMethodArgs(){
        return getValue(HANDLER_METHOD_ARGS);
    }

    public static void setHandlerMethodArgs(Object[] args){
        setValue(HANDLER_METHOD_ARGS,args);
    }

    public static void clean() {
        threadLocal.remove();
    }
}
