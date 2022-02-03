package com.codegym.casestudy.security.userprinciple;

import com.codegym.casestudy.model.Users;
import com.codegym.casestudy.repository.IUserRepositoty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailService implements UserDetailsService {
    @Autowired
    IUserRepositoty userRepositoty;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = userRepositoty.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return UserPrinciple.build(users);
    }
}
