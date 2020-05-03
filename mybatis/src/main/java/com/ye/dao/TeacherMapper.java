package com.ye.dao;

import com.ye.bean.Teacher;

public interface TeacherMapper {
    //获取指定老师，及老师下的所有学生
    public Teacher getTeacher(int id);
}
