package com.formoney.pojo;

public class User {
    private int id ;
    private String username;
    private String password;
public User(){}
    @Override
    public String toString() {
        return "id-----" + id + "username-----" + username + "password-----"+password;
    }
    public User(int id,String username,String password){
    this.password=password;
    this.username=username;
    this.id=id;
    }
    public void setUsername(String username){
    this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
