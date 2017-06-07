/*
 * Author: Suny Xie
 * Email: inbox@xieziming.com
 * Copyright (c) 2017 xieziming.com All rights reserved.
 */

package com.xieziming.tap.agent.service;

import com.xieziming.tap.dto.execution.Execution;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

import java.util.List;

/**
 * Created by Suny on 5/30/17.
 */

public interface ExecutionService {
    @RequestLine("GET /executions")
    List<Execution> getExecutions();

    @RequestLine("GET /executions/{id}")
    @Headers("Accept: application/json")
    Execution getExecution(@Param("id") Integer id);
}
