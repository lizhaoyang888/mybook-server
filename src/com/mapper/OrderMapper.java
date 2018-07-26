package com.mapper;

import com.bean.Order;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

public interface OrderMapper {

    @Select("select * from tb_order where id = #{id}")
    @Results({
            @Result(column = "user_id",property = "user",
            one = @One(select = "com.mapper.UserMapper.findWithId",
            fetchType = FetchType.EAGER)),

            @Result(column = "id",property = "articles",
            many = @Many(select = "com.mapper.ArticleMapper.selectArticleByOrderId",
            fetchType = FetchType.LAZY))
    })
    Order selectOrderById(Integer id);
}
