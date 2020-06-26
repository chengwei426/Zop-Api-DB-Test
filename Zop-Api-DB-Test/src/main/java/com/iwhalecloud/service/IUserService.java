package com.iwhalecloud.service;

import com.iwhalecloud.common.ResponseData;
import com.iwhalecloud.entity.ApiPerformanceTesting;
import org.apache.ibatis.annotations.Param;

interface IUserService {
    ResponseData simple();

    ApiPerformanceTesting fetchApiPerformanceTestingByCode(String testCode);

    ApiPerformanceTesting getApiPerformanceTestingById(@Param("id") String id);

    int modifyApiPerformanceTesting(ApiPerformanceTesting apiPerformanceTesting);

    int addApiPerformanceTesting(ApiPerformanceTesting apiPerformanceTesting);
}
