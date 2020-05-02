package com.example.demo.service;

import com.example.demo.dao.ModifyPwdMapper;
import com.example.demo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: ER_Platform
 * @description: 1
 * @author: Luo Fujie
 * @create: 2020-04-22 00:09
 */
@Service
public class ModifyPwdService {

    @Autowired
    ModifyPwdMapper modifyPwdMapper;

    /**通过用户名获得密码*/
    public String getPasswordByUsername(String student_username) {
        return modifyPwdMapper.findUserByUsername(student_username).getStudent_pwd();
    }

    /**修改某一用户的密码*/
    public void modifyPasswordByUsername(String student_username, String newPassword) {
        Student student = modifyPwdMapper.findUserByUsername(student_username);
        student.setStudent_username(student_username);
        student.setStudent_pwd(newPassword);
        modifyPwdMapper.modifyPasswordByUsername(student);
    }
}
