package com.bootcamp.java.clientredis.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientTypeDTO {

    private String id;

    private int idClientType;

    private String description;
}
