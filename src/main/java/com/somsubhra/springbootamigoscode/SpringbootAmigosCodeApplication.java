package com.somsubhra.springbootamigoscode;

import com.somsubhra.springbootamigoscode.student.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
@RestController
public class SpringbootAmigosCodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootAmigosCodeApplication.class, args);
    }

    @GetMapping
    public List<Student> hello() {
        return List.of(new Student(1L, "Mariam",
                "mariam@gmail.com", LocalDate.of(2000, Month.MAY, 23), 21));
    }

}
