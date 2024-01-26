package ru.hogwarts.schooltasktwo;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition
@SpringBootApplication
public class SchoolTaskTwoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchoolTaskTwoApplication.class, args);
    }
}