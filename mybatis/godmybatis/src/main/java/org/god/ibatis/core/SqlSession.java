package org.god.ibatis.core;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @Author:wsz
 * @Date: 2022/11/5 20:05
 * @Description:
 * @Version: 1.0
 * @Since: 1.0
 */
@Data
@NoArgsConstructor
public class SqlSession {
    SqlSessionFactory factory;

    public int insert(String sqlId, Object pojo){
        int count = 0;
        try {
            //TODO 调用时机待调整
            factory.getTransaction().openConnection();
            Connection connection = factory.getTransaction().getConnection();
            String godBatisSql = factory.getMappedStatements().get(sqlId).getSql();
            System.out.println(godBatisSql);
            String sql = godBatisSql.replaceAll("#\\{[a-zA-Z0-9_$]*}", "?");
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            int fromIndex=0;
            int index=1;
            while (true){
                int jingIndex = godBatisSql.indexOf("#",fromIndex);
                if (jingIndex<0) {
                    break;
                }
                int youIndex = godBatisSql.indexOf("}",fromIndex);
                String propertyName = godBatisSql.substring(jingIndex + 2, youIndex).trim();
                fromIndex=youIndex+1;
                String getMethodName  = "get" + propertyName.toUpperCase().charAt(0) + propertyName.substring(1);
                Method getMethod = pojo.getClass().getDeclaredMethod(getMethodName);
                Object propertyValue = getMethod.invoke(pojo);
                preparedStatement.setString(index,propertyValue.toString());
                index++;
            }
            count = preparedStatement.executeUpdate();
            //给?占位符传值
            // 难度是什么:
            //第一:你不知道有多少个?
            //第二:你不知道该将pojo对象中的哪个属性赋值给哪个?

        } catch (Exception e) {
            e.printStackTrace();
        }

        return count;
    }

    public static void main(String[] args) {
        String sql="insert into t_car values (#{carNum}, #{brand}, #{guidePrice}, #{produceTime}, #{carType})";
        int fromIndex=0;
        int index=1;
        while (true){
            int jingIndex = sql.indexOf("#",fromIndex);
            if (jingIndex<0) {
                break;
            }
            System.out.println(index);
            index++;
            int youIndex = sql.indexOf("}",fromIndex);
            String trim = sql.substring(jingIndex + 2, youIndex).trim();
            System.out.println(trim);
            fromIndex=youIndex+1;
        }

    }
    public SqlSession(SqlSessionFactory factory){
        this.factory = factory;
    }

    public void rollback(){
        Transaction transaction = factory.getTransaction();
        transaction.rollback();
    }
    public void commit(){
        Transaction transaction = factory.getTransaction();
        transaction.commit();
    }
    public void close(){
        Transaction transaction = factory.getTransaction();
        transaction.close();
    }
}
