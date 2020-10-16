package com.cv.gradebook.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

//school class/grade
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "grades")
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "grade_name")
    private String gradeName;

    @OneToMany(mappedBy = "grade")
    private Set<Person> gradeMembers = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "grades_subjects",
            joinColumns = @JoinColumn(
                    name = "grade_id",
                    foreignKey = @ForeignKey(name = "grades_subjects_fkey_grade_id")),
            inverseJoinColumns = @JoinColumn(
                    name = "subject_id",
                    foreignKey = @ForeignKey(name = "grades_subjects_fkey_subject_id"))
    )
    private Set<Subject> subjects = new HashSet<>();

}
