/*
 * Author: Suny Xie
 * Email: inbox@xieziming.com
 * Copyright (c) 2017 xieziming.com All rights reserved.
 */

package com.xieziming.tap.agent.service;

import com.xieziming.tap.dto.execution.Execution;
import com.xieziming.tap.dto.testcase.TestCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Suny on 5/30/17.
 */
@RestController
public class ExecutionController {
    @Autowired
    ExecutionService executionService;

    @Autowired
    TestCaseService testCaseService;

    @RequestMapping("/hi")
    public Execution getExecution(){
        return executionService.getExecution(1);
    }

    @RequestMapping("/testCases/{uid}")
    public TestCase getTestCase(@PathVariable String uid){
        return testCaseService.getTestCase(uid);
    }
}
