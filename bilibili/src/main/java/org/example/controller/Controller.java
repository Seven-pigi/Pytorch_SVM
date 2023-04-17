package org.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.gson.Gson;
import org.example.mapper.StudentMapper;
import org.example.mapper.UserMapper;
import org.example.pojo.Student;
import org.example.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
@CrossOrigin(origins = {"*","null"})
@SuppressWarnings("all")
@RestController
public class Controller {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private UserMapper userMapper;

    private Gson gson = new Gson();

    @GetMapping("/students")
    public String getStudents(){
        List<Student> students = studentMapper.selectList(null);
        return gson.toJson(students);
    }

    @PostMapping("/add")
    public void addStudent(@RequestBody Student student){
        studentMapper.insert(student);
    }

    @PostMapping("/delete")
    public void removeStudent(@RequestBody Student student){
        studentMapper.deleteById(student);
    }

    @PostMapping("/update")
    public void updateStudent(@RequestBody Student student){
        studentMapper.updateById(student);
    }

    @PostMapping("login")
    public String loginStudent(@RequestBody User user){
        QueryWrapper<User> userQueryWrapper =  new QueryWrapper<>();
        userQueryWrapper.setEntity(user);
        User user_selected = userMapper.selectOne(userQueryWrapper);
        if(user_selected==null){
            return "0";
        }
        return "1";
    }

    @PostMapping("register")
    public void register(@RequestBody User user){
        userMapper.insert(user);
    }

    @PostMapping("search")
    public String search(@RequestBody HashMap<String,String> data){
        String name = data.get("name");
        QueryWrapper<Student> studentQueryWrapper=new QueryWrapper<>();
        studentQueryWrapper.like("name",name);
//        select * from student where name like "%%"
        List<Student> students = studentMapper.selectList(studentQueryWrapper);
        return gson.toJson(students);
    }


//    @GetMapping("/test")
//    public String test(){
//        List<Student> students = studentMapper.selectList(null);
//        return gson.toJson(students);
//    }

//    @GetMapping("/delete")
//    public void deleteStudent(){
//        String student = "{\"id\":3,\"number\":\"103\",\"name\":\"wangwu\",\"age\":20,\"chi\":88,\"math\":79," +
//                "\"eng\":88}";
//        Student student1 = gson.fromJson(student,Student.class);
//        studentMapper.deleteById(student1);
//    }

//    @GetMapping("/insert")
//    public void insertStudent(){
//        String student = "{\"id\":5,\"number\":\"103\",\"name\":\"caixukun\",\"age\":20,\"chi\":88,\"math\":79," +
//                "\"eng\":88}";
//        Student student1 = gson.fromJson(student,Student.class);
//        studentMapper.insert(student1);
//    }

//    @GetMapping("/update")
//    public void updateStudent(){
//        String student = "{\"id\":3,\"number\":\"103\",\"name\":\"wangchuyan\",\"age\":20,\"chi\":88,\"math\":79," +
//                "\"eng\":88}";
//        Student student1 = gson.fromJson(student,Student.class);
//        studentMapper.updateById(student1);
//    }

//    @PostMapping("/update")
//    public void updateStudent(@RequestBody Student student){
//        studentMapper.updateById(student);
//    }

//     "id":5,"name":"lili","age":20,"chi":90,"math":80,"eng":70

//    @GetMapping("/add")
//    public void addStudent(){
//        String student = "{\"id\":5,\"number\":\"103\",\"name\":\"caixukun\",\"age\":20,\"chi\":88,\"math\":79," +
//                "\"eng\":88}";
//        Student student1 = gson.fromJson(student,Student.class);
//        studentMapper.insert(student1);
//    }

}
