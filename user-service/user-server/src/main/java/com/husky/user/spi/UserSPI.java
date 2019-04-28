package com.husky.user.spi;

import com.husky.common.dto.HuskyResult;
import com.husky.common.enums.SysExceptionEnum;
import com.husky.user.api.UserAPI;
import com.husky.user.dto.UserDTO;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Random;

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

        int intData = RandomUtils.nextInt(1,2);
        if(intData == 1){
            throw SysExceptionEnum.UNKNOW_ERROR.get();
        }
        return HuskyResult.doSuccess(userDTO);
    }

    public String hello(){
        return "12";
    }

    @PostMapping("/2")
    public HuskyResult<UserDTO> getUser2(@RequestBody UserDTO userDTO,HttpServletRequest request){
        int intData = RandomUtils.nextInt(1,2);
        if(intData == 1){
            throw SysExceptionEnum.UNKNOW_ERROR.get();
        }
        return HuskyResult.doSuccess(userDTO);
    }
}
