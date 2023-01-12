package com.bootcamp.java.clientredis.config;

import com.bootcamp.java.clientredis.dto.ClientTypeDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveHashOperations;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

@Slf4j
@Configuration
@ConditionalOnProperty(name = "cache.enabled", havingValue = "true")
public class RedisConfig {

    private static final String KEY = "client";

    @Bean
    public ReactiveHashOperations<String, Integer, ClientTypeDTO> hashOperations(ReactiveRedisConnectionFactory redisConnectionFactory){
        var template = new ReactiveRedisTemplate<>(
                redisConnectionFactory,
                RedisSerializationContext.<String, ClientTypeDTO>newSerializationContext(new StringRedisSerializer())
                                         .hashKey(new GenericToStringSerializer<>(Integer.class))
                                         .hashValue(new Jackson2JsonRedisSerializer<>(ClientTypeDTO.class))
                                         .build()
        );

        /*template.expire(KEY, Duration.ofMillis(2000));

        Instant instant = new Date().toInstant();
        log.info("instant: {}", instant);
        log.info("instant.plus: {}", instant.plusSeconds(10));

        template.expireAt(KEY, instant.plusSeconds(10));
        */
        return template.opsForHash();
    }


}
