package com.br.api_academica.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.br.api_academica.model.Aluno;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/aluno")
public class AlunoController {

    List<Aluno> alunos = new ArrayList<>();

    AlunoController() {
        Aluno aluno1 = new Aluno(1,"pedro",20);
        Aluno aluno2 = new Aluno(2,"pedro2",21);
        Aluno aluno3 = new Aluno(3,"pedro3",22);   

        alunos.add(aluno1);
        alunos.add(aluno2);
        alunos.add(aluno3);
    }

    @GetMapping("/alunos")
    public ResponseEntity<List<Aluno>> getAll() {
        return ResponseEntity.ok(alunos);
    }

    @GetMapping("/alunos/{id}")
    public ResponseEntity<Aluno> getById(@PathVariable int id) {
        Aluno aluno = null;

        for (int i = 0; i < alunos.size(); i++){
            Aluno alunoAtual = alunos.get(i);

            if (alunoAtual.getId() == id) {
                aluno = alunoAtual;
                break;
            }
        }

        return ResponseEntity.ok(aluno);
    }
}