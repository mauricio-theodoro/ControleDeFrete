package com.frete.controle.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.frete.controle.model.AppUser;
import com.frete.controle.repository.AppUserRepository;

@Service
public class AppUserService implements UserDetailsService {

    @Autowired
    private AppUserRepository appUserRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        AppUser appUser = appUserRepository.findByEmail(email);
        
        if (appUser != null) {
            var springUser = User.withUsername(appUser.getEmail())
            .password(appUser.getPassword())
            .roles(appUser.getRole())
            .build();
            return springUser;
        }

        return null;
    
    }
}
