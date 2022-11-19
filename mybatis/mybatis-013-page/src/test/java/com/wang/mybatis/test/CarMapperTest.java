package com.wang.mybatis.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wang.mybatis.mapper.CarMapper;
import com.wang.mybatis.pojo.Car;
import com.wang.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class CarMapperTest {

    @Test
    public void testSelectByLimit() {

        int pageNum = 2;
        int pageSize = 3;
        int startIndex = (pageNum-1)*pageSize;
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        for (Car car : mapper.selectCarByLimit(startIndex, pageSize)) {
            System.out.println(car);
        }
        sqlSession.close();


    }

    @Test
    public void testSelectByPageHelper() {

        int pageNum = 2;
        int pageSize = 3;
        //int startIndex = (pageNum-1)*pageSize;
        //插件处理分页计算规则
        PageHelper.startPage(pageNum, pageSize);
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        PageHelper.startPage(pageNum,pageSize);
        List<Car> cars = mapper.selectAll();
        cars.forEach(c-> System.out.println(c));
        PageInfo<Car> carPageInfo = new PageInfo<>(cars, 3);
        System.out.println(carPageInfo);
        sqlSession.close();


    }
}
