package com.example.CRUDStudents.Repository;

import com.example.CRUDStudents.entity.Boe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBoeRepository extends JpaRepository<Boe, Long> {

    Boe findTopByOrderByFechaBoeDesc();
}