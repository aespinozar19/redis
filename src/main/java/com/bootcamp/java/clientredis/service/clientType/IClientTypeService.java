package com.bootcamp.java.clientredis.service.clientType;

import com.bootcamp.java.clientredis.dto.ClientTypeDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IClientTypeService {
    public Flux<ClientTypeDTO> findAll();
    public Mono<ClientTypeDTO> findByIdClientType(Integer IdClientType);
}
