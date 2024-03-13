package com.example.CRUDStudents.dto;



import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@NoArgsConstructor
public class StudentDto implements Serializable {

    private Integer idStudents;
    private String name;
    private String lastname;


    public StudentDto(Integer idStudents, String name, String lastname) {
        this.idStudents = idStudents;
        this.name = name;
        this.lastname = lastname;
    }
}
