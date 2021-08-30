//package com.example.demo.bean;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.parser.ParserConfig;
//import com.alibaba.fastjson.serializer.SerializerFeature;
//import com.alibaba.fastjson.util.IOUtils;
//import org.springframework.data.redis.serializer.RedisSerializer;
//import org.springframework.data.redis.serializer.SerializationException;
//
///**
// * @NAME: GenericFastJsonRedisSerializer
// * @USER: 77027
// * @DATE: 2020/12/16
// * @TIME: 17:00
// */
//public class GenericFastJsonRedisSerializer implements RedisSerializer<Object> {
//    private final static ParserConfig defaultRedisConfig = new ParserConfig();
//    static { defaultRedisConfig.setAutoTypeSupport(true);}
//    @Override
//    public byte[] serialize(Object o) throws SerializationException {
//        if (o == null) {
//            return new byte[0];
//        }
//        try {
//            // 使用 JSON 进行序列化成二进制数组，同时通过 SerializerFeature.WriteClassName 参数，声明写入类全名。
//            return JSON.toJSONBytes(o, SerializerFeature.WriteClassName);
//        } catch (Exception ex) {
//            throw new SerializationException("Could not serialize: " + ex.getMessage(), ex);
//        }
//    }
//
//    @Override
//    public Object deserialize(byte[] bytes) throws SerializationException {
//        // 如果为空，则返回空对象
//        if (bytes == null || bytes.length == 0) {
//            return null;
//        }
//        try {
//            // 使用 JSON 解析成对象。
//            return JSON.parseObject(new String(bytes, IOUtils.UTF8), Object.class, defaultRedisConfig);
//        } catch (Exception ex) {
//            throw new SerializationException("Could not deserialize: " + ex.getMessage(), ex);
//        }
//    }
//
//    @Override
//    public boolean canSerialize(Class<?> type) {
//
//        return false;
//    }
//
//    @Override
//    public Class<?> getTargetType() {
//        return null;
//    }
//}
