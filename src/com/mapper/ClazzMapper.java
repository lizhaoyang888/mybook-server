package com.mapper;

import com.bean.Clazz;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

public interface ClazzMapper {

    @Select("select * from tb_class where id = #{id}")
    @Results({
            @Result(column = "id",property = "students",
                    many = @Many(select = "com.mapper.StudentMapper.selectStudentsById",
                    fetchType = FetchType.LAZY)
            )
    })
    Clazz selectClazzById(Integer id);
}
