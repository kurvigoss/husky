package com.husky.user.spi;

import com.husky.common.dto.HuskyResult;
import com.husky.user.api.UserAPI;
import com.husky.user.dto.UserDTO;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by gexiaobing on 2019-04-19
 *
 * @description TODO
 */
@RestController
public class UserSPI implements UserAPI {

    @Override
    public HuskyResult<UserDTO> getUser() {
        UserDTO userDTO = new UserDTO();
        userDTO.setName("kakarot");
        userDTO.setAge(23);
        userDTO.setCity("上海");

        return HuskyResult.doSuccess(userDTO);
    }

    public String hello(){
        return "12";
    }
}
