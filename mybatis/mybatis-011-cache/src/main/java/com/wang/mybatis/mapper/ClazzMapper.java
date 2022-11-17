package com.wang.mybatis.mapper;

import org.apache.ibatis.annotations.Param;

/**
 * @Author:wsz
 * @Date: 2022/11/13 14:24
 * @Description:
 * @Version: 1.0
 * @Since: 1.0
 */
public interface ClazzMapper {



    int insertClazz(@Param("cid") Integer id,@Param("cname") String cname);


}
