package com.spx.mapper;

import com.spx.entities.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * create by Shipeixin on 2020/3/31 11:49
 */
@Mapper
public interface StudentMapper {
    // 增加学生
    void addStudent(Student student);

    //维护关系
    void makeRel(@Param("stuId") Integer stuId, @Param("teaId") Integer teaId);
}
