package com.example.demo.bean;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @NAME: AuthorSettings
 * @USER: 77027
 * @DATE: 2020/10/10
 * @TIME: 14:44
 */
@Component
@ConfigurationProperties(prefix = "author")
public class AuthorSettings {
    private String user;
    private Long age;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }
}
