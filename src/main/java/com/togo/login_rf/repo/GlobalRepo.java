package com.togo.login_rf.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GlobalRepo<T, ID> extends JpaRepository<T, ID> {
}
