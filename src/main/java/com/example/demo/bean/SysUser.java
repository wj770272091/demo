//package com.example.demo.bean;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import javax.persistence.*;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
///**
// * @NAME: SysUser
// * @USER: 77027
// * @DATE: 2020/12/31
// * @TIME: 15:01
// */
//@Entity
//public class SysUser implements UserDetails {
//    private static final long serialVersionUID = 1L;
//
//    @Id
//    @GeneratedValue
//    private Long id;
//    private String username;
//    private String password;
//
//    @Override
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    @Override
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    @ManyToMany(cascade = {CascadeType.REFRESH},fetch = FetchType.EAGER)
//    private List<SysRole> roles;
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//
//    public List<SysRole> getRoles() {
//        return roles;
//    }
//
//    public void setRoles(List<SysRole> roles) {
//        this.roles = roles;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        List<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
//        List<SysRole> roles= this.getRoles();
//        roles.stream().forEach(p->{
//            auths.add(new SimpleGrantedAuthority(p.getName()));
//        });
//        return auths;
//    }
//
//
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return false;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return false;
//    }
//}
