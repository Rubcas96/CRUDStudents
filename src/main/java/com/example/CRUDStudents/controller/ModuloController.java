package com.example.CRUDStudents.controller;


import com.example.CRUDStudents.entity.Modulos;
import com.example.CRUDStudents.service.serviceClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ModuloController {


    @Autowired
    private serviceClass servicio;

    @GetMapping("/modulos")
    public List<Modulos> getAllModulos() {
        return servicio.getModulos();
    }

    @PostMapping("/modulos/new")
    public Modulos addModulo(@RequestBody Modulos newModulo) {
        return servicio.saveModulo(newModulo);
    }

    @PutMapping("/modulos/edit/{id}")
    public Modulos editModulo(@PathVariable Integer codigo, @RequestBody Modulos modulo) {
        return servicio.editModulo(codigo, modulo);
    }

    @DeleteMapping("/modulos/{id}")
    public void deleteModulo(@PathVariable Integer codigo) {
        servicio.deleteModulo(codigo);
    }




}
