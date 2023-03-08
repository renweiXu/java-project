package cn.java.sharding.db.mapper;

import cn.java.log.aspect.Log;
import cn.java.sharding.db.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    void insert(@Param("user") User user);

    @Log
    List<User> find();
}
