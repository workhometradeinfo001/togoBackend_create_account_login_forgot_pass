package com.togo.login_rf.repo.acc_reg_repo;


import com.togo.login_rf.entity.acc_regi_entity.AccRegistration;
import com.togo.login_rf.record.loginRecord.LoginRecord;
import com.togo.login_rf.repo.GlobalRepo;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface AccRegiRepo extends GlobalRepo<AccRegistration, Long> {

    Optional<LoginRecord> findByEmailAddress(String email);

}
