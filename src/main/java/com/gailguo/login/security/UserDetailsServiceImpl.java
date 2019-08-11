package com.gailguo.login.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private Map<String, String> userRepository = new HashMap<>();

    @PostConstruct
    private void init() {
        userRepository.put("zhangshan", "123456");
        userRepository.put("guoxiwang", "woshisb");
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return new User(s, userRepository.get(s), new ArrayList<>());
    }
}


