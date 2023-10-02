package com.formoney.dao;

import com.formoney.pojo.User;

import java.util.ArrayList;
//it as a DAO interface
//这将作为一个DAO的实现接口
public interface UserMapper {
public abstract ArrayList<User> getAllUsers();
public abstract User getSpecificUser(User user);
        /*用于往数据库中添加数据
        * Used to add data to database*/
    public abstract void addUser(User user);
}
