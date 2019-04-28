package com.husky.handler;

import com.alibaba.fastjson.JSONObject;
import com.husky.common.dto.HuskyResult;
import com.husky.common.exception.HuskyException;
import com.husky.config.SentryConfig;
import com.husky.helper.MUOContext;
import io.sentry.Sentry;
import io.sentry.event.UserBuilder;
import org.apache.commons.lang.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.HandlerMethod;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * Created by gexiaobing on 2019-04-22
 *
 * @description controller异常处理
 */
@RestControllerAdvice
public class HuskyControllerExceptionHandler {

    private static Logger logger = LoggerFactory.getLogger(HuskyControllerExceptionHandler.class);

    @Autowired
    ObjectProvider<SentryHandler> sentryHandlerProvider;

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    public HuskyResult resolveException(Exception e, HandlerMethod handlerMethod, HttpServletRequest request){

        doCapture(e,handlerMethod,request.getRequestURI());

        if(e instanceof HuskyException){
            return HuskyResult.doError((HuskyException)e);
        }else {
            return HuskyResult.doError();
        }
    }

    /**
     * 收集异常信息至sentry
     * @param e
     * @param handlerMethod
     * @param uri
     */
    private void doCapture(Exception e,HandlerMethod handlerMethod,String uri){

        Object[] handleMethodArgs = MUOContext.getHandleMethodArgs();
        final MethodParameter[] methodParameters = handlerMethod.getMethodParameters();

        JSONObject argsJSON = new JSONObject();
        if(!ArrayUtils.isEmpty(methodParameters)){
            for(MethodParameter methodParameter:methodParameters){
                if(isSkip(methodParameter))
                    continue;
                Object handleMethodArg = handleMethodArgs[methodParameter.getParameterIndex()];
                argsJSON.put(methodParameter.getParameterName(),handleMethodArg.toString());
            }
        }
        logger.error("URI[{}]出错了,请求参数为:\n{}",uri,argsJSON);
        logger.error(e.getMessage(),e);

        sentryHandlerProvider.ifAvailable(sentryHandler -> sentryHandler.captureApiException(uri,argsJSON,e));
    }

    /**
     * 是否忽略该参数，
     * 1.如果paramType为接口，则返回true
     * 2.如果paramType的toString为Object，则返回true
     * @return
     */
    private boolean isSkip(MethodParameter methodParameter){
        if(methodParameter == null){
            return true;
        }

        if(methodParameter.getParameterType().isInterface())
            return true;
        Method toStringMethod = ClassUtils.getMethod(methodParameter.getParameterType(), "toString");
        return toStringMethod.getDeclaringClass().equals(Object.class);
    }

}
