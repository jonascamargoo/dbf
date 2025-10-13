package com.br.api_academica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.api_academica.domains.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
