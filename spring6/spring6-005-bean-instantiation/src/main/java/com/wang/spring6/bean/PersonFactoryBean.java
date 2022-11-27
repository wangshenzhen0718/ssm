package com.wang.spring6.bean;

import org.springframework.beans.factory.FactoryBean;
/**
 * @Author:wsz
 * @Date: 2022/11/27 14:12
 * @Description:
 * @Version: 1.0
 * @Since: 1.0
 */
public class PersonFactoryBean implements FactoryBean<Person> {
    @Override
    public Person getObject() throws Exception {
        return new Person();
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
