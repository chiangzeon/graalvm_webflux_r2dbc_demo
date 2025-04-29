package com.example.demo.dao;

import com.example.demo.entity.MultiAgentServiceLog;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface MultiAgentServiceLogRepository extends ReactiveCrudRepository<MultiAgentServiceLog,Long> {

    Flux<MultiAgentServiceLog> findByRequestId(String requestId);
}
