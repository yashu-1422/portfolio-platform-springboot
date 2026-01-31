package com.portfolio.portfolio_platform.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class User extends BaseEntity { // <--- 1. EXTENDS BaseEntity

    // ❌ DELETED: private Long id; (Inherited from BaseEntity)
    
    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Column(name = "is_active") 
    private boolean active = true;

    // ❌ DELETED: private LocalDateTime createdAt; (Inherited from BaseEntity)

    public enum Role {
        USER,
        ADMIN
    }
}