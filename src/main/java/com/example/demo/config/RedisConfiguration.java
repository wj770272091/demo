//package com.example.demo.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.serializer.RedisSerializer;
//
///**
// * @NAME: RedisConfiguration
// * @USER: 77027
// * @DATE: 2020/12/16
// * @TIME: 16:56
// */
//
//@Configuration
//public class RedisConfiguration {
//    @Bean
//    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
//        // 创建 RedisTemplate 对象
//        RedisTemplate<String, Object> template = new RedisTemplate<>();
//        template.setConnectionFactory(factory);
//
//        // 使用 String 序列化方式，序列化 KEY 。
//        template.setKeySerializer(RedisSerializer.string());
//
//        // 使用 JSON 序列化方式（库是 Jackson ），序列化 VALUE 。
//        template.setValueSerializer(RedisSerializer.json());
//        return template;
//    }
//
//
//}
