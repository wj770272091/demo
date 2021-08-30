//package com.example.demo.service.impl;
//
//import com.example.demo.bean.Person;
//import com.example.demo.service.DemoService;
//import com.example.demo.service.PersonRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cache.annotation.CacheEvict;
//import org.springframework.cache.annotation.CachePut;
//import org.springframework.cache.annotation.Cacheable;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.Optional;
//
///**
// * @NAME: DemoServiceImpl
// * @USER: 77027
// * @DATE: 2020/12/28
// * @TIME: 14:35
// */
//@Service
//public class DemoServiceImpl implements DemoService {
//    @Autowired
//    PersonRepository personRepository;
//
//    @Override
//    @Transactional(rollbackFor = {IllegalArgumentException.class})
//    public Person savePersonWithRollBack(Person person) {
//        Person p = personRepository.save(person);
//        if (person.getName().equals("汪云飞")) {
//            throw new IllegalArgumentException("数据已存在");
//        }
//        return p;
//    }
//
//    @Override
//    @Transactional(noRollbackFor =  {IllegalArgumentException.class})
//    public Person savePersonWithoutRollBack(Person person) {
//        Person p = personRepository.save(person);
//        if (person.getName().equals("汪云飞")){
//            throw new IllegalArgumentException("数据已存在");
//        }
//        return p;
//    }
//
//    @Override
//    @CachePut(value = "people",key = "#person.id")
//    public Person save(Person person) {
//        Person p =personRepository.save(person);
//        System.out.print("数据缓存"+p.getId());
//
//        return p;
//    }
//
//    @Override
//    @CacheEvict(value = "people")
//    public void remove(Long id) {
//        System.out.println("删除了"+id+"的数据缓存");
//    personRepository.deleteById(id);
//    }
//
//    @Override
//    @Cacheable(value = "people",key = "#person.id")
//    public Person findOne(Person person) {
//        System.out.println("利用缓存查询");
//        Optional<Person> p = personRepository.findById(person.getId());
//        return p.get();
//    }
//}
