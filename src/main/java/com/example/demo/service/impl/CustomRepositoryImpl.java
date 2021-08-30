package com.example.demo.service.impl;

import com.example.demo.service.CustomRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;


import javax.persistence.EntityManager;
import java.io.Serializable;
import static com.example.demo.config.CustomerSpecs.*;
/**
 * @author 77027
 * @NAME: CustomRepositoryImpl
 * @USER: 77027
 * @DATE: 2020/12/3
 * @TIME: 14:26
 */

public class CustomRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements CustomRepository<T, ID> {
    private  EntityManager entityManager;

    public CustomRepositoryImpl(Class<T> domainClass, EntityManager entityManager) {
        super(domainClass, entityManager);
        this.entityManager = entityManager;
    }

    @Override
    public Page<T> findByAuto(T example, Pageable pageable) {
        return findAll(byAuto(entityManager,example),pageable);
    }
}
