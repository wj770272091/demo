package com.example.demo.util;

import com.alibaba.fastjson.JSON;

/**
 * @NAME: JSONUtil
 * @USER: 77027
 * @DATE: 2020/12/17
 * @TIME: 14:56
 */
public class JSONUtil {
    public static  <T> T parseObject(String text, Class<T> clazz) {
        return JSON.parseObject(text, clazz);
    }

    public static String toJSONString(Object javaObject) {
        return JSON.toJSONString(javaObject);
    }

    public static byte[] toJSONBytes(Object javaObject) {
        return JSON.toJSONBytes(javaObject);
    }
}
