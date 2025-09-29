package com.br.api_academica.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Aluno {
    private long id;
    private String name;
    private int idade;

    public Aluno(long id, String name, int idade) {
        this.name = name;
        this.id = id;
        this.idade = idade;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}