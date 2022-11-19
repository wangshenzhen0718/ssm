package com.wang.mybatis.mapper;

import com.wang.mybatis.pojo.Car;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CarMapper {
    List<Car> selectCarByLimit(@Param("startIndex") int startIndex,@Param("pageSize")  int pageSize);

    List<Car> selectAll();
}