package com.example.CRUDStudents.Repository;

import com.example.CRUDStudents.entity.Modulos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IModuloRepo extends JpaRepository<Modulos,Integer> {
}
