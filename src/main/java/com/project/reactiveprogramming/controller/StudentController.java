package com.project.reactiveprogramming.controller;

import com.project.reactiveprogramming.model.Student;
import com.project.reactiveprogramming.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @PostMapping
    public Mono<ResponseEntity<Student>> save(@RequestBody Mono<Student> student){
        return student.flatMap(studentService::save)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.badRequest().build());
    }

    @GetMapping
    public Flux<Student> findAll(){
        return studentService.findAll();

    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Student>> findById(@PathVariable Integer id){
        return studentService.findById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/filter")
    @ResponseStatus(HttpStatus.OK)
    public Flux<Student> findByName(@RequestParam String name) {
        return studentService.findByFirstname(name);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Integer id) {
        studentService.deleteById(id);
    }



}
