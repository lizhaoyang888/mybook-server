package com.mapper;

import com.bean.User;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

public interface UserDynaMapper {
    @SelectProvider(type = UserDynaSqlProvider.class,method = "SelectWithParam")
    User selectUser(User user);

    @InsertProvider(type = UserDynaSqlProvider.class,method = "InsertWithParam")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    int insertUser(User user);

    @UpdateProvider(type = UserDynaSqlProvider.class,method = "UpdateWithParam")
    void updateUser(User user);

    @UpdateProvider(type = UserDynaSqlProvider.class,method = "UpdateWithParam")
    void deleteUser(User user);
}
