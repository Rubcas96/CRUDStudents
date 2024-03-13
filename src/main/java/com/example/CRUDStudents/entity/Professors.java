package com.example.CRUDStudents.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name="professors")
public class Professors {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Professor")
    private  Integer idProfessors;

    @Column(name = "name")
    private String name;

    @Column(name = "lastname")
    private String lastname;


    @Column(name = "email")
    private String email;

    @Column(name="dni")
    private String dni;

    @OneToMany(mappedBy = "professor")
    private List<Modulos> modulos;


    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Integer getIdProfessors() {
        return idProfessors;
    }

    public void setIdProfessors(Integer idStudents) {
        this.idProfessors = idProfessors;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



}
