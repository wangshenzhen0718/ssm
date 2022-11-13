package com.wang.mybatis.test;

import com.wang.mybatis.mapper.CarMapper;
import com.wang.mybatis.pojo.Car;
import com.wang.mybatis.utils.SqlSessionUtil;
import org.junit.Test;

import java.util.List;

public class CarMapperTest {
    private CarMapper carMapper = SqlSessionUtil.openSession().getMapper(CarMapper.class);

    @Test
    public void testSelectByMultiCondition() {
        List<Car> cars = carMapper.selectByMultiCondition("", null, null);
        for (Car car : cars) {
            System.out.println(car);
        }

    }

    @Test
    public void testSelectByMultiConditionWithWhere() {
        List<Car> cars = carMapper.selectByMultiConditionWithWhere("宝马", 6.0, null);
        for (Car car : cars) {
            System.out.println(car);
        }

    }

    @Test
    public void testSelectByMultiConditionWithTrim() {
        List<Car> cars = carMapper.selectByMultiConditionWithTrim(null, 6.0, null);
        for (Car car : cars) {
            System.out.println(car);
        }

    }

    @Test
    public void testUpdateByMultiConditionWithSet() {
        Car car = new Car(29L, null, "霸道丰田", null, null, null);
        carMapper.updateByMultiConditionWithSet(car);
        SqlSessionUtil.openSession().commit();
        SqlSessionUtil.openSession().close();


    }

    @Test
    public void testSelectByMultiConditionWithChoose() {
        List<Car> cars = carMapper.selectByMultiConditionWithChoose(null, null, null);
        for (Car car : cars) {
            System.out.println(car);
        }

    }

    @Test
    public void testSelectByIds() {
        Long[] ids = {1L, 2L, 3L};
        List<Car> cars = carMapper.selectByIds(ids);
        for (Car car : cars) {
            System.out.println(car);
        }

    }

    @Test
    public void testDeleteByIds() {
        Long[] ids = {28L, 29L};
        int count = carMapper.deleteByIds(ids);
        System.out.println(count);
        SqlSessionUtil.openSession().commit();
        SqlSessionUtil.openSession().close();

    }


}
