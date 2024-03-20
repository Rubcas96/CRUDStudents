package com.example.CRUDStudents.service;

import com.example.CRUDStudents.Repository.IUserRepository;
import com.example.CRUDStudents.entity.User;
import com.example.CRUDStudents.mail.EmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private IUserRepository userRepository;

    private PasswordEncoder passwordEncoder;


    private final EmailSender emailSender;

    public UserService(EmailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void registerUser(User user) {
        // Lógica para registrar al usuario
        userRepository.save(user);

        // Envío de correo electrónico de confirmación
        String to = user.getEmail();
        String subject = "Confirmación de registro";
        String text = "Hola " + user.getName() + ", tu registro ha sido exitoso.";
        emailSender.sendEmail(to, subject, text);
    }

    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

}
