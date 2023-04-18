package com.gcu.todoserver.mapper;

import com.gcu.todoserver.pojo.Todo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TodoMapper {
    List<Todo> listAllTodo();

    Todo getTodoById(@Param("id") int id);

    int addTodo(Todo todo);

    int deleteTodo(@Param("id") int id);

    int updateTodo(Todo todo);
}
