package com.wang.mybatis.test;

import com.wang.mybatis.mapper.CarMapper;
import com.wang.mybatis.mapper.ClazzMapper;
import com.wang.mybatis.pojo.Car;
import com.wang.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class CarMapperTest {

    //思考:什么时候不走缓存?
    // sqlsession对象不是同一个，肯定不走缓存。//查询条件不一样，肯定也不走缓存。
    //思考:什么时候一级缓存失效?
    //第一次DQL和第二次DQL之间你做了以下两件事中的任意一件，都会让一级缓存清空:
    // 1.执行了sqlSession的clearCache()方法，这是手动清空缓存。
    // 2．执行了INSERT或DELETE或UPDATE语句。


    @Test
    public void testselectById() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper carMapper = sqlSession.getMapper(CarMapper.class);
        ClazzMapper clazzMapper = sqlSession.getMapper(ClazzMapper.class);

        Car cars1 = carMapper.selectById(35);
        System.out.println(cars1);
        //1.手动清空一级缓存
        //sqlSession.clearCache();


        //2.即使不在一张表增删改也会使缓存失效
        clazzMapper.insertClazz(2000,"高三4班");
        //一级缓存是基于sqlSession的，同一个sqlSession查询同一条语句走缓存
        Car cars2 = carMapper.selectById(35);
        System.out.println(cars2);
        sqlSession.close();


    }

}
