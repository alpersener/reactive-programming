package com.project.reactiveprogramming;

import com.project.reactiveprogramming.model.Student;
import com.project.reactiveprogramming.service.StudentService;
import com.project.reactiveprogramming.service.StudentServiceImpl;
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
            for (int i = 0; i < 10; i++) {
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
