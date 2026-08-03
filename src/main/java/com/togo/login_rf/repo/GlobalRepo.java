package com.togo.login_rf.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Transactional;

@NoRepositoryBean
public interface GlobalRepo<T, ID> extends JpaRepository<T, ID> {

    @Transactional
    @Modifying
    @Query("update AccRegistration set password = ?1 where emailAddress = ?2")
    int updatePassword(String password, String email);
}
