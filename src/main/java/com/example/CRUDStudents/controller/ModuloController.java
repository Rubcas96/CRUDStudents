package com.example.CRUDStudents.controller;


import com.example.CRUDStudents.entity.Modulos;
import com.example.CRUDStudents.service.serviceClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @PutMapping("/modulos/{moduloId}/assign-professor/{professorId}")
    public ResponseEntity<String> assignModuloToProfessor(@PathVariable Integer moduloId, @PathVariable Integer professorId) {
        Modulos modulo = servicio.assignModuloToProfessor(moduloId, professorId);
        if (modulo != null) {
            return ResponseEntity.ok("Módulo asignado correctamente al profesor");
        } else {
            return ResponseEntity.badRequest().body("No se pudo asignar el módulo al profesor");
        }
    }

    @PutMapping("/modulos/{moduloId}/assign-students")
    public ResponseEntity<String> assignStudentsToModulo(@PathVariable Integer moduloId, @RequestBody List<Integer> studentIds) {
        Modulos modulo = servicio.assignStudentsToModulo(moduloId, studentIds);
        if (modulo != null) {
            return ResponseEntity.ok("Estudiantes asignados correctamente al módulo");
        } else {
            return ResponseEntity.badRequest().body("No se pudo asignar los estudiantes al módulo");
        }
    }


}
