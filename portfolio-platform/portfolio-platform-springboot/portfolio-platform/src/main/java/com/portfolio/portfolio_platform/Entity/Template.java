package com.portfolio.portfolio_platform.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "templates")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Template extends BaseEntity {

    // Inherits ID, CreatedAt, UpdatedAt from BaseEntity

    @Column(nullable = false, unique = true)
    private String name; // e.g., "Modern Dark", "Minimalist White"

    @Column(name = "preview_image")
    private String previewImage; // URL or path to a screenshot of the template

    @Column(nullable = false)
    private String path; // Reference to the actual HTML/CSS folder location (e.g., "templates/theme1/")

    @Column(name = "is_active")
    private boolean active = true; // Admins can set to false to disable a buggy template
}