package com.togo.login_rf.services.forgot_service;

import com.togo.login_rf.record.forgot_record.ForgotPassRecord;
import com.togo.login_rf.repo.forgot_repo.ForgotPassRepo;
import com.togo.login_rf.services.EmailPublisherService.EmailPublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.security.SecureRandom;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ForgotPassService {

    private final ForgotPassRepo passRepo;
    private final EmailPublisherService emailService;
    private final SecureRandom secureRandom = new SecureRandom();

    public Optional<ForgotPassRecord> findingEmail(String email){
        return passRepo.findByEmailAddress(email);
    }

    public int gVerificationCode(String email){
        int i = secureRandom.nextInt(1000000);
        emailService.queueEmail(
                email,
                "Verification code:",
                "Your verification code is: "+i
        );
        return i;
    }

}
