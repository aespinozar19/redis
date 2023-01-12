package com.bootcamp.java.clientredis.converter;

import com.bootcamp.java.clientredis.dto.ClientTypeDTO;
import com.bootcamp.java.clientredis.entity.ClientTypeEntity;
import org.springframework.stereotype.Component;

@Component
public class ClientTypeConverter {
    public ClientTypeEntity ConvertDTOToEntity(ClientTypeDTO clientTypeDTO){
        return ClientTypeEntity.builder()
                .id(clientTypeDTO.getId())
                .idClientType(clientTypeDTO.getIdClientType())
                .description(clientTypeDTO.getDescription())
                .build();
    }

    public ClientTypeDTO ConvertEntityToDTO(ClientTypeEntity clientTypeEntity) {
        return ClientTypeDTO.builder()
                .id(clientTypeEntity.getId())
                .idClientType(clientTypeEntity.getIdClientType())
                .description(clientTypeEntity.getDescription())
                .build();
    }
}
