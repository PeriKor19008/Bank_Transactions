package com.example.repository;

import com.example.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


// Annotation
@Repository
public interface AccountRepository
        extends JpaRepository<Account, Long> {

}
