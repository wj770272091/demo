package com.example.demo.controller;

import com.example.demo.bean.User;
import com.example.demo.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

/**
 * @NAME: DataController
 * @USER: 77027
 * @DATE: 2020/10/12
 * @TIME: 14:19
 */
@RestController
@RequestMapping("/api/user")
public class DataController {
    @Autowired
    private UserMapper userMapper;
    @PostMapping("/save")
    public String addUser() {
        User user = new User();
        user.setNickname("zhangsan" + new Random().nextInt());
        user.setPassword("123456");
        user.setSex(1);
        user.setBirthday("1997-12-03");
        userMapper.addUser(user);
        return "success";
    }

    @GetMapping("/findUsers")
    public List<User> findUsers() {
        return userMapper.findUsers();
    }
//    @Autowired
//    PersonRepository personRepository;
//    @Autowired
//    DemoService demoService;
////    private String name;
//
//    @RequestMapping("/save")
//    public Person save(String name,String address,Integer age){
//        Person p=personRepository.save(new Person(null,name,age,address));
//        return p;
//    }
//
//    @RequestMapping("/q1")
//    public List<Person> q1(String address){
//        List<Person> people = personRepository.findByAddress(address);
//        return people;
//    }
//
//    @RequestMapping("/q2")
//    public Person q2(String name,String address){
//        Person people = personRepository.findByNameAndAddress(name,address);
//        return people;
//    }
//
//    @RequestMapping("/q3")
//    public Person q3(String name,String address){
//        Person p=personRepository.withNameAndAddressQuery(name,address);
//        return p;
//    }
//
//    @RequestMapping("/q4")
//    public Person q4(String name,String address){
//        Person p = personRepository.withNameAndAddressNameQuery(name,address);
//        return p;
//    }
//    @RequestMapping("/sort")
//    public List<Person> sort(){
//        Sort aa = Sort.by(Sort.Direction.ASC,"age");
//        List<Person> p = personRepository.findAll(aa);
//        return p;
//    }
//    @RequestMapping("/page")
//    public Page<Person> page(){
//        Page<Person> p = personRepository.findAll(PageRequest.of(1, 2));
//        return p;
//    }
//    @RequestMapping("/auto")
//    public Page<Person> auto(Person pe){
//        PageRequest bb=PageRequest.of(0,10);
//        Page<Person> p = personRepository.findByAuto(pe, bb);
//        return p;
//    }


//    @RequestMapping(value = "/test",method = RequestMethod.GET)
//    public String test(@RequestParam(value = "name") String pe){
//
//        return pe;
//    }
//
//    @RequestMapping("/rollback")
//    public Person rollback(Person person){
//        return demoService.savePersonWithRollBack(person);
//    }
//
//    @RequestMapping("/norollback")
//    public Person norollback(Person person){
//        return demoService.savePersonWithoutRollBack(person);
//    }
//
//    @RequestMapping("/put")
//    public Person put(Person person){
//        Person aLong= demoService.save(person);
//        return aLong;
//    }
//
//    @RequestMapping("/able")
//    public Person cacheable(Person person){
//        return demoService.findOne(person);
//    }
//
//    @RequestMapping("/evit")
//    public String evit(Long id){
//        demoService.remove(id);
//        return "ok";
//    }


    /**
     * Mongo??????
     * */
//    @Autowired
//    PersonMongoRepository personMongoRepository;
//
//    @RequestMapping("/save")
//    public PersonMongo save(){
//        PersonMongo personMongo =new PersonMongo("wj",26);
//        Collection<Location> locations = new LinkedHashSet<Location>();
//        Location loc1=new Location("??????","2009");
//        Location loc2=new Location("??????","2010");
//        Location loc3=new Location("??????","2011");
//        Location loc4=new Location("??????","2012");
//        locations.add(loc1);
//        locations.add(loc2);
//        locations.add(loc3);
//        locations.add(loc4);
//        personMongo.setLocations(locations);
//        return personMongoRepository.save(personMongo);
//    }
//
//    @RequestMapping("/q5")
//    public PersonMongo q5(String name){
//        return personMongoRepository.findByName(name);
//    }
//    @RequestMapping("/q6")
//    public List<PersonMongo> q6(Integer age){
//        return personMongoRepository.withQueryFindByAge(age);
//    }
}
