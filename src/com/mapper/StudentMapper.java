package com.mapper;

import com.bean.Student;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentMapper {
    @Select("select * from tb_student where class_id = #{id}")
    List<Student> selectStudentsById(Integer class_id);
}
