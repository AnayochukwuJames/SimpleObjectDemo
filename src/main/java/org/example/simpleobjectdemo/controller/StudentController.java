package org.example.simpleobjectdemo.controller;

import org.example.simpleobjectdemo.model.StudentObject;
import org.example.simpleobjectdemo.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class StudentController {

    private final StudentService studentService;

    //Dependency injection through Constructor
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping(value = "/student")
    public ResponseEntity<List<StudentObject>> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<StudentObject> getStudentById(@PathVariable int id){
        return studentService.getStudentById(id);
    }

    @PostMapping("/student")
    public ResponseEntity<StudentObject> postStudent(@RequestBody StudentObject studentObject ){
        return studentService.postStudent(studentObject);
    }


    @PutMapping("/student/{id}")
    public ResponseEntity<StudentObject> updateStudentInfo(@PathVariable int id, @RequestBody StudentObject replacementObject){
        return studentService.updateStudentInfo(id, replacementObject);
    }

    @DeleteMapping("/student")
    public ResponseEntity<StudentObject> deleteStudent(@RequestParam int id){
        return studentService.deleteStudent(id);
    }



}