package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;


@SpringBootApplication
class DemoApplicationTests {

    @Test
    void contextLoads() {
        HashSet<Integer> map=new HashSet();
        map.add(1);
            System.out.println("测试环境启动");
        System.out.println(true|true);
        System.out.println(true|false);
    }

}
