//package com.example.demo.service;
//
//
//
//import com.example.demo.bean.PersonMongo;
//import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.data.mongodb.repository.Query;
//
//import java.util.List;
//
//
//public interface PersonMongoRepository extends MongoRepository<PersonMongo,String> {
//public PersonMongo findByName(String name);
//@Query("{'age':?0}")
//public List<PersonMongo> withQueryFindByAge(Integer age);
//}
