package com.br.api_academica;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiAcademicaApplication {

    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();

        String dbUrl = dotenv.get("DB_URL");
        String dbUser = dotenv.get("DB_USER");
        String dbPassword = dotenv.get("DB_PASSWORD");

        System.out.println("--- DIAGNÓSTICO DO .env ---");
        System.out.println("DB_URL lido: " + dbUrl);
        System.out.println("DB_USER lido: " + dbUser);
        System.out.println("---------------------------");

        if (dbUrl == null || dbUrl.trim().isEmpty()) {
            System.err.println("ERRO CRÍTICO: Não foi possível ler as variáveis do arquivo .env.");
            System.err.println("Verifique se o arquivo .env está na raiz do projeto e tente novamente.");
            return; // Impede a aplicação de continuar se o .env não for lido
        }
        
        System.setProperty("DB_URL", dbUrl);
        System.setProperty("DB_USER", dbUser);
        System.setProperty("DB_PASSWORD", dbPassword);

        SpringApplication.run(ApiAcademicaApplication.class, args);
    }
}