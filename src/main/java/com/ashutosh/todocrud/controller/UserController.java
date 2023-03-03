package com.ashutosh.todocrud.controller;

import com.ashutosh.todocrud.entity.Todo;
import com.ashutosh.todocrud.services.TodoServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
TODO
    - Annotate the class to make it a controller which can handle REST queries.
    - Add a base URL to the controller class.
 */
public class UserController {

    private final TodoServices todoServices;

    public UserController(TodoServices todoServices){
        this.todoServices = todoServices;
    }

    /*
    TODO
     - 1. Write the correct mapping for adding Todo.
     - 2. Take the correct parameter in the method body.
     - 3. Call the required service method from the Todo service class.
     */
    public void addTodo(){
    }

    /*
    TODO
        1. Write the correct mapping for getting all Todo.
        2. Call the required service method from the Todo service class.
     */
    public List<Todo> getAllTodos(){
    }
}
