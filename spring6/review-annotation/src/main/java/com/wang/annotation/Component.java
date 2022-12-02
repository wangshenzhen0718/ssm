package com.wang.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author:wsz
 * @Date: 2022/12/2 22:50
 * @Description:
 * @Version: 1.0
 * @Since: 1.0
 */
//Target注解用来设置Component注解可以出现的位置，以下代表表示Component注解只能用在类和接口上。
// 使用某个注解的时候，如果注解的属性名是value 的话，value可以省略。
//@Target(value = {ElementType.TYPE})
//使用某个注解的时候，如果注解的属性值是数组，并且数组中只有一个元素，大括号可以省略。
//@Target({ElementType.TYPE})
@Target(ElementType.TYPE)
//Retention注解用来设置Component注解的保持性策略，以下代表Component注解可以被反射机制读取。
@Retention(value = RetentionPolicy.RUNTIME)
public @interface Component {
    //String value(); 是Component注解中的一个属性。该属性类型String，属性名是value。
    String value();
}
