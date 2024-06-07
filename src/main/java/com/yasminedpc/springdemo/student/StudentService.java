package com.yasminedpc.springdemo.student;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StudentService {
    public List<Student> findAllStudents(){
        return List.of(
                new Student("Yasmine",
                        "BenSlimane",
                        LocalDate.now(),
                        "yasmine@email.com",
                        21)
                ,
                new Student("nadine",
                        "BenSlimane",
                        LocalDate.now(),
                        "nadine@email.com",
                        19)
        );

    }
}
