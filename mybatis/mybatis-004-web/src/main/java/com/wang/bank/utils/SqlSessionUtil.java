package com.wang.bank.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * @Author:wsz
 * @Date: 2022/10/30 11:40
 * @Description: SqlSession工具类
 * @Version: 1.0
 * @Since: 1.0
 */
public class SqlSessionUtil {
    private static SqlSessionFactory sqlSessionFactory;
    private static SqlSession sqlSession;
    private SqlSessionUtil(){}
    static {
        try {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static SqlSession getSqlSession(){
        if (sqlSessionFactory!=null){
            sqlSession=sqlSessionFactory.openSession();
        }
        return sqlSession;
    }

}
