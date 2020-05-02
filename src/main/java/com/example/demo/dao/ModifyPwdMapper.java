package com.example.demo.dao;

import com.example.demo.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * @author Jie
 */
@Mapper
@Repository
public interface ModifyPwdMapper {

    @Select("select * from student_information where student_username=#{student_username}")
    Student findUserByUsername(String student_username);

    @Update("update student_information set student_pwd=#{student_pwd} where student_username=#{student_username}")
    void modifyPasswordByUsername(Student student);
}
