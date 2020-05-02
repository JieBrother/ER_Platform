package com.example.demo.controller;

import com.example.demo.entity.Admin;
import com.example.demo.entity.Student;
import com.example.demo.entity.Teacher;
import com.example.demo.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: ER_Platform
 * @description: 1
 * @author: Luo Fujie
 * @create: 2020-04-18 13:39
 */
@Controller
public class RegisterController {

    @Autowired
    RegisterService registerService;

    /**学生注册*/
    @RequestMapping("/stuRegister")
    @ResponseBody
    public String stuRegister(Student student){
        Boolean register = registerService.stuRegister(student);
        if (register){
            return "redirect:http://localhost:8080/loginhtml/studentLogin.html";
        }else {
            return "registerhtml/studentRegister.html";
        }
    }

    /**老师注册*/
    @RequestMapping("/tecRegister")
    public String tecRegister(Teacher teacher){
        Boolean register = registerService.tecRegister(teacher);
        if(register){
            return "";
        }else {
            return "";
        }
    }

    /**管理员注册*/
    @RequestMapping("/adminRegister")
    public String adminRegister(Admin admin){
        Boolean register = registerService.adminRegister(admin);
        if (register){
            return "";
        }else {
            return "";
        }
    }
}
