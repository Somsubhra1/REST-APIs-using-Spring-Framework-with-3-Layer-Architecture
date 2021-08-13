package com.somsubhra.springbootamigoscode.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

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

    public void addNewStudent(Student student) {
//        System.out.println(student);
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("email taken!");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(long studentId) {
        boolean exists = studentRepository.existsById(studentId);

        if (!exists) {
            throw new IllegalStateException("student with id " + studentId + " doesn't exist");
        }
        studentRepository.deleteById(studentId);
    }
}
