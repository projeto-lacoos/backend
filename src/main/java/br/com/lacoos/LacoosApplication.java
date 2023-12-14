package br.com.lacoos;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class LacoosApplication {

    public static void main(String[] args) {
        SpringApplication.run(LacoosApplication.class, args);
        System.out.println("Api Rodando!");
    }
}