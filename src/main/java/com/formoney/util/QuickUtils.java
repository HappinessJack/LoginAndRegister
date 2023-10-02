package com.formoney.util;

import com.formoney.Exception.NullObjectException;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class QuickUtils {
 private  SqlSessionFactory sqlSessionFactory ;
    /*便携地生成并返回一个SqlSessionFactory对象
    * Conveniently create and return a SqlSessionFactory object*/
    public SqlSessionFactory getAnSqlSessionFactory(String configurationDirectory) throws IOException {
        /*如果sqlSessionFactory不为空则直接返回*/
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        /*
        得到一个SqlSessionFactory对象
        get a SqlSessionFactory Object
         */
        InputStream configuration = Resources.getResourceAsStream(configurationDirectory);
        this.sqlSessionFactory =   sqlSessionFactoryBuilder.build(configuration);
        return this.sqlSessionFactory;
    }
    public SqlSessionFactory getSqlSessionFactory(){
        if(sqlSessionFactory!=null){
            return sqlSessionFactory;
        }else{
            throw new NullObjectException("SqlSessionFactoryNotInit");
        }
    }
}
