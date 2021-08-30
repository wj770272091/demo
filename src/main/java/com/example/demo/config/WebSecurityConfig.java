//package com.example.demo.config;
//
//import com.example.demo.bean.SysUser;
//import com.example.demo.service.SysUserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.web.authentication.AuthenticationFailureHandler;
//
//
///**
// * @NAME: WebSecurityConfig
// * @USER: 77027
// * @DATE: 2020/12/31
// * @TIME: 10:54
// */
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    SysUserRepository userRepository;
//    @Bean
//    UserDetailsService customUserService(){
//        return new UserDetailsService() {
//            @Override
//            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//                SysUser user = userRepository.findByUsername(username);
//                if (user == null){
//                    throw new UsernameNotFoundException("用户名不存在");
//                }
//                return user;
//            }
//        };
//    }
//@Bean
//public AuthenticationFailureHandler customAuthenticationFailureHandler() {
//    return new CustomAuthenticationFailureHandler();
//}
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .failureHandler(customAuthenticationFailureHandler())
//                .loginPage("/login")
//                .failureUrl("/login?error")
//                .permitAll()
//                .and()
//                .logout().permitAll();
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////        auth.inMemoryAuthentication()
////                .withUser("wj").password("wj").roles("ROLE_ADMIN")
////                .and()
////                .withUser("wjtest").password("wjtest").roles("ROLE_USER");
//        System.out.println("加载权限");
//auth.userDetailsService(customUserService());
//    }
//
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        super.configure(web);
//    }
//
//}
