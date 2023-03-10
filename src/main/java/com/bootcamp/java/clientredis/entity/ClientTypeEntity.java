package com.bootcamp.java.clientredis.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Data
@Builder
@ToString
@EqualsAndHashCode(of = {"IdClientType"})
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "tbl_clientType")
public class ClientTypeEntity {
    @Id
    @JsonIgnore
    private String id;

    @NotNull
    @Indexed(unique = true)
    private int idClientType;

    @NotNull
    private String description;

}
