package com.schooltest.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer rollno;
    private String lastname;
    private String middlename;
    private String firstname;
    private Date dateOfJoining;

    @ManyToOne(cascade = CascadeType.ALL)
    private Student student;

}
