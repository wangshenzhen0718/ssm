package com.wang.mybatis.mapper;

import com.wang.mybatis.pojo.Car;

import java.util.List;

/**
 * @Author:wsz
 * @Date: 2022/11/12 16:19
 * @Description:
 * @Version: 1.0
 * @Since: 1.0
 */
public interface CarMapper {

    List<Car> getAllByAscOrDesc(String ascOrDesc);
    List<Car> getCarByType(String type);
    int deleteBatch(String ids);


    List<Car> selectByLike(String ids);


}
