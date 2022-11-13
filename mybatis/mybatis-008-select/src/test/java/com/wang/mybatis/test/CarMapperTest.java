package com.wang.mybatis.test;

import com.wang.mybatis.mapper.CarMapper;
import com.wang.mybatis.pojo.Car;
import com.wang.mybatis.utils.SqlSessionUtil;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class CarMapperTest {
    private CarMapper carMapper = SqlSessionUtil.openSession().getMapper(CarMapper.class);

    @Test
    public void testSelectById() {
        List<Car> cars = carMapper.selectCarById(1L);
        cars.forEach(c -> System.out.println(c));
    }


    @Test
    public void testSelectRetMap() {
        Map<String, Object> car = carMapper.selectCarRetMap(1L);
        System.out.println(car);
    }

    @Test
    public void testSelectRetListMap() {
        for (Map<String, Object> map : carMapper.selectCarRetListMap()) {
            System.out.println(map);
        }

    }

    @Test
    public void testSelectRetBigMap() {
        Map<Long, Map<String, Object>> map = carMapper.selectCarRetBigMap();
        System.out.println(map);


    }

    @Test
    public void testSelectAll() {
        List<Car> cars = carMapper.selectAll();
        cars.forEach(c -> System.out.println(c));
    }

    @Test
    public void testSelectByLike() {
        //TooManyResultsException 会根据我们的期望返回结果个数调用不同的查询方法
        Car car = carMapper.selectByLike("99");
        System.out.println(car);
    }

    /*驼峰映射后可以直接返回对象*/
    @Test
    public void testSelectAllByMapUnderscoreToCamelCase() {
        List<Car> cars = carMapper.selectAllByMapUnderscoreToCamelCase();
        cars.forEach(c -> System.out.println(c));
    }

    @Test
    public void testSelectCarCount() {
        Long count = carMapper.selectCarCount();
        System.out.println(count);
    }

}
