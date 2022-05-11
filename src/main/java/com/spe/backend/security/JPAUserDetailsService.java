package com.spe.backend.security;

import com.spe.backend.model.User;
import com.spe.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class JPAUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            User user = userRepository.findByUsername(username);
            return new JPAUserDetails(user.getUsername(),
                    passwordEncoder.encode(user.getPassword()),
                    user.getAuthorities().stream().map(authority ->
                            new SimpleGrantedAuthority(authority.getAuthority())).collect(Collectors.toSet()),
                    true,
                    true,
                    true,
                    true
            );

        } catch (UsernameNotFoundException e){
            throw(e);
        }

    }
}
