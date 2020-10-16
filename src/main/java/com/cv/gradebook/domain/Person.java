package com.cv.gradebook.domain;

import com.cv.gradebook.domain.enums.PersonTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "age")
    private Integer age;

    @Enumerated(EnumType.STRING)
    @Column(name = "person_type")
    private PersonTypeEnum personType;

    @ManyToOne
    @JoinColumn(
            name = "class_master_id",
            foreignKey = @ForeignKey(name = "persons_fkey_teacher_id")
    )
    private Person classMaster;

    @ManyToOne
    @JoinColumn(
            name = "grade_id",
            foreignKey = @ForeignKey(name = "persons_grades_fkey_grade_id")
    )
    private Grade grade;

    @OneToMany(mappedBy = "classMaster")
    private Set<Person> classPupils = new HashSet<>();

    @OneToMany(mappedBy = "pupil")
    private List<Mark> receivedMarks = new ArrayList<>();

    @OneToMany(mappedBy = "teacher")
    private List<Mark> sentMarks = new ArrayList<>();
}
