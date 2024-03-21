package com.example.CRUDStudents;

import jdk.jfr.Enabled;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class  CrudStudentsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudStudentsApplication.class, args);
	}
}
