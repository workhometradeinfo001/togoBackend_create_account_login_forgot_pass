package com.togo.login_rf.dtos.forgot_pass;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UpdatePassDTO {

    private String email;
    private String password;

}
