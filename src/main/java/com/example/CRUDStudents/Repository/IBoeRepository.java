package com.example.CRUDStudents.Repository;

import com.example.CRUDStudents.entity.Boe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBoeRepository extends JpaRepository<Boe, Long> {

    Boe findTopByOrderByFechaBoeDesc();

    @Query("SELECT b FROM Boe b WHERE b.id NOT IN (SELECT bu.boe.id FROM BoeUser bu WHERE bu.user.id = :userId)")
    List<Boe> findNotSubscribedBoes(@Param("userId") Long userId);

}