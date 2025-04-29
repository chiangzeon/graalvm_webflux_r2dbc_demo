package com.example.demo.service;

import com.example.demo.dao.MultiAgentServiceLogRepository;
import com.example.demo.entity.MultiAgentServiceLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class MultiAgentServiceLogService {

    @Autowired
    private MultiAgentServiceLogRepository multiAgentServiceLogRepository;

    public Flux<MultiAgentServiceLog> findByRequestId(String requestId) {
        return multiAgentServiceLogRepository.findByRequestId(requestId);
    }
}
