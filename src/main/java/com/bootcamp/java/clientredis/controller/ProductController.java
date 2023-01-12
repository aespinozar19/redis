package com.bootcamp.java.clientredis.controller;

import com.bootcamp.java.clientredis.dto.ClientTypeDTO;
import com.bootcamp.java.clientredis.service.clientType.IClientTypeServiceRedis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private IClientTypeServiceRedis productService;

    @GetMapping("{id}")
    public Mono<ClientTypeDTO> getProduct(@PathVariable Integer id){
        return this.productService.findByIdClientType(id);
    }

}
