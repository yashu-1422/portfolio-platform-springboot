package com.portfolio.portfolio_platform.Entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "skills")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Skill extends BaseEntity {

    // Inherits ID, CreatedAt, UpdatedAt from BaseEntity

    @Column(nullable = false, name = "skill_name")
    private String skillName;

    // Optional field (nullable = true by default)
    private String level; // e.g., "Intermediate", "Expert"

    // --- RELATIONSHIP ---
    
    // Foreign Key: portfolio_id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "portfolio_id", nullable = false) // This creates the foreign key
    @ToString.Exclude // Prevents infinite loop
    private Portfolio portfolio;
}