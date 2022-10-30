package com.wang.mybatis.test;

import com.wang.mybatis.pojo.Car;
import com.wang.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class CarMapperTest {

    @Test
    public void testInsertByMap() {

        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        HashMap<String, Object> map = new HashMap<>();
        map.put("car_num", "1111");
        map.put("brand", "比亚迪汉");
        map.put("guide_price", 10.0);
        map.put("produce_time", "2022-10-30");
        map.put("car_type", "电动车");
        sqlSession.insert("insertCar", map);
        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void testInsertByPojo() {

        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        Car car = new Car();
        car.setCarNum("2222");
        car.setBrand("比亚迪 plus");
        car.setGuidePrice(20.0);
        car.setProduceTime("2022-10-30");
        car.setCarType("电动车");
        sqlSession.insert("insertCar", car);
        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void testDelete() {

        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        sqlSession.delete("deleteById", 26);
        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void testUpdate() {

        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        Car car = new Car();
        car.setId(28L);
        car.setCarNum("1000");
        car.setBrand("比亚迪 plus");
        car.setGuidePrice(20.0);
        car.setProduceTime("2022-10-31");
        car.setCarType("电动车");
        sqlSession.update("updateById", car);
        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void testSelectById() {

        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        Car car = sqlSession.selectOne("selectById", 28);
        System.out.println(car);
        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void testSelectAll() {

        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        List<Car> cars = sqlSession.selectList("selectAll");
        cars.forEach(car -> System.out.println(car));
        sqlSession.commit();
        sqlSession.close();

    }
}
