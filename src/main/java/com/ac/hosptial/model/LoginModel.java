package com.ac.hosptial.model;

import lombok.Data;

/**
 * Created by zhenchao.bi on 6/26/2017.
 */
@Data
public class LoginModel {
    private String userName;
    private String password;
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
