package com.togo.login_rf.controller.acc_regi_con;

import com.togo.login_rf.dtos.acc_regi_dto.AccRegiDTO;
import com.togo.login_rf.services.acc_reg_service.AccRegiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reg")
@RequiredArgsConstructor
@Slf4j
public class AccRegiController {

    private final AccRegiService service;

    @PostMapping("ac")
    public ResponseEntity<HttpStatus> aCreation(@RequestBody AccRegiDTO regiDTO){
        try{
            boolean account = service.createAccount(regiDTO);
            if (account){
                return new ResponseEntity<>(HttpStatus.CREATED);
            }
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            log.error("Error for: ",e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
