package org.example.pojo;

import lombok.Data;

/**
 * @author churry
 */
@Data
public class Student {
    private long id;
    private String number;
    private String name;
    private int age;
    private String place;
    private  int chi;
    private int math;
    private int eng;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getChi() {
        return chi;
    }

    public void setChi(int chi) {
        this.chi = chi;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getEng() {
        return eng;
    }

    public void setEng(int eng) {
        this.eng = eng;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", place='" + place + '\'' +
                ", chi=" + chi +
                ", math=" + math +
                ", eng=" + eng +
                '}';
    }
}
