package com.linuxtips.jwtrefreshtoken.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "students")
@Setter
@Getter
@ToString
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(nullable = false)
    private String name ;


    @Column(nullable = false)
    private String stack ;

    @Column(nullable = false)
    private String yearsExperience ;
}
