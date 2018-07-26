package com.mapper;

import com.bean.Person;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

public interface OnePersonMapper {
    @Select("select * from tb_person where name = #{name}")
    @Results({
            //@Result(id = true,column = "id",property = "id"),
            //@Result(column = "name",property = "name"),
           // @Result(column = "sex",property = "sex"),
            @Result(column = "card_id",property = "card",
            one = @One(select = "com.mapper.CardMapper.selectCardById",
            fetchType = FetchType.EAGER))
    })
    Person selectPersonById(String name);
}
