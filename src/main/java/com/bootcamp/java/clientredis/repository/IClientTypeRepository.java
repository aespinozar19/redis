package com.bootcamp.java.clientredis.repository;


import com.bootcamp.java.clientredis.entity.ClientTypeEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface IClientTypeRepository extends ReactiveMongoRepository<ClientTypeEntity, String> {
    Mono<ClientTypeEntity> findByIdClientType(Integer idClientType);
}
