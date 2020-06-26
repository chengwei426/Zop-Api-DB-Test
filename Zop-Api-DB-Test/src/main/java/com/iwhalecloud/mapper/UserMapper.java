package com.iwhalecloud.mapper;

import org.apache.ibatis.annotations.Param;
import com.iwhalecloud.entity.ApiPerformanceTesting;

public interface UserMapper {

    ApiPerformanceTesting fetchApiPerformanceTestingByCode(@Param("testCode") String testCode);

    ApiPerformanceTesting getApiPerformanceTestingById(@Param("id") String id);

    int modifyApiPerformanceTesting(ApiPerformanceTesting apiPerformanceTesting);

    int addApiPerformanceTesting(ApiPerformanceTesting apiPerformanceTesting);
}
