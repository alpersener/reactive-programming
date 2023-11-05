package com.project.reactiveprogramming.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "students") //for entity there is no entity in reactive programming
public class Student {

    @Id

    private Integer id;

    private String firstname;

    private String lastname;

    private int age;

}
