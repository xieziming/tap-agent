/*
 * Author: Suny Xie
 * Email: inbox@xieziming.com
 * Copyright (c) 2017 xieziming.com All rights reserved.
 */

package com.xieziming.tap.agent.service;

import com.xieziming.tap.dto.status.HealthStatus;
import com.xieziming.tap.dto.testcase.TestCase;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

/**
 * Created by Suny on 5/30/17.
 */

public interface TestCaseService {
    @RequestLine("GET /health")
    HealthStatus health();

    @RequestLine("GET /testCases/{uid}")
    @Headers("Accept: application/json")
    TestCase getTestCase(@Param("uid") String uid);
}
