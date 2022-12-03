package com.wang.client;

import com.wang.annotation.Component;

import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author:wsz
 * @Date: 2022/12/3 11:28
 * @Description:
 * @Version: 1.0
 * @Since: 1.0
 */
public class ComponentScan {
    public static void main(String[] args) throws Exception {
        HashMap<String, Object> map = new HashMap<>();
        String packageName="com.wang.bean";
        String packagePath = packageName.replaceAll("\\.", "/");
        URL url = ClassLoader.getSystemClassLoader().getResource(packagePath);
        String realPath = url.getPath();
        File file = new File(realPath);
        File[] files = file.listFiles();
        Arrays.stream(files).forEach(f->{
            try {
                String className=packageName+"."+f.getName().split("\\.")[0];
                Class<?> aClass = Class.forName(className);
                if (aClass.isAnnotationPresent(Component.class)){
                    Component annotation = aClass.getAnnotation(Component.class);
                    String id = annotation.value();
                    Object object = aClass.newInstance();
                    map.put(id,object);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        });

    }
}
