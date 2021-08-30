//package com.example.demo.dao;
//
//import com.example.demo.bean.UserCacheObject;
//import com.example.demo.util.JSONUtil;
//import org.springframework.data.redis.core.ValueOperations;
//
//import javax.annotation.Resource;
//
//
///**
// * @NAME: UserCacheDao
// * @USER: 77027
// * @DATE: 2020/12/17
// * @TIME: 14:31
// */
//public class UserCacheDao {
//    private static final String KEY_PATTERN = "user:%d";
//    @Resource(name = "redisTemplate")
//    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
//    private ValueOperations<String, String> operations;
//
//    private static String buildKey(Integer id) { // <3>
//        return String.format(KEY_PATTERN, id);
//    }
//    public UserCacheObject get(Integer id) {
//        String key = buildKey(id);
//        String value = operations.get(key);
//        return JSONUtil.parseObject(value, UserCacheObject.class);
//    }
//
//    public void set(Integer id, UserCacheObject object) {
//        String key = buildKey(id);
//        String value = JSONUtil.toJSONString(object);
//        operations.set(key, value);
//    }
//}
