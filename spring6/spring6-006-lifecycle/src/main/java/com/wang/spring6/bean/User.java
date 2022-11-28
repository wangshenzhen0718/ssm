package com.wang.spring6.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

/**
 * @Author:wsz
 * @Date: 2022/11/27 22:51
 * @Description:
 * @Version: 1.0
 * @Since: 1.0
 */
public class User implements BeanNameAware, BeanClassLoaderAware, BeanFactoryAware, InitializingBean, DisposableBean {

    private String name;

    public User() {
        System.out.println("第一步 构造函数");
    }

    public void setName(String name) {
        System.out.println("第二步 set赋值");
        this.name = name;
    }

    public void initBean() {
        System.out.println("第四步 初始化bean");
    }

    public void destoryBean() {
        System.out.println("第七步 销毁bean");
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("Bean这个类的加载器" + classLoader);

    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("生产Bean这个类的工厂是" + beanFactory);
    }

    @Override
    public void setBeanName(String name) {
        System.out.println(name);

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean的afterPropertiesSet执行！");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean的destroy执行！！");
    }
}
