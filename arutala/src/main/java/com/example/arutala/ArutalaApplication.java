package com.example.arutala;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing

public class ArutalaApplication {
  public static void main(String[] args) {
    SpringApplication.run(ArutalaApplication.class, args);
  }
}
