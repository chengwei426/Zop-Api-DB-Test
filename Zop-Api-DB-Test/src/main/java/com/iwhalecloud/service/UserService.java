package com.iwhalecloud.service;

import com.iwhalecloud.common.ResponseData;
import com.iwhalecloud.entity.ApiPerformanceTesting;
import com.iwhalecloud.mapper.UserMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Service
@Transactional
public class UserService implements IUserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public ResponseData simple() {
        ResponseData<String> result = new ResponseData<>("200", "success");
        result.setData("hello world");
        return result;
    }

    @Override
    public ApiPerformanceTesting fetchApiPerformanceTestingByCode(String testCode) {
        testCode= StringUtils.isEmpty(testCode) ? "apiCode" : testCode;
        return userMapper.fetchApiPerformanceTestingByCode(testCode);
    }

    @Override
    public ApiPerformanceTesting getApiPerformanceTestingById(@Param("id") String id) {
        if (StringUtils.isEmpty(id)) {
            return  null;
        }

        return userMapper.getApiPerformanceTestingById(id);

    }


    @Override
    public int modifyApiPerformanceTesting(ApiPerformanceTesting apiPerformanceTesting) {
        apiPerformanceTesting.setTestCode("apiCode");
        return userMapper.modifyApiPerformanceTesting(apiPerformanceTesting);
    }

    @Override
    public int addApiPerformanceTesting(ApiPerformanceTesting apiPerformanceTesting) {
        apiPerformanceTesting.setTestCode("apiCode");
        return userMapper.addApiPerformanceTesting(apiPerformanceTesting);
    }
}
