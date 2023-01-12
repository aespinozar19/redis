package com.bootcamp.java.clientredis.service.clientType;

import com.bootcamp.java.clientredis.dto.ClientTypeDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.redis.core.ReactiveHashOperations;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@ConditionalOnProperty(name = "cache.enabled", havingValue = "true")
public class ClientTypeServiceWithRedisCache extends  ClientTypeServiceWithNoCache {

    private static final String KEY = "client";

    @Autowired
    private ReactiveHashOperations<String, Integer, ClientTypeDTO> hashOperations;

    @Override
    public Mono<ClientTypeDTO> findByIdClientType(Integer id) {
        log.info("ClientTypeServiceWithRedisCache: {}","findByIdClientType");
        return hashOperations.get(KEY, id)
                .switchIfEmpty(this.getFromDatabaseAndCache(id));
    }

    private Mono<ClientTypeDTO> getFromDatabaseAndCache(Integer id) {
        return super.findByIdClientType(id)
                .flatMap(dto -> {
                    log.info("getFromDatabaseAndCache1: {}",dto.toString());

                    return this.hashOperations.put(KEY, id, dto).thenReturn(dto);
                });

    }

}
