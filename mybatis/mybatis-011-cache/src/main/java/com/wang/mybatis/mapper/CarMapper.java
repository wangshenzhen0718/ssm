package com.wang.mybatis.mapper;

import com.wang.mybatis.pojo.Car;
import org.apache.ibatis.annotations.Param;

/**
 * @Author:wsz
 * @Date: 2022/11/13 14:24
 * @Description:
 * @Version: 1.0
 * @Since: 1.0
 */
public interface CarMapper {


    Car selectById(@Param("id") Integer id);

    Car selectById2(@Param("id") Integer id);


}
