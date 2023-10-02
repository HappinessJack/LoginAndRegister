package com.formoney.dao;

import com.formoney.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class Test {
    @org.junit.Test
    public void test1() throws IOException, ClassNotFoundException {
String xmlPath = "mybatis-configuration.xml";
InputStream inputStream = Resources.getResourceAsStream(xmlPath);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = (UserMapper) sqlSession.getMapper(Class.forName("com.formoney.dao.UserMapper"));
        ArrayList<User> allUsers = mapper.getAllUsers();
        System.out.println(allUsers);
        User specificUser = mapper.getSpecificUser(new User(0, "jack", "123"));
        System.out.println("134" + specificUser);
    }
}
