package com.mapper;

import com.bean.MyBook;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MyBookMapper {

    @Select("select * from mybook limit #{pageNum},#{pageSize}")
    List<MyBook> findWithPageSize(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize);
}
