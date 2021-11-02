package com.example.demo.controller;

import com.example.demo.config.InputMDC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @NAME: IndexController
 * @USER: WangJie
 * @DATE: 2021/9/22
 * @TIME: 16:27
 */

@RestController
public class IndexController {
    private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);
    @RequestMapping(value = "/index")
    public String index() {
        InputMDC.putMDC();

        LOGGER.info("我是一条info日志");

        LOGGER.warn("我是一条warn日志");

        LOGGER.error("我是一条error日志");

        return "idx";
    }


    @RequestMapping(value = "/err")
    public String err() {
        InputMDC.putMDC();
        try {
            int a = 1/0;
        } catch (Exception e) {
            LOGGER.error("算术异常", e);
        }
        return "err";
    }

}
