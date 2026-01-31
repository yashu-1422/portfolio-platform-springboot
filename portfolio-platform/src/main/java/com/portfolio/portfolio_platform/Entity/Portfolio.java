package com.portfolio.portfolio_platform.Entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "portfolios")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Portfolio extends BaseEntity {

    // --- BASIC FIELDS ---

    @Column(nullable = false)
    private String fullName;

    @Column(columnDefinition = "TEXT") // Allows long text for Bio/About
    private String about;

    private String phone;
    private String linkedin;
    private String github;

    @Column(name = "profile_image")
    private String profileImage;

    @Column(nullable = false)
    private boolean published = false; // Default: Hidden

    // --- PARENT RELATIONSHIPS ---

    // 1. OWNER (User)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @ToString.Exclude
    private User user;

    // 2. VISUAL STYLE (Template)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "template_id")
    @ToString.Exclude
    private Template template;

    // --- CHILD LISTS (One-To-Many) ---

    // 3. SKILLS
    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private List<Skill> skills = new ArrayList<>();

    // 4. PROJECTS
    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private List<Project> projects = new ArrayList<>();

    // 5. EDUCATION (New Addition)
    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private List<Education> educations = new ArrayList<>();

    // --- HELPER METHODS (Syncs both sides of the relationship) ---

    // Skills Helpers
    public void addSkill(Skill skill) {
        skills.add(skill);
        skill.setPortfolio(this);
    }

    public void removeSkill(Skill skill) {
        skills.remove(skill);
        skill.setPortfolio(null);
    }

    // Projects Helpers
    public void addProject(Project project) {
        projects.add(project);
        project.setPortfolio(this);
    }

    public void removeProject(Project project) {
        projects.remove(project);
        project.setPortfolio(null);
    }

    // Education Helpers
    public void addEducation(Education education) {
        educations.add(education);
        education.setPortfolio(this);
    }

    public void removeEducation(Education education) {
        educations.remove(education);
        education.setPortfolio(null);
    }
}