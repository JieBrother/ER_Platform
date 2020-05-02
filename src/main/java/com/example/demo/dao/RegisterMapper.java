package com.example.demo.dao;

import com.example.demo.entity.Admin;
import com.example.demo.entity.Student;
import com.example.demo.entity.Teacher;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author Jie
 */
@Mapper
@Repository
public interface RegisterMapper {

    @Insert("insert into student_information(student_name,student_username,student_pwd) values(#{student_name}," +
            "#{student_username},#{student_pwd})")
    Integer stuRegister(Student student);

    @Insert("insert into teacher_information(teacher_name,teacher_username,teacher_pwd) values(#{teacher_name}," +
            "#{teacher_username},#{teacher_pwd})")
    Integer tecRegister(Teacher teacher);

    @Insert("insert into admin_information(admin_username,admin_pwd) values(#{admin_username},#{admin_pwd})")
    Integer adminRegister(Admin admin);
}
