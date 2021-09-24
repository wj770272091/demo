package com.example.demo;

import com.example.demo.bean.AuthorSettings;
import com.example.demo.bean.CustomRepositoryFactoryBean;
//import com.example.demo.service.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
//import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.TreeMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


@SpringBootApplication(scanBasePackages ={"com.example.demo"},exclude={DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@RestController
//@EnableJpaRepositories(repositoryFactoryBeanClass = CustomRepositoryFactoryBean.class)
@EnableJpaRepositories
//@EnableTransactionManagement
@EnableCaching
public class DemoApplication {
    @Autowired
    AuthorSettings authorSettings;
//    @Autowired
//    PersonRepository personRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

//    @RequestMapping("/")
//    String index() {
//        personRepository.findAll();
//        TreeMap treeMap = new TreeMap();
//        Integer aa = new Integer(10);
//        return "内容:" + authorSettings.getUser() + "----" + authorSettings.getAge();
//
//    }
}
