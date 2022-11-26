package com.wang.spring6.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @Author:wsz
 * @Date: 2022/11/25 22:47
 * @Description:
 * @Version: 1.0
 * @Since: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private String[] favoriteFoods;
    private Food food;

    private List<String> names;
    private Set<String> habits;
    private Map<Integer, String> phones;

    private Properties properties;
}
