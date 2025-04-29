package com.example.demo.controller;

import com.example.demo.entity.MultiAgentServiceLog;
import com.example.demo.service.MultiAgentServiceLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
public class MultiAgentServiceLogController {

    @Autowired
    private MultiAgentServiceLogService multiAgentServiceLogService;

    @Autowired
    private Environment environment;

    @GetMapping("findByRequestId")
    public Flux<MultiAgentServiceLog> findByRequestId(@RequestParam String requestId) {
        return multiAgentServiceLogService.findByRequestId(requestId);
    }

    @GetMapping("config")
    public Mono<Map<String,String>> config(){

        return Mono.just(environment).map(e->{
            Map<String,String> config = new HashMap<>();
            config.put("url",e.getProperty("spring.r2dbc.url"));
            config.put("username",e.getProperty("spring.r2dbc.username"));
            config.put("password",e.getProperty("spring.r2dbc.password"));
            return config;
        });
    }
}
