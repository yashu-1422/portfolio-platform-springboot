package com.portfolio.portfolio_platform.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "projects")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Project extends BaseEntity {

    // Inherits ID from BaseEntity

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT") // Optimized for AI-generated long descriptions
    private String description;

    @Column(name = "tech_stack")
    private String techStack; // e.g., "Java, Spring Boot, React"

    @Column(name = "project_link")
    private String projectLink; // URL to GitHub or Live Demo

    // --- RELATIONSHIP ---

    // Many Projects belong to One Portfolio
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "portfolio_id", nullable = false)
    @ToString.Exclude
    private Portfolio portfolio;
}