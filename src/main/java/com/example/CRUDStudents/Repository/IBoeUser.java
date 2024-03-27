package com.example.CRUDStudents.Repository;

import com.example.CRUDStudents.entity.Boe;
import com.example.CRUDStudents.entity.BoeUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBoeUser extends JpaRepository<BoeUser, Long> {

}
