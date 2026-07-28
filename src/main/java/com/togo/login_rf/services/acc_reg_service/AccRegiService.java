package com.togo.login_rf.services.acc_reg_service;


import com.togo.login_rf.dtos.acc_regi_dto.AccRegiDTO;
import com.togo.login_rf.entity.acc_regi_entity.AccRegistration;
import com.togo.login_rf.repo.acc_reg_repo.AccRegiRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccRegiService {
    private final AccRegiRepo acRepo;
    private final BCryptPasswordEncoder passwordEncoder;

    public boolean createAccount(AccRegiDTO dto){
        if (dto != null){
            AccRegistration acReg = new AccRegistration();
            String firstName = dto.getFirstName();
            String lastName = dto.getLastName();
            String email = dto.getEmailAdd();
            String password = dto.getPassword();
            if (!firstName.isBlank()){
                acReg.setFirstName(firstName);
            }
            if (!lastName.isBlank()){
                acReg.setLastName(lastName);
            }
            if (!email.isBlank()){
                acReg.setEmailAddress(email);
            }
            if (!password.isBlank()){
                acReg.setPassword(passwordEncoder.encode(password));
            }
            acReg.setRole(
                    List.of("togo_user")
            );
            acRepo.save(acReg);
            return true;
        }
        return false;
    }


}
