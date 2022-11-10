package com.wang.bank.utils;

import org.apache.ibatis.javassist.CannotCompileException;
import org.apache.ibatis.javassist.ClassPool;
import org.apache.ibatis.javassist.CtClass;
import org.apache.ibatis.javassist.CtMethod;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @Author:wsz
 * @Date: 2022/11/10 22:51
 * @Description:
 * @Version: 1.0
 * @Since: 1.0
 */
public class GenerateDaoProxy {

    public static Object generate(SqlSession session, Class daoInterface){
//类池
        ClassPool pool = ClassPool.getDefault();
        //制造类
        CtClass ctClass = pool.makeClass(daoInterface.getName() + "Proxy");
        //制造接口
        CtClass ctInterface = pool.makeInterface(daoInterface.getName());
        ctClass.addInterface(ctInterface);

        Method[] declaredMethods = daoInterface.getDeclaredMethods();

        Arrays.stream(declaredMethods).forEach(method -> {
            try {
                StringBuffer methodCode = new StringBuffer();
                //添加修饰符
                methodCode.append("public ");
                //添加返回值
                methodCode.append(method.getReturnType().getName()+" ");
                methodCode.append(method.getName());
                methodCode.append("(");

                Class<?>[] parameterTypes = method.getParameterTypes();
                for (int i = 0; i < parameterTypes.length; i++) {
                    methodCode.append(parameterTypes[i].getName()+" ");
                    methodCode.append("arg"+i);
                    if (i!= parameterTypes.length-1){
                        methodCode.append(",");
                    }
                }
                methodCode.append("){");
                /**
                 * 括号中间需要写对应的session.insert或session.select方法
                 */
                String sqlId = daoInterface.getName()+"."+method.getName();
                SqlCommandType sqlCommandType = session.getConfiguration().getMappedStatement(sqlId).getSqlCommandType();
                methodCode.append("org.apache.ibatis.session.SqlSession session = com.wang.bank.utils.SqlSessionUtil.openSession();");

                if(sqlCommandType == SqlCommandType.INSERT){

                }
                if(sqlCommandType == SqlCommandType.DELETE){

                }
                if(sqlCommandType == SqlCommandType.UPDATE){
                    methodCode.append("return session.update(\""+sqlId+"\", arg0);");
                }
                if(sqlCommandType == SqlCommandType.SELECT){
                    String resultType = method.getReturnType().getName();
                    methodCode.append("return ("+resultType+")session.selectOne(\""+sqlId+"\", arg0);");
                }

                methodCode.append("}");

                System.out.println(methodCode.toString());
                CtMethod ctMethod = CtMethod.make(methodCode.toString(), ctClass);
                ctClass.addMethod(ctMethod);
            } catch (CannotCompileException e) {
                e.printStackTrace();
            }
        });

        Object obj = null;
        try {
            Class<?> toClass = ctClass.toClass();
            obj = toClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return obj;
    }

}
