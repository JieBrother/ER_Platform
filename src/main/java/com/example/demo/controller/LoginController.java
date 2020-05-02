package com.example.demo.controller;

import com.example.demo.entity.Admin;
import com.example.demo.entity.Student;
import com.example.demo.entity.Teacher;
import com.example.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: ER_Platform
 * @description: 1
 * @author: Luo Fujie
 * @create: 2020-04-18 11:53
 */
@Controller
public class LoginController {

    @Autowired
    LoginService loginService;

    @RequestMapping("/")
    public String toLogin(){ return "/loginhtml/studentLogin.html";}

    /**学生登录*/
    @RequestMapping("/stuLogin")
    @ResponseBody
    public String stulogin(Student student, HttpServletResponse response, HttpServletRequest request){
//        System.out.println(student.getStudent_username());
        Boolean login = loginService.stuLogin(student);
        if(login){
            Cookie nameCookie = new Cookie("studentLogin",student.getStudent_username());
            nameCookie.setPath(request.getContextPath()+"/");
            nameCookie.setMaxAge(7*24*60*60);
            response.addCookie(nameCookie);
//            System.out.println(nameCookie.getValue());
//          return "redirect:http://localhost:8080/queue/studentQueue.html";
            return "success";
        }else {
//          return "redirect:http://localhost:8080/loginhtml/studentLogin.html";
            return "error";
        }
    }

    /**老师登录*/
    @RequestMapping("/tecLogin")
    public String tecLogin(Teacher teacher){
        Boolean login = loginService.tecLogin(teacher);
        if (login){
            return "redirect:http://localhost:8080/queue/studentQueue.html";
        }else {
            return "redirect:http://localhost:8080/loginhtml/teacherLogin.html";
        }
    }

    /**管理员登录*/
    @RequestMapping("/adminLogin")
    public String  adminLogin(Admin admin){
        Boolean login = loginService.adminLogin(admin);
        if(login){
            return "redirect:http://localhost:8080/queue/studentQueue.html";
        }else{
            return "redirect:http://localhost:8080/loginhtml/teacherLogin.html";
        }

    }

}
