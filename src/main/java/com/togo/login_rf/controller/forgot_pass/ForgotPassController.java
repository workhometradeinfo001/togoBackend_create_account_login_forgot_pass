package com.togo.login_rf.controller.forgot_pass;

import com.togo.login_rf.record.forgot_record.ForgotPassRecord;
import com.togo.login_rf.services.forgot_service.ForgotPassService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedCaseInsensitiveMap;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/forgotPass")
@RequiredArgsConstructor
public class ForgotPassController {

    private final ForgotPassService forgotPassService;

    @GetMapping
    public ResponseEntity<?> emailCheckWithCode(@RequestParam("email") String email){
        Optional<ForgotPassRecord> findingResult = forgotPassService.findingEmail(email);
        if (findingResult.isPresent()){
            int verificationCode = forgotPassService.gVerificationCode(email);
            Map<String, Number> obj = new LinkedCaseInsensitiveMap<>();
            obj.put("code", verificationCode);
            obj.put("Http", 302);
            return ResponseEntity.of(Optional.of(obj));
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
