package com.wang.javassist;

import com.wang.javassist.dao.AccountDao;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import org.junit.Test;

import java.lang.reflect.Method;

public class JavassistTest {
    @Test
    public void generateInterface() throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass ctClass = pool.makeClass("com.wang.bank.dao.impl.AccountDaoImpl");
        CtClass ctInterface = pool.makeInterface("com.wang.javassist.dao.AccountDao");
        ctClass.addInterface(ctInterface);
        //制造方法
        String methodCode = "public void delete(){System.out.println(\"hello delete\");}";
        CtMethod ctMethod = CtMethod.make(methodCode, ctClass);
        //讲方法添加到类中
        ctClass.addMethod(ctMethod);
        //在内存中生成class
        Class aClass = ctClass.toClass();
        AccountDao accountDao = (AccountDao) aClass.newInstance();
        accountDao.delete();


    }

    @Test
    public void testGenerateFirstClass() throws Exception {
        //获取类池 生成class  高版本配置--add-opens java.base/java.lang=ALL-UNNAMED --add-opens java.base/sun.net.util=ALL-UNNAMED
        ClassPool pool = ClassPool.getDefault();
        //告诉javassist类名是什么
        CtClass ctClass = pool.makeClass("com.wang.bank.dao.impl.AccountDaoImpl");
        //制造方法
        String methodCode = "public void insert(){System.out.println(\"插入\");}";
        CtMethod ctMethod = CtMethod.make(methodCode, ctClass);
        //讲方法添加到类中
        ctClass.addMethod(ctMethod);
        //在内存中生成class
        ctClass.toClass();
        Class<?> aClass = Class.forName("com.wang.bank.dao.impl.AccountDaoImpl");
        Object o = aClass.newInstance();
        Method insert = aClass.getDeclaredMethod("insert");
        insert.invoke(o);


    }
}
