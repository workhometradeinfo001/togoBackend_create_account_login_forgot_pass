package com.togo.login_rf.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.jspecify.annotations.Nullable;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.domain.Persistable;

import java.time.Instant;

@MappedSuperclass
public abstract class AbstractGlobalEntity<ID> implements Persistable<ID> {
    @Override
    public @Nullable ID getId() {
        return null;
    }
    @Override
    public boolean isNew() {
        return false;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    private Instant createAt;

    @UpdateTimestamp
    private Instant updateAt;

    @CreatedBy
    @Column(name = "created_by", nullable = true)
    private Long userId;

    @LastModifiedBy
    @Column(name = "updated_by", nullable = true)
    private Long updateBy;

}
