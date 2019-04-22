package com.husky.test.api;

import com.husky.common.dto.HuskyResult;
import com.husky.test.constant.TestAPIConstants;
import com.husky.test.dto.TestDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by gexiaobing on 2019-04-19
 *
 * @description TODO
 */
@FeignClient(TestAPIConstants.SERVER_NAME)
@RequestMapping("/test")
public interface TestAPI {

    @GetMapping
    HuskyResult<TestDTO> getTest();
}
