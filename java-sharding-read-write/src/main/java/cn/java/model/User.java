package cn.java.model;


import lombok.Data;

import java.util.Date;

@Data
public class User {

    private Integer id;

    private String nickname;

    private String password;

    private Integer sex;

    private Date birthday;
}
