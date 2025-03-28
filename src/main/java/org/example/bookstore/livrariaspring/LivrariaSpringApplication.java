package org.example.bookstore.livrariaspring;
import entities.Livro;
import entities.Vendedor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LivrariaSpringApplication {


    public static void main(String[] args) {
        SpringApplication.run(LivrariaSpringApplication.class, args);
    }

}

