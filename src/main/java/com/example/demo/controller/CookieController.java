package com.example.demo.controller;

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
 * @create: 2020-04-20 16:13
 */
@Controller
public class CookieController {

    @Autowired
    LoginService loginService;

    /**获取cookie*/
    @RequestMapping("/getStudentCookie")
    @ResponseBody
    public String initCookie(HttpServletRequest request){
        Cookie[] cookie = request.getCookies();
        for(Cookie c : cookie){
            if ("studentLogin".equals(c.getName())){
                String studentName = c.getValue();
//                System.out.println(studentName);
                return studentName;
            }
        }
        return null;
    }

    /**删除Cookie*/
    @RequestMapping("/delStudentCookie")
    @ResponseBody
    public String deleteCookie(HttpServletResponse response,HttpServletRequest request){
        Cookie[] cookie = request.getCookies();
        for(Cookie c : cookie){
            if ("studentLogin".equals(c.getName())){
                c.setMaxAge(0);
                response.addCookie(c);
                return "success";
            }
        }
        return "error";
    }


}
