package com.gcu.todoserver.controller;

import com.gcu.todoserver.mapper.TodoMapper;
import com.gcu.todoserver.pojo.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {
    @Autowired
    private TodoMapper todoMapper;

    @GetMapping("/todos")
    public List<Todo> listAllTodo(){
        return todoMapper.listAllTodo();
    }

    @PostMapping("/todo")
    public int addTodo(@RequestBody String text){
        Todo todo = new Todo(text);
        return todoMapper.addTodo(todo);
    }

    @DeleteMapping("/todo/{id}")
    public int deleteTodo(@PathVariable("id") int id){
        return todoMapper.deleteTodo(id);
    }
}
