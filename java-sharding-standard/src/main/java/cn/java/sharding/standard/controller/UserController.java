package cn.java.sharding.standard.controller;


import cn.java.sharding.standard.mapper.UserMapper;
import cn.java.sharding.standard.model.User;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Calendar;

@RestController
public class UserController {

    @Resource
    private UserMapper userMapper;

    @RequestMapping(value = "/find")
    public String find(){
        return JSONObject.toJSONString(userMapper.find());
    }



    @RequestMapping(value = "/insert")
    public String insert(){
        Calendar instance = Calendar.getInstance();
        //instance.set(202);
        for (int i = 1; i < 10; i++) {
            String year = "202"+i;
            instance.set(Integer.valueOf(year),i,i,i,i,i);
            User user = new User();
            user.setAge(i);
            user.setBirthday(instance.getTime());
            user.setNickname("zhangsan"+i);
            user.setPassword("123");
            user.setSex(1);
            userMapper.insert(user);
        }
        return "success";
    }

//    public static void main(String[] args) {
//        // 初始化
//        OkHttpClient client = new OkHttpClient();
//
//        String url = "http://119.3.211.220:7778/reqxml?T64=1&StartPos=0&ReqVer=0&AccountIndex=2&action=20109&stockCode=991002&";
//        Request request = new Request.Builder()
//                .url(url)
//                .get()
//                .build();
//
//        Response result = null;
//        try {
//            // 同步
//            result = client.newCall(request).execute();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        if (result.isSuccessful()) {
//            try {
//                String string = result.body().string();
//                System.out.println(string);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//    }


}
