package com.wang.mybatis.test;

import com.wang.mybatis.mapper.CarMapper;
import com.wang.mybatis.pojo.Car;
import com.wang.mybatis.utils.SqlSessionUtil;
import org.junit.Test;

import java.util.List;

public class CarMapperTest {
    private CarMapper carMapper = SqlSessionUtil.openSession().getMapper(CarMapper.class);
    @Test
    public void testSelectByType(){
        List<Car> cars = carMapper.getCarByType("'电动车' or id=1");
        cars.forEach(c-> System.out.println(c));
    }


}
