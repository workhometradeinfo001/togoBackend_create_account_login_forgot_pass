package com.togo.login_rf.dtos.acc_login;

import jakarta.annotation.Nonnull;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LoginDTO {

    @Nonnull
    private String email;
    @Nonnull
    private String password;

}
