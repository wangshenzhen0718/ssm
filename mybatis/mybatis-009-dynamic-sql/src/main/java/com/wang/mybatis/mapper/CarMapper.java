package com.wang.mybatis.mapper;

import com.wang.mybatis.pojo.Car;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author:wsz
 * @Date: 2022/11/13 14:24
 * @Description:
 * @Version: 1.0
 * @Since: 1.0
 */
public interface CarMapper {

    List<Car> selectByMultiCondition(@Param("brand") String brand,@Param("guidePrice")  Double guidePrice,@Param("carType")  String carType);
    List<Car> selectByMultiConditionWithWhere(@Param("brand") String brand,@Param("guidePrice")  Double guidePrice,@Param("carType")  String carType);


}
