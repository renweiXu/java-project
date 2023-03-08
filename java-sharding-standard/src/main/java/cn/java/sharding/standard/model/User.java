package cn.java.sharding.standard.model;

import lombok.Data;

import java.util.Date;

@Data
public class User {

    private Integer id;

    private Integer age;

    private String nickname;

    private String password;

    private Integer sex;

    private Date birthday;
}
