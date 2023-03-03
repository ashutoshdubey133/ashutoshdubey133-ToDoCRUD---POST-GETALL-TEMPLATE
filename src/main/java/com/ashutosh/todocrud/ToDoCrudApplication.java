package com.ashutosh.todocrud;

import com.ashutosh.todocrud.entity.Todo;
import com.ashutosh.todocrud.repository.ToDoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ToDoCrudApplication{

    public static void main(String[] args) {
        SpringApplication.run(ToDoCrudApplication.class, args);
    }

}
