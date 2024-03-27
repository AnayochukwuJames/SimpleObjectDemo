package org.example.simpleobjectdemo.repository;

import org.example.simpleobjectdemo.model.StudentObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentObject, Integer> {

}
