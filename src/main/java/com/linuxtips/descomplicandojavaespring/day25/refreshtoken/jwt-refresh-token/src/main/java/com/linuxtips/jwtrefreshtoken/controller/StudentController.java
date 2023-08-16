package com.linuxtips.jwtrefreshtoken.controller;

import com.linuxtips.jwtrefreshtoken.model.Student;
import com.linuxtips.jwtrefreshtoken.service.StudentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@AllArgsConstructor
@Slf4j
public class StudentController {

    StudentService studentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student) {
        log.info("Criando uma nova estudante com as informacoes [{}]", student);
        return studentService.createStudent(student);
    }

    @GetMapping("/find")
    @ResponseStatus(HttpStatus.OK)
    public List<Student> getAllStudents() {
        log.info("Listando estudantes cadastradas");
        return studentService.listAllStudents();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Student> getStudentById(@PathVariable (value = "id") Long id) {
        log.info("Buscando estudante com o id [{}]", id);
        return studentService.findStudentById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Student> updateStudentById(@PathVariable (value = "id") Long id, @RequestBody Student student) {
        log.info("Atualizando estudante com id [{}] as novas informações são : [{}]",id, student);

        return studentService.updateStudentById(student,id);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> deleteStudentById(@PathVariable (value = "id") Long id) {
        log.info("Excluindo estudante com o id [{}]", id);
        return studentService.deleteStudentById(id);
    }
}

