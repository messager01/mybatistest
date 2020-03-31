package com.spx.mapper;

import com.spx.entities.Student;
import com.spx.entities.Teacher;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * create by Shipeixin on 2020/3/31 11:05
 */

@Mapper
public interface TeacherMapper {

    // 查询老师  并  查询出关联学生
    List<Teacher> getAllTeacherAndStudent();


    // 分步查询   查询指定的老师
    Teacher getTeacherByID(Integer id);


    // 根据老师id查出关联学生
    List<Student> getStudentByTeacherId(Integer id);

    void addTeacher(Teacher teacher);

}
