package com.husky.test.spi;

import com.husky.common.dto.HuskyResult;
import com.husky.test.api.TestAPI;
import com.husky.test.dto.TestDTO;
import com.husky.user.api.UserAPI;
import com.husky.user.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by gexiaobing on 2019-04-19
 *
 * @description TODO
 */
@RestController
public class TestSPI implements TestAPI {

    @Autowired
    UserAPI userAPI;

    @Override
    public HuskyResult<TestDTO> getTest() {
        HuskyResult<UserDTO> userDTOHuskyResult = userAPI.getUser();
        TestDTO testDTO = new TestDTO();
        testDTO.setTestName("test001");
        testDTO.setUserJsonData(userDTOHuskyResult.getData().toString());
        return HuskyResult.doSuccess(testDTO);
    }
}
