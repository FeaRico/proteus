package ru.makhach.proteus.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.Jedis;

import javax.annotation.PostConstruct;
import java.io.Serializable;

@Configuration
@AutoConfigureAfter(RedisAutoConfiguration.class)
@EnableCaching
public class RedisConfig {
    @Value("${spring.redis.host}")
    private String redisHost;
    @Value("${spring.redis.port}")
    private Integer redisPort;

    @Bean
    public RedisTemplate<String, Serializable> redisCacheTemplate(LettuceConnectionFactory connectionFactory) {
        RedisTemplate<String, Serializable> template = new RedisTemplate<>();
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        template.setConnectionFactory(connectionFactory);
        return template;
    }

    @Bean
    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
                .serializeKeysWith(RedisSerializationContext.SerializationPair
                        .fromSerializer(new StringRedisSerializer()))
                .serializeValuesWith(RedisSerializationContext.SerializationPair
                        .fromSerializer(new GenericJackson2JsonRedisSerializer()));

        return RedisCacheManager.builder(redisConnectionFactory)
                .cacheDefaults(redisCacheConfiguration)
                .build();
    }

    @PostConstruct
    public void clearCache() {
        System.out.println("clear cache");
        try (Jedis jedis = new Jedis(redisHost, redisPort, 1000)) {
            jedis.flushAll();
        }
    }
}