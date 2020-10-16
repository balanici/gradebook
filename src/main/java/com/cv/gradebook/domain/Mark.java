package com.cv.gradebook.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

//school marks/notes
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "marks")
public class Mark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "mark")
    private Integer mark;

    @Column(name = "mark_date")
    private Date markDate;

    @ManyToOne
    @JoinColumn(
            name = "teacher_id",
            foreignKey = @ForeignKey(name = "teachers_persons_fkey_person_id")
    )
    private Person teacher;

    @ManyToOne
    @JoinColumn(
            name = "pupil_id",
            foreignKey = @ForeignKey(name = "pupils_persons_fkey_person_id")
    )
    private Person pupil;

    @ManyToOne
    @JoinColumn(
            name = "grade_id",
            foreignKey = @ForeignKey(name = "marks_grades_fkey_grade_id")
    )
    private Grade grade;

    @ManyToOne
    @JoinColumn(name = "subject_id",
            foreignKey = @ForeignKey(name = "subjects_fkey_subject_id")
    )
    private Subject subject;



}
