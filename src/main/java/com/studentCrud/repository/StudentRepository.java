package com.studentCrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studentCrud.model.Students;

public interface StudentRepository extends JpaRepository<Students, Long>{

}
