package com.bootcamp.java.clientredis.service.clientType;

import com.bootcamp.java.clientredis.dto.ClientTypeDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IClientTypeServiceRedis {

    Mono<ClientTypeDTO> findByIdClientType(Integer IdClientType);

    Flux<ClientTypeDTO> findAll();
}
