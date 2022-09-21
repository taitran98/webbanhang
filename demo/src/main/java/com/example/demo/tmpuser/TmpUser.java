package com.example.demo.tmpuser;

import javax.persistence.*;

@Entity
@Table(name = "tmpuser")
public class TmpUser {
    @Id
    private String email;
    private String pass;

    public TmpUser() {
    }

    public TmpUser(String email, String pass) {
        this.email = email;
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
