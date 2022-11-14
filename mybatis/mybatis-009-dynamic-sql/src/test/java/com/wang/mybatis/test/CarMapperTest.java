package com.wang.mybatis.test;

import com.wang.mybatis.mapper.CarMapper;
import com.wang.mybatis.pojo.Car;
import com.wang.mybatis.utils.SqlSessionUtil;
import org.junit.Test;

import java.util.ArrayList;
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

    @Test
    public void testDeleteByIds2() {
        Long[] ids = {};
        int count = carMapper.deleteByIds2(ids);
        System.out.println(count);
        SqlSessionUtil.openSession().commit();
        SqlSessionUtil.openSession().close();

    }

    @Test
    public void testInsertBatch() {
        Car car1 = new Car(null, "宝马520Li", "1000", 100.0, "2022-02-02", "电动车");
        Car car2 = new Car(null, "奔驰E00L", "1000", 100.0, "2022-02-02", "电动车");
        Car car3 = new Car(null, "比亚迪汉", "1000", 100.0, "2022-02-02", "电动车");
        Car car4 = new Car(null, "比亚迪1", "1000", 100.0, "2022-02-02", "电动车");
        Car car5 = new Car(null, "比亚迪2", "1000", 100.0, "2022-02-02", "电动车");
        ArrayList<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        cars.add(car5);
        int count = carMapper.insertBatch(cars);
        System.out.println(count);

        SqlSessionUtil.openSession().commit();
        SqlSessionUtil.openSession().close();

    }


}
