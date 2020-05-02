package com.example.demo.service;

import com.example.demo.dao.RegisterMapper;
import com.example.demo.entity.Admin;
import com.example.demo.entity.Student;
import com.example.demo.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: ER_Platform
 * @description: 1
 * @author: Luo Fujie
 * @create: 2020-04-18 13:49
 */
@Service
public class RegisterService {

    @Autowired
    RegisterMapper registerMapper;

    //学生注册
    public Boolean stuRegister(Student student) {
        Integer insert = registerMapper.stuRegister(student);
        //受影响条数>0代表注册成功
        if(insert > 0){
            return true;
        }else {
            return false;
        }
    }

    //老师注册
    public Boolean tecRegister(Teacher teacher) {
        Integer insert = registerMapper.tecRegister(teacher);
        //受影响条数>0代表注册成功
        if(insert > 0){
            return true;
        }else {
            return false;
        }
    }

    //管理员注册
    public Boolean adminRegister(Admin admin) {
        Integer insert = registerMapper.adminRegister(admin);
        //受影响条数>0代表注册成功
        if(insert > 0){
            return true;
        }else {
            return false;
        }
    }
}
