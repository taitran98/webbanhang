package com.example.webbanhang;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


public class Login {
    @NotBlank(message = "Nhập email!")
    @Email
    private String email; 

    @NotBlank(message = "Nhập mật khẩu!")
    private String password;

    
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    
}
