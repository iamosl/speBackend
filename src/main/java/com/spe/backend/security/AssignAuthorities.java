package com.spe.backend.security;

import com.spe.backend.model.Authority;
import com.spe.backend.repository.AuthorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Configuration
public class AssignAuthorities {
    @Autowired
    private AuthorityRepository authorityRepo;

    public Set<Authority> getGrantedAuthorities(Set<UserPermission> permissions){
        Set<Authority> authorities = permissions
                .stream()
                .map(permission ->
                        this.authorityRepo.findByAuthority(permission.getPermission())).collect(Collectors.toSet());

        return authorities;
    }
}
