package com.spe.backend.repository;

import com.spe.backend.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority,Long> {
    public Authority findByAuthority(String authority);

}
