package org.example.simpleobjectdemo.service;

import org.example.simpleobjectdemo.model.StudentObject;
import org.example.simpleobjectdemo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public ResponseEntity<List<StudentObject>> getAllStudents(){
        return new ResponseEntity<>(studentRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<StudentObject> getStudentById(int id){
        try{
            return new ResponseEntity<>(studentRepository.findById(id).get(), HttpStatus.OK);
        } catch (NoSuchElementException exception){
            System.out.println(exception.getMessage());
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }

    public ResponseEntity<StudentObject> postStudent( StudentObject studentObject ){
        return new ResponseEntity<>(studentRepository.save(studentObject), HttpStatus.CREATED);
    }


    public ResponseEntity<StudentObject> updateStudentInfo(int id, StudentObject replacementObject){
        StudentObject student = studentRepository.findById(id).get();
        student.setFirstName(replacementObject.getFirstName());
        student.setLastName(replacementObject.getLastName());
        student.setAddress(replacementObject.getAddress());
        student.setCourse(replacementObject.getCourse());
        student.setPhoneNumber(replacementObject.getPhoneNumber());

        return new ResponseEntity<>(studentRepository.save(student), HttpStatus.OK);
    }

    public ResponseEntity<StudentObject> deleteStudent(int id){
        StudentObject object = studentRepository.findById(id).get();
        studentRepository.deleteById(id);
        return new ResponseEntity<>(object, HttpStatus.OK);
    }

}