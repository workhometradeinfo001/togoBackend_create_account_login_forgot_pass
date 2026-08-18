package com.togo.login_rf.controller.acc_login_con;

import com.togo.login_rf.dtos.acc_login.LoginDTO;
import com.togo.login_rf.services.login_service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("login")
@RequiredArgsConstructor
@Slf4j
public class LoginController {
    private final LoginService loginService;
    @PostMapping
    public ResponseEntity<HttpStatus> loginMethod(@RequestBody LoginDTO loginDTO){
        try {
            return loginService.login(loginDTO) ?
                    new ResponseEntity<>(HttpStatus.FOUND)
                    : new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } catch (Exception e) {
            log.error("Login Error: ", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
