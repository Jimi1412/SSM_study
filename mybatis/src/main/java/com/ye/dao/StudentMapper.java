package com.ye.dao;

import com.ye.bean.Student;

import java.util.List;

public interface StudentMapper {
    //获取所有学生及对应老师的信息
    public List<Student> getStudents();
    public List<Student> getStudents2();
}
