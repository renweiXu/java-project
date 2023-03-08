package cn.java.controller;

import cn.java.mapper.UserMapper;
import cn.java.model.User;
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

    @GetMapping("find")
    public String find(){
        List<User> users = userMapper.find();
        return JSONObject.toJSONString(users);
    }

    @RequestMapping(value = "/insert")
    public String insert(){
        User user = new User();
        user.setBirthday(new Date());
        user.setNickname("zhangsan");
        user.setPassword("123");
        user.setSex(1);
        userMapper.insert(user);
        return "success";
    }
}
