package com.example.CRUDStudents.Repository;

import com.example.CRUDStudents.entity.Professors;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProfesorRepository extends JpaRepository<Professors,Integer> {
}
