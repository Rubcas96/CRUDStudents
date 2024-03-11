package com.example.CRUDStudents.controller;

import com.example.CRUDStudents.Repository.IStudentRepository;
import com.example.CRUDStudents.entity.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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

    @PutMapping("/students/edit/{id}")
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

    @GetMapping("/hola")
public String saludo(){
        return "hola!";
    }

    @GetMapping("/holanombre/{nombre}/{edad}")
    public String holaMundoNobre(@PathVariable String nombre,@PathVariable int edad){
return  "Hola! "+nombre+ " Tu edad es :" + edad;
    }

@GetMapping("/students/page/{pagina}/{tamaño}")
    public Page<Students> getStudents(@PathVariable int pagina,@PathVariable int tamaño){
final Pageable pageable = PageRequest.of(pagina,tamaño, Sort.by(Sort.Direction.ASC,"name"));
        return (Page<Students>) iStudentRepository.findAll(pageable);
}

    @GetMapping("/students/page")
    public Page<Students> getStudens(){
        final Pageable pageable = PageRequest.of(0,2);
        return (Page<Students>) iStudentRepository.findAll(pageable);
    }


    @GetMapping ("/StudentsPageNombreAscendente")
    public Page<Students> getAllStudentsPaginadosNombre(Pageable pageable){
        // final Pageable pageable = PageRequest.of(0,5, Sort.by(Sort.Direction.ASC));
        return iStudentRepository.findAll(pageable);
    }

    @GetMapping ("/StudentsPageVariable")
    public Page<Students> getAllStudentsVariablePage(@PageableDefault()Pageable pageable){
        return iStudentRepository.findAll(pageable);
    }

    @GetMapping ("/StudentsPageDefault")
    public Page<Students> getAllStudentsDefaultPage(@PageableDefault(page = 0,size = 20)Pageable pageable){
        return iStudentRepository.findAll(pageable);
    }

}
