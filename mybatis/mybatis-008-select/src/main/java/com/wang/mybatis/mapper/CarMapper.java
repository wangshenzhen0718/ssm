package com.wang.mybatis.mapper;

import com.wang.mybatis.pojo.Car;
import org.apache.ibatis.annotations.MapKey;

import java.util.List;
import java.util.Map;

/**
 * @Author:wsz
 * @Date: 2022/11/13 14:24
 * @Description:
 * @Version: 1.0
 * @Since: 1.0
 */
public interface CarMapper {

    List<Car> selectCarById(Long id);
    List<Car> selectAll();
    Car selectByLike(String brand);
    Map<String,Object> selectCarRetMap(Long id);
    List<Map<String,Object>> selectCarRetListMap();
    @MapKey("id")
    Map<Long,Map<String,Object>> selectCarRetBigMap();

    List<Car> selectAllByMapUnderscoreToCamelCase();

    Long selectCarCount();


}
