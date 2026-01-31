package com.portfolio.portfolio_platform.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "educations") // Plural table name is standard
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Education extends BaseEntity {

    // Inherits ID from BaseEntity

    @Column(nullable = false)
    private String degree; // e.g., "B.Tech Computer Science"

    @Column(nullable = false)
    private String institution; // e.g., "IIT Bombay" (Mapped from 'clg')

    @Column(name = "start_year")
    private String startYear; // String is flexible (e.g., "2020")

    @Column(name = "end_year")
    private String endYear;   // String allows values like "Present" or "2024"

    // --- RELATIONSHIP ---

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "portfolio_id", nullable = false)
    @ToString.Exclude
    private Portfolio portfolio;
}