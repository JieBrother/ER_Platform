package com.example.demo.service;

import com.example.demo.dao.LoginMapper;
import com.example.demo.entity.Admin;
import com.example.demo.entity.Student;
import com.example.demo.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: ER_Platform
 * @description: 1
 * @author: Luo Fujie
 * @create: 2020-04-18 11:54
 */
@Service
public class LoginService {

    @Autowired
    LoginMapper loginMapper;

    /**学生登录*/
    public Boolean stuLogin(Student student) {
        Integer count = loginMapper.stuLogin(student);
        if (1 == count){
            return true;
        }else{
            return false;
        }
    }

    /**老师登录*/
    public Boolean tecLogin(Teacher teacher) {
        Integer count = loginMapper.tecLogin(teacher);
        if(1 == count){
            return true;
        }else {
            return false;
        }
    }

    /**管理员登录*/
    public Boolean adminLogin(Admin admin) {
        Integer count = loginMapper.adminLogin(admin);
        if(1 == count){
            return true;
        }else {
            return false;
        }
    }
}
