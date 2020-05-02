package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.service.ModifyPwdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: ER_Platform
 * @description: 1
 * @author: Luo Fujie
 * @create: 2020-04-22 00:08
 */
@Controller
public class ModifyPwdController {

    @Autowired
    ModifyPwdService modifyPwdService;

    @RequestMapping("/modifyPwd")
    @ResponseBody
    public String modifyPassword(@RequestParam(name = "oldPassword") String oldPassword,
                                 @RequestParam(name = "newPassword") String newPassword, @CookieValue("studentLogin") String student_username){
//        System.out.println(student_username);
        if (oldPassword.equals(modifyPwdService.getPasswordByUsername(student_username))){
            modifyPwdService.modifyPasswordByUsername(student_username,newPassword);
            return "success";
        }else {
            return "error";
        }

    }

}
