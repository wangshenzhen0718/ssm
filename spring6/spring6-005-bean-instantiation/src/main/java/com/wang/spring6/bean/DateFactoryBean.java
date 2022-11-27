package com.wang.spring6.bean;

import org.springframework.beans.factory.FactoryBean;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author:wsz
 * @Date: 2022/11/27 15:23
 * @Description:
 * @Version: 1.0
 * @Since: 1.0
 */
public class DateFactoryBean implements FactoryBean<Date> {
    //接收字符串类型的日期数据
    private String date;

    public DateFactoryBean(String date) {
        this.date = date;
    }

    @Override
    public Date getObject() throws Exception {
        //格式化日期对象返回
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.parse(this.date);
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }
}
