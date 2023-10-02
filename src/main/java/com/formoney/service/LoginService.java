package com.formoney.service;

import com.formoney.dao.DAO;
import com.formoney.dao.UserMapper;
import com.formoney.pojo.User;
import com.formoney.util.QuickUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class LoginService {
    //处理登录业务
    //handle login transaction
    public boolean login(User user) throws IOException {
        boolean result = false;
        User userQueried = getUserQueried(user);
        if (userQueried==null){
            return result;
        } else{
            //judge the password is right or nor.
            result = user.getPassword().equals(userQueried.getPassword());

            return result;
        }
    }

    public User getUserQueried(User user) throws IOException {
        User userQueried = null;
//        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
//        /*
//        得到一个SqlSessionFactory对象
//        get a SqlSessionFactory Object
//         */
//        InputStream configuration = Resources.getResourceAsStream("mybatis-configuration.xml");
//        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(configuration);
        QuickUtils utils = new QuickUtils();
        SqlSessionFactory sqlSessionFactory = utils.getAnSqlSessionFactory("mybatis-configuration.xml");
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        userQueried = mapper.getSpecificUser(user);
//         /*关闭对话让该连接线程返回pooled
//         close session for let the connective thread back to pooled*/
        sqlSession.close();
        return userQueried;
    }
}
