package com.example.fabric.service;

import com.example.fabric.model.User;
import com.example.fabric.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String lastName) throws UsernameNotFoundException {

        User findUser = repository.findByLastName(lastName);

        String userRole = String.valueOf(findUser.getRole());

        List<SimpleGrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(userRole));

        return new org.springframework.security.core.userdetails.User(
                findUser.getLastName(), findUser.getPassword(), authorities);
    }
}
