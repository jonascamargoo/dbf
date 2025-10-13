package com.br.api_academica.mappers;


import com.br.api_academica.domains.Student;
import com.br.api_academica.dtos.StudentDTO;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    StudentDTO toDTO(Student student);

    Student toEntity(StudentDTO studentDTO);

    List<StudentDTO> toDTOList(List<Student> students);

    void updateEntityFromDTO(StudentDTO studentDTO, @MappingTarget Student student);
}