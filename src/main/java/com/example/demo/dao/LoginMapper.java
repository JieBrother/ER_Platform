package com.example.demo.dao;

import com.example.demo.entity.Admin;
import com.example.demo.entity.Student;
import com.example.demo.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author Jie
 */
@Mapper
@Repository
public interface LoginMapper {

    @Select("select count(1) from student_information where student_username=#{student_username} and student_pwd=#{student_pwd}")
    Integer stuLogin(Student student);

    @Select("select count(1) from teacher_information where teacher_username=#{teacher_username} and teacher_pwd=#{teacher_pwd}")
    Integer tecLogin(Teacher teacher);

    @Select("select count(1) from admin_information where admin_username=#{admin_username} and admin_pwd=#{admin_pwd}")
    Integer adminLogin(Admin admin);
}
