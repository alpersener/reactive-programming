package com.project.reactiveprogramming.service;

import com.project.reactiveprogramming.model.Student;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface StudentService {
    Flux<Student> findAll();

    Mono<Student> findById(Integer id);

    Mono<Student> save(Student student);

     Flux<Student> findByFirstname(String firstname);

     void deleteById(Integer id);

}
