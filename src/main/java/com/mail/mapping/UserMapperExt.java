package com.mail.mapping;

import com.mail.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapperExt extends UserMapper{
    @Select("select  username, password  from user where 1=1")
    List<User> selectByEId(User user);
}
