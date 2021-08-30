//package com.example.demo.service;
//
//import com.example.demo.bean.SysUser;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
///**
// * @NAME: CustomUserService
// * @USER: 77027
// * @DATE: 2020/12/31
// * @TIME: 16:48
// */
//public class CustomUserService implements UserDetailsService {
//    @Autowired
//    SysUserRepository userRepository;
//    @Override
//    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//        SysUser user = userRepository.findByUsername(s);
//        if (user == null){
//            throw new UsernameNotFoundException("用户名不存在");
//        }
//        return user;
//    }
//}
