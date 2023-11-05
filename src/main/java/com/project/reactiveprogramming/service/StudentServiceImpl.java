package com.project.reactiveprogramming.service;

import com.project.reactiveprogramming.model.Student;
import com.project.reactiveprogramming.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;


    @Override
    public Mono<Student> save(Student student){
        return studentRepository.save(student);
    }

    @Override
    public Flux<Student> findAll(){
        return studentRepository.findAll()
                //adding delay like consider we applying some logic,photos etc..
                .delayElements(Duration.ofSeconds(1));
    }

    @Override
    public Mono<Student> findById(Integer id){
        return studentRepository.findById(id);
    }
}
