package cn.java.sharding.standard.mapper;


import cn.java.sharding.standard.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    void insert(@Param("user") User user);

    List<User> find();
}
