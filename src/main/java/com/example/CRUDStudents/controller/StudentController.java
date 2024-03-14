package com.example.CRUDStudents.controller;


import com.example.CRUDStudents.dto.StudentDto;
import com.example.CRUDStudents.entity.Students;
import com.example.CRUDStudents.service.serviceClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class StudentController {

    @Autowired
    private serviceClass serviceClass;
    @GetMapping("/students")
    public List<StudentDto> getAllStudents() {
        return serviceClass.getStudents();
    }

    @PostMapping("/students/new")
    public Students addStudent(@RequestBody Students newstudent){
        return serviceClass.addStudent(newstudent);
    }

    @PutMapping("/students/edit/{id}")
    public Students editStudent(@PathVariable Integer id, @RequestBody Students student){
       return serviceClass.editStudent(id,student);
    }

    @GetMapping("/students/{id}")
    public Optional<Students> getStudentById(@PathVariable Integer id){
        return serviceClass.getStudentById(id);
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable Integer id){
        serviceClass.deleteStudent(id);
    }

    @GetMapping("/hola")
public String saludo(){
        return "hola!";
    }

    @GetMapping("/holanombre/{nombre}/{edad}")
    public String holaMundoNombre(@PathVariable String nombre,@PathVariable int edad){
return  "Hola! "+nombre+ " Tu edad es :" + edad;
    }

@GetMapping("/students/page/{pagina}/{tamaño}")
    public Page<Students> getStudents(@PathVariable int pagina,@PathVariable int tamaño){
        return serviceClass.getStudents(pagina,tamaño);
}

    @GetMapping("/students/page")
    public Page<Students> getStudens(){
        return serviceClass.getStudens();
    }


    @GetMapping ("/StudentsPageNombreAscendente")
    public Page<Students> getAllStudentsPaginadosNombre(Pageable pageable){
        return serviceClass.getAllStudentsPaginadosNombre(pageable);
    }

    @GetMapping ("/StudentsPageVariable")
    public Page<Students> getAllStudentsVariablePage(@PageableDefault()Pageable pageable){
        return serviceClass.getAllStudentsVariablePage(pageable);
    }

    @GetMapping ("/StudentsPageDefault")
    public Page<Students> getAllStudentsDefaultPage(@PageableDefault(page = 0,size = 20)Pageable pageable){
        return serviceClass.getAllStudentsDefaultPage(pageable);
    }

}
