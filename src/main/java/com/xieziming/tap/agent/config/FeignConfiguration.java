/*
 * Author: Suny Xie
 * Email: inbox@xieziming.com
 * Copyright (c) 2017 xieziming.com All rights reserved.
 */

package com.xieziming.tap.agent.config;

import com.xieziming.tap.agent.service.ExecutionService;
import com.xieziming.tap.agent.service.TestCaseService;
import feign.Feign;
import feign.auth.BasicAuthRequestInterceptor;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Suny on 5/30/17.
 */
@Configuration
public class FeignConfiguration {
    @Value("${com.xieziming.tap.execution-service-url}")
    String executionServiceUrl;

    @Value("${com.xieziming.tap.testcase-service-url}")
    String testCaseServiceUrl;

    @Bean(name = "executionService")
    public ExecutionService executionService(){
        return getFeignBuilder().target(ExecutionService.class, executionServiceUrl);
    }

    @Bean(name = "testCaseService")
    public TestCaseService testCaseService(){
        return getFeignBuilder().target(TestCaseService.class, testCaseServiceUrl);
    }

    private Feign.Builder getFeignBuilder(){
        return Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .requestInterceptor(new BasicAuthRequestInterceptor("tap", "tap"));
    }
}
