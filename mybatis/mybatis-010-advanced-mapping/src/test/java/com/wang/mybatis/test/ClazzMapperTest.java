package com.wang.mybatis.test;


import com.wang.mybatis.mapper.ClazzMapper;
import com.wang.mybatis.pojo.Clazz;
import com.wang.mybatis.utils.SqlSessionUtil;
import org.junit.Test;

public class ClazzMapperTest {
    private ClazzMapper clazzMapper = SqlSessionUtil.openSession().getMapper(ClazzMapper.class);

    @Test
    public void testSelectById(){
        Clazz clazz = clazzMapper.selectByCidCollection(1000);
        System.out.println(clazz);
    }
    @Test
    public void testSelectByCidStep(){
        Clazz clazz = clazzMapper.selectByCidStep1(1000);
        System.out.println(clazz.getCname());
    }



}
