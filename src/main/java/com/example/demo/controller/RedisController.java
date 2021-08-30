//package com.example.demo.controller;
//
//
//import com.example.demo.DemoApplication;
//import com.example.demo.bean.GenericFastJsonRedisSerializer;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//import org.springframework.lang.Nullable;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.util.Assert;
//
//import java.lang.management.GarbageCollectorMXBean;
//import java.nio.charset.Charset;
//import java.nio.charset.StandardCharsets;
//import java.util.concurrent.TimeUnit;
//
//
///**
// * @NAME: RedisController
// * @USER: 77027
// * @DATE: 2020/12/16
// * @TIME: 10:41
// */
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = {DemoApplication.class})
//public class RedisController  {
//    @Autowired
//    StringRedisTemplate stringRedisTemplate;
//    @Autowired
//    RedisTemplate redisTemplate;
//
//    @Test
//    public void testString() throws Exception{
////        stringRedisTemplate.opsForValue().set("add", "tj");
//        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
////        redisTemplate.setKeySerializer(stringRedisSerializer);
//        redisTemplate.setValueSerializer(new GenericFastJsonRedisSerializer());
////        redisTemplate.setDefaultSerializer(stringRedisSerializer);
//        redisTemplate.opsForValue().set("rest12345","tj",300, TimeUnit.DAYS);
//        System.out.println("写入redis");
//    }
//    // StringRedisSerializer.java
//
//
//}
//
//class Serializer extends StringRedisSerializer{
//    private final Charset charset;
//    public Serializer(Charset charset) {
//        Assert.notNull(charset, "Charset must not be null!");
//        this.charset = charset;
//    }
//
//    @Override
//    public String deserialize(@Nullable byte[] bytes) {
//        return (bytes == null ? null : new String(bytes, charset));
//    }
//
//    @Override
//    public byte[] serialize(@Nullable String string) {
//        return (string == null ? null : string.getBytes(charset));
//    }
//}
