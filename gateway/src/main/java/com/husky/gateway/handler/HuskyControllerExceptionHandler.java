package com.husky.gateway.handler;

import com.husky.common.dto.HuskyResult;
import com.husky.common.exception.HuskyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Created by gexiaobing on 2019-04-22
 *
 * @description controller异常处理
 */
@ControllerAdvice
public class HuskyControllerExceptionHandler {

    private static Logger logger = LoggerFactory.getLogger(HuskyControllerExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    public HuskyResult resolveException(Exception e){
        logger.error(e.getMessage(),e);
        if(e instanceof HuskyException){
            return HuskyResult.doError((HuskyException)e);
        }else {
            return HuskyResult.doError();
        }
    }
}
