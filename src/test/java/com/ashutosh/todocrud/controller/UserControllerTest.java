package com.ashutosh.todocrud.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.description;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.ashutosh.todocrud.entity.Todo;
import com.ashutosh.todocrud.repository.ToDoRepository;
import com.ashutosh.todocrud.services.TodoServices;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TodoServices todoServices;

    @MockBean
    private ToDoRepository toDoRepository;

    private Todo todo;

    @Test
    @DisplayName("AddTodo GET Controller")
    void addTodo() throws Exception {
        todo = new Todo("testing todo");
        ObjectMapper objectMapper = new ObjectMapper();
        String todoJSON = objectMapper.writeValueAsString(todo);
        
        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.post("/users/todo").contentType(MediaType.APPLICATION_JSON).content(todoJSON)).andReturn();
        
        Assertions.assertEquals(200, result.getResponse().getStatus(),"Status code is not 200");
        verify(todoServices, description("You did not make a call to the add Todo Service Method")).addTodo((Todo) any());
    }

    @Test
    @DisplayName("GetAllTodos POST Controller")
    void getAllTodos() throws Exception {
        todo = new Todo("testing todo");
        List<Todo> list = new ArrayList<>();
        list.add(todo);
        ObjectMapper objectMapper = new ObjectMapper();
        String listJSON = objectMapper.writeValueAsString(list);
        
        when(todoServices.getAllTodo()).thenReturn(list);
        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.get("/users/todos").contentType(MediaType.APPLICATION_JSON)).andReturn();
        
        Assertions.assertEquals(200, result.getResponse().getStatus(),"Status code is not 200");
        
        String response = result.getResponse().getContentAsString();
        
        verify(todoServices, description("You did not make a call to the getAllTodo Method")).getAllTodo();        
        Assertions.assertEquals(listJSON, response, "Wrong Response Returned From /users/todos/ mapping");
    }

}