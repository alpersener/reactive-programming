package com.project.reactiveprogramming.controller;

import com.project.reactiveprogramming.model.Student;
import com.project.reactiveprogramming.service.StudentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentServiceImpl studentServiceImpl;

    @PostMapping
    public Mono<Student> save(@RequestBody Student student){
        return studentServiceImpl.save(student);
    }

    @GetMapping
    public Flux<Student> findAll(){
        return studentServiceImpl.findAll();

    }

    @GetMapping("/{id}")
    public Mono<Student> findById(@PathVariable Integer id){
        return studentServiceImpl.findById(id);
    }

}
