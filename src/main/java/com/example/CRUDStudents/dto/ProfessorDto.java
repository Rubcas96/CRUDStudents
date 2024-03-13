package com.example.CRUDStudents.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@NoArgsConstructor
public class ProfessorDto implements Serializable {

    private Integer idProfessor;
    private String name;
    private String lastname;


    public ProfessorDto(Integer idProfessor, String name, String lastname) {
        this.idProfessor = idProfessor;
        this.name = name;
        this.lastname = lastname;
    }
}
