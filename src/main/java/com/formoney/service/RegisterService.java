package com.formoney.service;

import com.formoney.dao.UserMapper;
import com.formoney.pojo.User;
import com.formoney.util.QuickUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;

public class RegisterService {
    public boolean register(User user) throws IOException {
        boolean result = false;
//        QuickUtils quickUtils = new QuickUtils();
//        SqlSessionFactory sqlSessionFactory = quickUtils.getAnSqlSessionFactory("mybatis-configuration.xml");
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        mapper.getSpecificUser();
        LoginService loginService = new LoginService();
        User userQueried = loginService.getUserQueried(user);
        /*如果返回值时null则代表可以注册
         * if return value is null,then it can be registered*/
        if (userQueried == null) {
            QuickUtils quickUtils = new QuickUtils();
            SqlSessionFactory sqlSessionFactory = quickUtils.getAnSqlSessionFactory("mybatis-configuration.xml");
            SqlSession sqlSession = sqlSessionFactory.openSession();
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            try {
                mapper.addUser(user);
                result=true;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                //承认所有更改
                sqlSession.commit();
                sqlSession.close();
            }
            return result;
        } else {
            return result;
        }
    }
}
