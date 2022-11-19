package com.wang.mybatis.mapper;

import com.wang.mybatis.pojo.Car;
import org.apache.ibatis.annotations.*;

public interface CarMapper {
    @Insert("insert into t_car values(null,#{brand},#{carNum},#{guidePrice},#{produceTime},#{carType})")
    int insertCar(Car car);
    @Delete("delete from t_car where id=#{id}")
    int deleteCarById(@Param("id") Integer id);

    @Update("update t_car set brand=#{brand},car_num=#{carNum},guide_price=#{guidePrice},produce_time=#{produceTime},car_type=#{carType} where id=#{id}")
    int updateCar(Car car);

    @Select("select * from t_car where id=#{id}")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "brand", property = "brand"),
            @Result(column = "car_num", property = "carNum"),
            @Result(column = "guide_price", property = "guidePrice"),
            @Result(column = "produce_time", property = "produceTime"),
            @Result(column = "car_type", property = "carType")


    })
    Car selectCarById(@Param("id") Integer id);

}