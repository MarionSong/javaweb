package com.marion.library.service;

import com.marion.library.mapper.UserMapper;
import com.marion.library.pojo.Roles;
import com.marion.library.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailService implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users users = userMapper.findByName(username);
        if(users==null){
            throw new UsernameNotFoundException("用户名不存在");
        }

        List<SimpleGrantedAuthority> authorities=new ArrayList<>();

        //把用户权限添加到list中
        for (Roles roles: users.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(roles.getName()));
            System.out.println(roles.getName());
        }
        System.out.println(authorities);
        System.out.println(username);
        System.out.println(users.getUsername());
        System.out.println(users.getPassword());
        return new User(users.getUsername(),users.getPassword(),authorities);
    }
}
