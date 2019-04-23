package com.husky.test.api;

import com.husky.common.dto.HuskyResult;
import com.husky.test.constant.TestAPIConsts;
import com.husky.test.dto.TestDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by gexiaobing on 2019-04-19
 *
 * @description TODO
 */
@FeignClient(TestAPIConsts.SERVER_NAME)
@RequestMapping("/test")
@Api(tags = "测试服务")
public interface TestAPI {

    @GetMapping
    @ApiOperation("获取测试数据")
    HuskyResult<TestDTO> getTest();
}
