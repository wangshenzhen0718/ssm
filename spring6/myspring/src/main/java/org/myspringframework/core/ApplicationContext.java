package org.myspringframework.core;
/**
 * @Author:wsz
 * @Date: 2022/12/1 21:06
 * @Description:
 * @Version: 1.0
 * @Since: 1.0
 */
public interface ApplicationContext {
    Object getBean(String beanId);
}
