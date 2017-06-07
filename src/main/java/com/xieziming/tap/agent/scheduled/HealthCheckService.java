/*
 * Author: Suny Xie
 * Email: inbox@xieziming.com
 * Copyright (c) 2017 xieziming.com All rights reserved.
 */

package com.xieziming.tap.agent.scheduled;

import com.xieziming.tap.agent.service.TestCaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Created by Suny on 6/7/17.
 */
@Service
@Slf4j
public class HealthCheckService {
    @Autowired
    TestCaseService testCaseService;

    @Scheduled(fixedRate = 60000)
    public void checkTestCaseService(){
        log.info("Test Case Service : " + testCaseService.health().getStatus());
    }
}
