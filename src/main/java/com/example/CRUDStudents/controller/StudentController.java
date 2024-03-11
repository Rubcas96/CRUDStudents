package com.example.CRUDStudents.controller;

import com.example.CRUDStudents.Repository.IStudentRepository;
import com.example.CRUDStudents.entity.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class StudentController {

    @Autowired
    private IStudentRepository iStudentRepository;
    @GetMapping("/students")
    public List<Students> getAllStudents(){
        return iStudentRepository.findAll();
    }

    @PostMapping("/students/new")
    public Students addStudent(@RequestBody Students newstudent){
        return iStudentRepository.save(newstudent);
    }

    @PatchMapping("/students/edit{id}")
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

    @GetMapping("/students/{id}")
    public Optional<Students> getStudentById(@PathVariable Integer id){
        return  iStudentRepository.findById(id);
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable Integer id){
        iStudentRepository.deleteById(id);
    }


}
