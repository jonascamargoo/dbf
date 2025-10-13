package com.br.api_academica.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.api_academica.domains.Student;

import org.springframework.security.core.userdetails.UserDetails;

public interface StudentRepository extends JpaRepository<Student, UUID> {
    UserDetails findByLogin(String login);
}