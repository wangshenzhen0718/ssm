package com.wang.javassist;

import com.wang.javassist.dao.AccountDao;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.Arrays;

public class JavassistTest {
    @Test
    public void testGenerateAccountDaoImpl() throws Exception {
        //获取类池
        ClassPool pool = ClassPool.getDefault();
        // 制造类
        CtClass ctClass = pool.makeClass("com.wang.bank.dao.impl.AccountDaoImpl");
        // 制造接口
        CtClass ctInterface = pool.makeInterface("com.wang.javassist.dao.AccountDao");
        //实现接口
        ctClass.addInterface(ctInterface);
        //实现接口中所有的方法
        Method[] declaredMethods = AccountDao.class.getDeclaredMethods();
        System.out.println(declaredMethods.length);
        //制造方法
        Arrays.stream(declaredMethods).forEach(method->{
            try {
                //int update(String actno,Double balance);
                StringBuilder methodCode = new StringBuilder();
                methodCode.append("public");
                methodCode.append(" ");
                methodCode.append(method.getReturnType().getName());
                methodCode.append(" ");
                methodCode.append(method.getName());
                methodCode.append("(");
                Class<?>[] parameterTypes = method.getParameterTypes();
                for (int i = 0; i < parameterTypes.length; i++) {
                    Class<?> parameterType = parameterTypes[i];
                    methodCode.append(parameterType.getName());
                    methodCode.append(" ");
                    methodCode.append("arg"+i);
                    if (i!=parameterTypes.length-1){
                        methodCode.append(",");
                    }
                }
                methodCode.append("){System.out.println(\"111\");");
                if ("void".equals(method.getReturnType().getName())){
                }else if ("int".equals(method.getReturnType().getName())){
                    methodCode.append("return 1;");
                }else if("java.lang.String".equals(method.getReturnType().getName())){
                    methodCode.append("return \"666\";");
                }
                methodCode.append("}");
                System.out.println(methodCode);
                CtMethod ctMethod = CtMethod.make(String.valueOf(methodCode), ctClass);
                //讲方法添加到类中
                ctClass.addMethod(ctMethod);
            }catch (Exception e){
                e.printStackTrace();
            }
        });
        //在内存中生成class，并且加载到JVM当中
        Class toClass = ctClass.toClass();
        // 创建对象
        AccountDao accountDao = (AccountDao) toClass.newInstance();
        //调用方法
        accountDao.delete();
        accountDao.insert("666");
        accountDao.selectByActno("555");
        accountDao.update("555",20.0);
    }
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
