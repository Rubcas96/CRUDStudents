package com.example.CRUDStudents.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name="modulos")
public class Modulos {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="codigo")
    private Integer codModulo;

    @Column(name="name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "id_professor", referencedColumnName = "id_Professor")
    @JsonIgnore
    private Professors professor;

    @ManyToMany(mappedBy = "modulos")
    private List<Students> students;

    public Integer getCodModulo() {
        return codModulo;
    }

    public void setCodModulo(Integer codModulo) {
        this.codModulo = codModulo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Professors getProfessor() {
        return professor;
    }

    public void setProfessor(Professors professor) {
        this.professor = professor;
    }

    public List<Students> getStudents() {
        return students;
    }

    public void setStudents(List<Students> students) {
        this.students = students;
    }
}
