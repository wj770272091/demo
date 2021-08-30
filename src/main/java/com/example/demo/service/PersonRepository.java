//package com.example.demo.service;
//
//
//import com.example.demo.bean.Person;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//
//import java.util.List;
//
//
//public interface PersonRepository extends CustomRepository<Person,Long> {
//List<Person> findByAddress(String name);
//Person findByNameAndAddress(String name,String address);
//@Query("select p from Person p where p.name=:name and p.address=:address")
//Person withNameAndAddressQuery(@Param("name") String name, @Param("address") String address);
//Person withNameAndAddressNameQuery(String name,String address);
//
//}
