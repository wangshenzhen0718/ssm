package com.wang.mybatis.test;

import com.wang.mybatis.mapper.CarMapper;
import com.wang.mybatis.pojo.Car;
import com.wang.mybatis.utils.SqlSessionUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class carMapperTest {
    private CarMapper carMapper = SqlSessionUtil.openSession().getMapper(CarMapper.class);

    @Test
    public void testselectById(){
        Car car = carMapper.selectById(1L);
        System.out.println(car);

    }

    @Test
    public void testselectAll(){
        List<Car> cars = carMapper.selectAll();
        cars.forEach(c-> System.out.println(c));

    }

    @Test
    public void testInsertCarByPojo(){
        Car car = new Car();
        car.setBrand("红旗");
        car.setCarNum("100");
        car.setGuidePrice(100.0);
        car.setCarType("混合动力");
        car.setProduceTime("2022-10-31");
        carMapper.insertCar(car);
        SqlSessionUtil.openSession().commit();

    }

    @Test
    public void testInsertCarByMap(){
        Map map=new HashMap<>();
        map.put("car_num", "6666");
        map.put("brand", "比亚迪汉");
        map.put("guide_price", 10.0);
        map.put("produce_time", "2022-10-30");
        map.put("car_type", "电动车");
        carMapper.insertCarByMap(map);
        SqlSessionUtil.openSession().commit();

    }

    @Test
    public void testDeleteById(){
        carMapper.deleteById(31L);
        SqlSessionUtil.openSession().commit();
    }

    @Test
    public void testUpdateById(){
        Car car = new Car();
        car.setId(30L);
        car.setBrand("红旗111");
        car.setCarNum("100");
        car.setGuidePrice(100.0);
        car.setCarType("混合动力");
        car.setProduceTime("2022-10-31");
        carMapper.updateById(car);
        SqlSessionUtil.openSession().commit();
    }
}
