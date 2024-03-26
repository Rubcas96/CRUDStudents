package com.example.CRUDStudents.Repository;

import com.example.CRUDStudents.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User,Long> {
    User findByUsernameAndPassword(String username, String password);

}
