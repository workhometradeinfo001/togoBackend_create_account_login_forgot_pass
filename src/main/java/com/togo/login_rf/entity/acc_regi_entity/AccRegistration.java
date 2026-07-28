package com.togo.login_rf.entity.acc_regi_entity;

import com.togo.login_rf.entity.AbstractGlobalEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;
import java.util.List;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccRegistration extends AbstractGlobalEntity<Long> {

    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String emailAddress;
    private String password;
    private List<String> role;

}
