package com.linuxtips.jwtrefreshtoken.repository;

import com.linuxtips.jwtrefreshtoken.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}