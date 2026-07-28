package com.togo.login_rf.services.login_service;

import com.togo.login_rf.dtos.acc_login.LoginDTO;
import com.togo.login_rf.record.loginRecord.LoginRecord;
import com.togo.login_rf.repo.acc_reg_repo.AccRegiRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final AccRegiRepo accRegiRepo;
    private final BCryptPasswordEncoder passwordEncoder;

    public boolean login(LoginDTO loginDTO){
        Optional<LoginRecord> isFoundEmail = accRegiRepo.findByEmailAddress(loginDTO.getEmail());
        if (isFoundEmail.isPresent()){
            LoginRecord loginRecord = isFoundEmail.get();
            String password = loginRecord.password();
            return passwordEncoder.matches(loginDTO.getPassword(), password);
        }
        return false;
    }

}
