package com.spx.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * create by Shipeixin on 2020/3/31 11:01
 */

@Data
@JsonIgnoreProperties(value = {"handler"})
public class Teacher implements Serializable {

    private Integer teacherId;

    private String teacherName;

    private List<Student> students;
}
