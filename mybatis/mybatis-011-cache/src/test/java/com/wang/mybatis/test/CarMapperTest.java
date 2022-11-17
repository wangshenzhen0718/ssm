package com.wang.mybatis.test;

import com.wang.mybatis.mapper.CarMapper;
import com.wang.mybatis.mapper.ClazzMapper;
import com.wang.mybatis.pojo.Car;
import com.wang.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class CarMapperTest {

    //思考:什么时候不走缓存?
    // sqlsession对象不是同一个，肯定不走缓存。//查询条件不一样，肯定也不走缓存。
    //思考:什么时候一级缓存失效?
    //第一次DQL和第二次DQL之间你做了以下两件事中的任意一件，都会让一级缓存清空:
    // 1.执行了sqlSession的clearCache()方法，这是手动清空缓存。
    // 2．执行了INSERT或DELETE或UPDATE语句。


    @Test
    public void testselectById() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper carMapper = sqlSession.getMapper(CarMapper.class);
        ClazzMapper clazzMapper = sqlSession.getMapper(ClazzMapper.class);

        Car cars1 = carMapper.selectById(35);
        System.out.println(cars1);
        //1.手动清空一级缓存
        //sqlSession.clearCache();


        //2.即使不在一张表增删改也会使缓存失效
        clazzMapper.insertClazz(2000, "高三4班");
        //一级缓存是基于sqlSession的，同一个sqlSession查询同一条语句走缓存
        Car cars2 = carMapper.selectById(35);
        System.out.println(cars2);
        sqlSession.close();


    }

    /*二级缓存的范围是SqlSessionFactory。
    使用二级缓存需要具备以下几个条件:
        1.<setting name="cacheEnabled" value="true">全局性地开启或关闭所有映射器配置文件中已配置的任何缓存。
        默认就是true，无需设置
        2．在需要使用二级缓存的SqlMapper.xml文件中添加配置: <cache />
        3．使用二级缓存的实体类对象必须是可序列化的，也就是必须实现java.io.Serializable接口
        4. SqlSession对象关闭或提交之后，一级缓存中的数据才会被写入到二级缓存当中。此时二级缓存才可用。*/

    @Test
    public void testselectById2() throws Exception {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        CarMapper carMapper1 = sqlSession1.getMapper(CarMapper.class);
        //这行代码执行结束之后，实际上数据是缓存到一级缓存当中了。(sqlSession1是一级缓存。)
        Car car1 = carMapper1.selectById2(35);
        System.out.println(car1);
        //如果这里不关闭SqlSession1对象的话，二级缓存中还是没有数据的。
        //如果执行了这行代码，sqlSession1的一级缓存中的数据会放到二级缓存当中。
        sqlSession1.close();
        CarMapper carMapper2 = sqlSession2.getMapper(CarMapper.class);
        //这行代码执行结束之后，实际上数据是缓存到一级缓存当中了。(sqlSession2是一级缓存。)
        Car car2 = carMapper2.selectById2(35);
        System.out.println(car2);


    }

}
