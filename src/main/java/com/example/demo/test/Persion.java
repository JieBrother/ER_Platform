package com.example.demo.test;

import lombok.Data;

@Data
public class Persion {
    String name;
    int age;
    String sex;
    String hobby;

    public void eat() {
        System.out.println("吃饭");
    }

    public void sleep() {
        System.out.println("睡觉");
    }
}

@Data
class Student extends Persion {
    String number;
    String schoolName;
    String className;

    public Student(String number, String schoolName, String className) {
        this.number = number;
        this.schoolName = schoolName;
        this.className = className;
    }

    public void study() {
        System.out.println("我爱学习");
    }
}

class Test {
    public static void main(String[] args) {
        Student student = new Student("111", "nnxy", "iot1");
        System.out.println(student);
        student.study();
    }

}