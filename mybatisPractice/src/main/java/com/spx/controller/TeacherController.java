package com.spx.controller;

import com.spx.entities.Student;
import com.spx.entities.Teacher;
import com.spx.mapper.StudentMapper;
import com.spx.mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * create by Shipeixin on 2020/3/31 11:15
 */
@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    TeacherMapper teacherMapper;

    @Autowired
    StudentMapper studentMapper;

    @RequestMapping("/getAll")
    public List<Teacher> getAll(){
        return teacherMapper.getAllTeacherAndStudent();
    }


    @RequestMapping("/getone/{id}")
    public Teacher getTeacherById(@PathVariable("id") Integer id){
        return teacherMapper.getTeacherByID(id);
    }

    @Transactional
    @RequestMapping("/add")
    public String addTeaAndStu(Student student,Teacher teacher){
        try {
            teacherMapper.addTeacher(teacher);
            studentMapper.addStudent(student);
            studentMapper.makeRel(student.getStuId(),teacher.getTeacherId());
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "failed";
        }
    }
}
