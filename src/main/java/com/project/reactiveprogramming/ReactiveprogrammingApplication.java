package com.project.reactiveprogramming;

import com.project.reactiveprogramming.student.Student;
import com.project.reactiveprogramming.student.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ReactiveprogrammingApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReactiveprogrammingApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(StudentService studentService){
        return args->{
            for (int i = 0; i < 100; i++) {
                studentService.save(
                        Student.builder()
                                .firstname("alper"+i)
                                .lastname("sener"+i)
                                .age(i)
                                .build()
                ).subscribe();

            }
        };

    }

}
