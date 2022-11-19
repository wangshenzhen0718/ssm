package com.wang.mybatis.test;

import com.wang.mybatis.mapper.CarMapper;
import com.wang.mybatis.pojo.Car;
import com.wang.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class CarMapperTest {

    @Test
    public void testselectById() {

        int pageNum = 2;
        int pageSize = 3;
        int startIndex = (pageNum-1)*pageSize;
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        for (Car car : mapper.selectCarByLimit(startIndex, pageSize)) {
            System.out.println(car);
        }


    }
}
