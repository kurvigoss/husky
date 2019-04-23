package com.husky.user.api;

import com.husky.common.dto.HuskyResult;
import com.husky.user.constant.UserAPIConsts;
import com.husky.user.dto.UserDTO;
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
@FeignClient(UserAPIConsts.SERVER_NAME)
@RequestMapping("/user")
@Api(tags = "用户服务")
public interface UserAPI {

    @GetMapping
    @ApiOperation("获取用户")
    HuskyResult<UserDTO> getUser();
}
