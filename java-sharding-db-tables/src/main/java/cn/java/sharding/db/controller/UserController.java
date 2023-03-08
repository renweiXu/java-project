package cn.java.sharding.db.controller;

import cn.java.sharding.db.mapper.UserMapper;
import cn.java.sharding.db.model.User;
import cn.java.log.aspect.Log;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RestController
public class UserController {

    @Resource
    private UserMapper userMapper;

    @Log
    @GetMapping("find")
    public String find(){
        List<User> users = userMapper.find();
        return JSONObject.toJSONString(users);
    }

    @RequestMapping(value = "/insert")
    public String insert(){
        for (int i = 10; i < 20; i++) {
            User user = new User();
            user.setAge(i);
            user.setBirthday(new Date());
            user.setNickname("zhangsan"+i);
            user.setPassword("123");
            user.setSex(1);
            userMapper.insert(user);
        }
        return "success";
    }
}
