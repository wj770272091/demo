package com.example.demo;

import com.example.demo.bean.AuthorSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RestController;


//@SpringBootApplication(scanBasePackages ={"com.example.demo"},exclude={DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@SpringBootApplication(scanBasePackages ={"com.example.demo"})
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
