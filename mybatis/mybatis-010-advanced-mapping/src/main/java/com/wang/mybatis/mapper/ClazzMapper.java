package com.wang.mybatis.mapper;

import com.wang.mybatis.pojo.Clazz;

/**
 * @Author:wsz
 * @Date: 2022/11/13 14:24
 * @Description:
 * @Version: 1.0
 * @Since: 1.0
 */
public interface ClazzMapper {

    Clazz selectBySidStep2(Integer cid);

    Clazz selectByCidCollection(Integer cid);

    Clazz selectByCidStep1(Integer cid);

}
