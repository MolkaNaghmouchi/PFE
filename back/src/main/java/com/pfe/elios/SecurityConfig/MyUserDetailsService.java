package com.pfe.elios.SecurityConfig;


import com.pfe.elios.Repositories.UserRepository;
import com.pfe.elios.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional=userRepository.findByUserName(username);

        if (!userOptional.isPresent())
            throw new UsernameNotFoundException("User not exist with name :" +username);
        String pass=userOptional.get().getPassword();


        return new org.springframework.security.core.userdetails.User (username,pass, userOptional.get().getRole_name());

    }

}