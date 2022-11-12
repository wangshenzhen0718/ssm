package com.wang.mybatis.mapper;

import com.wang.mybatis.pojo.Car;

import java.util.List;
import java.util.Map;

/**
 * @Author:wsz
 * @Date: 2022/11/12 11:25
 * @Description:
 * @Version: 1.0
 * @Since: 1.0
 */
public interface CarMapper {
    int deleteById(Long id);

    int insertCar(Car car);
    int insertCarByMap(Map car);

    Car selectById(Long id);

    int updateById(Car car);

    List<Car> selectAll();

}
