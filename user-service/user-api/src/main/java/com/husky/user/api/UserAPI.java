package com.husky.user.api;

import com.husky.common.dto.HuskyResult;
import com.husky.user.constant.UserAPIConstants;
import com.husky.user.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by gexiaobing on 2019-04-19
 *
 * @description TODO
 */
@FeignClient(UserAPIConstants.SERVER_NAME)
@RequestMapping("/user")
public interface UserAPI {

    @GetMapping
    HuskyResult<UserDTO> getUser();
}
