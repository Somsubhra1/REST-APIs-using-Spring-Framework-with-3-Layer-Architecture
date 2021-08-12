package com.somsubhra.springbootamigoscode.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service // more specific to service. Can even use Component here.
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
//        return List.of(new Student(1L, "Mariam",
//                "mariam@gmail.com", LocalDate.of(2000, Month.MAY, 23), 21));
        return studentRepository.findAll();
    }
}
