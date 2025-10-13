package com.br.api_academica.dtos;

import com.br.api_academica.domains.UserRole;

public record RegisterDTO(String name, String login, String password, Integer age, UserRole role) {}