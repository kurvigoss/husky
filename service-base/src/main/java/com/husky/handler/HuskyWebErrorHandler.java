package com.husky.handler;

import com.husky.common.dto.HuskyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by gexiaobing on 2019-04-23
 *
 * @description server异常处理
 */
@RestController
@RequestMapping("${server.error.path:${error.path:/error}}")
public class HuskyWebErrorHandler implements ErrorController {

    @Autowired
    ServerProperties serverProperties;

    @Override
    public String getErrorPath() {
        return serverProperties.getError().getPath();
    }

    @RequestMapping
    public HuskyResult error(HttpServletRequest request) {
        HttpStatus status = getStatus(request);
        HuskyResult huskyResult = HuskyResult.doError();
        huskyResult.setCode(String.valueOf(status.value()));
        huskyResult.setMessage(status.toString());
        return huskyResult;
    }


    protected HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request
                .getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        try {
            return HttpStatus.valueOf(statusCode);
        }
        catch (Exception ex) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }

}
