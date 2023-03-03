package com.ashutosh.todocrud.services;

import com.ashutosh.todocrud.entity.Todo;
import com.ashutosh.todocrud.repository.ToDoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

/*
TODO
    - Annotate the class to mark it as Service class.
 */
public class TodoServices {

    private final ToDoRepository toDoRepository;


    public TodoServices(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    /*
        TODO
            - Write proper method parameters to get Todo.
            - Save the todo to the database.
     */
    public void addTodo(){

    }

    /*
    TODO
        - Return a list of Todos from the database.
     */
    public List<Todo> getAllTodo() {

    }
}
