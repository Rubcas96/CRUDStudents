package com.example.CRUDStudents.service;


import com.example.CRUDStudents.Repository.IModuloRepo;
import com.example.CRUDStudents.Repository.IProfesorRepository;
import com.example.CRUDStudents.Repository.IStudentRepository;
import com.example.CRUDStudents.entity.Modulos;
import com.example.CRUDStudents.entity.Professors;
import com.example.CRUDStudents.entity.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class serviceClass {

    @Autowired
    private IStudentRepository iStudentRepository;
    @Autowired
    private IProfesorRepository iProfessorRepository;

    @Autowired
    private IModuloRepo IModuloRepo;


    //Students

    public List<Students> getAllStudents() {
        return iStudentRepository.findAll();
    }

    public Students addStudent(@RequestBody Students newstudent) {
        return iStudentRepository.save(newstudent);
    }

    public Students editStudent(@PathVariable Integer id, @RequestBody Students student){
        Optional<Students> studentsOptional = iStudentRepository.findById(id);
        if (studentsOptional.isPresent()){
            Students currentStudent = studentsOptional.get();
            currentStudent.setName(student.getName());
            currentStudent.setLastname(student.getLastname());
            currentStudent.setEmail(student.getEmail());
            return  iStudentRepository.save(currentStudent);
        }
        return null;
    }
    public Optional<Students> getStudentById(@PathVariable Integer id){
        return  iStudentRepository.findById(id);
    }

    public void deleteStudent(@PathVariable Integer id) {
        iStudentRepository.deleteById(id);
    }

    public Page<Students> getStudents(@PathVariable int pagina, @PathVariable int tamaño){
        final Pageable pageable = PageRequest.of(pagina,tamaño, Sort.by(Sort.Direction.ASC,"name"));
        return (Page<Students>) iStudentRepository.findAll(pageable);
    }


    public Page<Students> getStudens(){
        final Pageable pageable = PageRequest.of(0,2);
        return (Page<Students>) iStudentRepository.findAll(pageable);
    }



    public Page<Students> getAllStudentsPaginadosNombre(Pageable pageable){
        // final Pageable pageable = PageRequest.of(0,5, Sort.by(Sort.Direction.ASC));
        return iStudentRepository.findAll(pageable);
    }


    public Page<Students> getAllStudentsVariablePage(@PageableDefault()Pageable pageable){
        return iStudentRepository.findAll(pageable);
    }


    public Page<Students> getAllStudentsDefaultPage(@PageableDefault(page = 0,size = 20)Pageable pageable){
        return iStudentRepository.findAll(pageable);
    }

    public List<Professors> getAllProfessors() {
        return iProfessorRepository.findAll();
    }

    public Professors addProfessor(@RequestBody Professors newProfessor) {
        return iProfessorRepository.save(newProfessor);
    }

    public Professors editProfessor(@PathVariable Integer id, @RequestBody Professors professor) {
        Optional<Professors> professorsOptional = iProfessorRepository.findById(id);
        if (professorsOptional.isPresent()) {
            Professors currentProfessor = professorsOptional.get();
            currentProfessor.setName(professor.getName());
            currentProfessor.setLastname(professor.getLastname());
            currentProfessor.setEmail(professor.getEmail());
            return iProfessorRepository.save(currentProfessor);
        }
        return null;
    }

    public Optional<Professors> getProfessorById(@PathVariable Integer id) {
        return iProfessorRepository.findById(id);
    }

    public void deleteProfessor(@PathVariable Integer id) {
        iProfessorRepository.deleteById(id);
    }

    public Page<Professors> getProfessors(@PathVariable int pagina, @PathVariable int tamaño) {
        final Pageable pageable = PageRequest.of(pagina, tamaño, Sort.by(Sort.Direction.ASC, "name"));
        return iProfessorRepository.findAll(pageable);
    }

    public Page<Professors> getProfessors() {
        final Pageable pageable = PageRequest.of(0, 2);
        return iProfessorRepository.findAll(pageable);
    }

    public Page<Professors> getAllProfessorsPaginadosNombre(Pageable pageable) {
        return iProfessorRepository.findAll(pageable);
    }

    public Page<Professors> getAllProfessorsVariablePage(@PageableDefault() Pageable pageable) {
        return iProfessorRepository.findAll(pageable);
    }

    public Page<Professors> getAllProfessorsDefaultPage(@PageableDefault(page = 0, size = 20) Pageable pageable) {
        return iProfessorRepository.findAll(pageable);
    }

 //modulo

    public Modulos saveModulo(Modulos modulo) {
        return IModuloRepo.save(modulo);
    }

    public List<Modulos> getModulos() {
        return IModuloRepo.findAll();
    }

    public Modulos editModulo(Integer codigo, Modulos modulo) {
        Optional<Modulos> moduloOptional = IModuloRepo.findById(codigo);
        if (moduloOptional.isPresent()) {
            Modulos currentModulo = moduloOptional.get();
            currentModulo.setName(modulo.getName());
            currentModulo.setCodModulo(modulo.getCodModulo());
            return IModuloRepo.save(currentModulo);
        }
        return null;
    }


    public void deleteModulo(Integer codigo) {
        IModuloRepo.deleteById(codigo);
    }




}