package com.togo.login_rf.dtos.acc_regi_dto;

import jakarta.annotation.Nonnull;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AccRegiDTO {

    @Nonnull
    private String firstName;
    @Nonnull
    private String lastName;
    @Nonnull
    private String emailAdd;
    @Nonnull
    private String password;
}
