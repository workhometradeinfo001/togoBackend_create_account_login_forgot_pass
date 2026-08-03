package com.togo.login_rf.repo.forgot_repo;

import com.togo.login_rf.entity.acc_regi_entity.AccRegistration;
import com.togo.login_rf.record.forgot_record.ForgotPassRecord;
import com.togo.login_rf.repo.GlobalRepo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ForgotPassRepo extends GlobalRepo<AccRegistration, Long> {

    Optional<ForgotPassRecord> findByEmailAddress(String email);

}
