package com.example.CRUDStudents.Repository;

import com.example.CRUDStudents.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRepository extends JpaRepository <Students,Integer> {
}
