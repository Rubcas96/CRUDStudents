package com.example.CRUDStudents.controller;

import com.example.CRUDStudents.entity.Professors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import com.example.CRUDStudents.service.serviceClass;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class ProfessorController {

    @Autowired
    private serviceClass serviceClass;

    @GetMapping("/professors")
    public List<Professors> getAllProfessors() {
        return serviceClass.getAllProfessors();
    }

    @PostMapping("/professors/new")
    public Professors addProfessor(@RequestBody Professors newProfessor) {
        return serviceClass.addProfessor(newProfessor);
    }

    @PutMapping("/professors/edit/{id}")
    public Professors editProfessor(@PathVariable Integer id, @RequestBody Professors professor) {
        return serviceClass.editProfessor(id, professor);
    }

    @GetMapping("/professors/{id}")
    public Optional<Professors> getProfessorById(@PathVariable Integer id) {
        return serviceClass.getProfessorById(id);
    }

    @DeleteMapping("/professors/{id}")
    public void deleteProfessor(@PathVariable Integer id) {
        serviceClass.deleteProfessor(id);
    }


    @GetMapping("/professors/page/{pagina}/{tamaño}")
    public Page<Professors> getProfessors(@PathVariable int pagina, @PathVariable int tamaño) {
        return serviceClass.getProfessors(pagina, tamaño);
    }

    @GetMapping("/professors/page")
    public Page<Professors> getProfessors() {
        return serviceClass.getProfessors();
    }

    @GetMapping("/ProfessorsPageNombreAscendente")
    public Page<Professors> getAllProfessorsPaginadosNombre(Pageable pageable) {
        return serviceClass.getAllProfessorsPaginadosNombre(pageable);
    }

    @GetMapping("/ProfessorsPageVariable")
    public Page<Professors> getAllProfessorsVariablePage(@PageableDefault() Pageable pageable) {
        return serviceClass.getAllProfessorsVariablePage(pageable);
    }

    @GetMapping("/ProfessorsPageDefault")
    public Page<Professors> getAllProfessorsDefaultPage(@PageableDefault(page = 0, size = 20) Pageable pageable) {
        return serviceClass.getAllProfessorsDefaultPage(pageable);
    }
}

