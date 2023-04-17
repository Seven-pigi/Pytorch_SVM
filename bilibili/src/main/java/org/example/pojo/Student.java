package org.example.pojo;

import lombok.Data;

@Data
// 添加一些方法
public class Student {
    private long id;
    private String number;
    private String name;
    private int age;
    private int chi;
    private int math;
    private int eng;
}
