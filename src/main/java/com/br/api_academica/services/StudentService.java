package com.br.api_academica.services;

import org.springframework.stereotype.Service;

import com.br.api_academica.domains.Student;
import com.br.api_academica.dtos.StudentDTO;
import com.br.api_academica.mappers.StudentMapper;
import com.br.api_academica.repositories.StudentRepository;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    public List<StudentDTO> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return studentMapper.toDTOList(students);
    }

    public StudentDTO getStudentById(UUID id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Student not found with id: " + id));
        return studentMapper.toDTO(student);
    }

    public StudentDTO createStudent(StudentDTO studentDTO) {
        Student student = studentMapper.toEntity(studentDTO);
        Student newStudent = studentRepository.save(student);
        return studentMapper.toDTO(newStudent);
    }

    public StudentDTO updateStudent(UUID id, StudentDTO studentDetailsDTO) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Student not found with id: " + id));

        // Update the existing entity with data from the DTO
        studentMapper.updateEntityFromDTO(studentDetailsDTO, student);

        Student updatedStudent = studentRepository.save(student);
        return studentMapper.toDTO(updatedStudent);
    }

    public void deleteStudent(UUID id) {
        if (!studentRepository.existsById(id)) {
            throw new EntityNotFoundException("Student not found with id: " + id);
        }
        studentRepository.deleteById(id);
    }
}