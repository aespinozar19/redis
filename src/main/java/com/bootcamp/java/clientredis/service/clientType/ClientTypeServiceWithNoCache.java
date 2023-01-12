package com.bootcamp.java.clientredis.service.clientType;


import com.bootcamp.java.clientredis.converter.ClientTypeConverter;
import com.bootcamp.java.clientredis.dto.ClientTypeDTO;
import com.bootcamp.java.clientredis.repository.IClientTypeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@ConditionalOnProperty(name = "cache.enabled", havingValue = "false")
public class ClientTypeServiceWithNoCache implements IClientTypeServiceRedis{

    @Autowired
    private IClientTypeRepository iClientTypeRepository;

    @Autowired
    private ClientTypeConverter clientTypeConverter;

    @Override
    public Mono<ClientTypeDTO> findByIdClientType(Integer IdClientType) {
        log.debug("finById");
        Mono<ClientTypeDTO> dataMClientDTO= iClientTypeRepository.findByIdClientType(IdClientType)
                .map(clientEntity -> clientTypeConverter.ConvertEntityToDTO(clientEntity));
        return dataMClientDTO;
    }

    @Override
    public Flux<ClientTypeDTO> findAll() {
        return null;
    }

}
