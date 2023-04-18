package com.gcu.todoserver;

import com.gcu.todoserver.mapper.TodoMapper;
import com.gcu.todoserver.pojo.Todo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TodoServerApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    TodoMapper todoMapper;

    @Test
    void testListAllTodo(){
        System.out.println(todoMapper.listAllTodo());
    }

    @Test
    void testGetTodoById(){
        int id = 1;
        System.out.println(todoMapper.getTodoById(id));
    }

    @Test
    void testAddTodo(){
        Todo todo = new Todo("test2");
        System.out.println(todoMapper.addTodo(todo));
        Todo newTodo = todoMapper.getTodoById(2);
        System.out.println(newTodo);
    }

    @Test
    void testDeleteTodo(){
        System.out.println(todoMapper.deleteTodo(3));
        System.out.println(todoMapper.listAllTodo());
    }

    @Test
    void testUpdateTodo(){
        Todo t = todoMapper.getTodoById(1);
        t.setLastText(t.getText());
        t.setText("新的test");
        t.setDone(true);
        todoMapper.updateTodo(t);
        Todo newTodo = todoMapper.getTodoById(1);
        System.out.println(newTodo);
    }

}
