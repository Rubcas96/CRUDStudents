package com.example.CRUDStudents.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@NoArgsConstructor
public class ModuloDto implements Serializable {

    private String name;

    public ModuloDto(String name) {
        this.name = name;
    }
}