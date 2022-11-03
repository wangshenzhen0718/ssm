package org.god.ibatis.core;

import java.io.InputStream;
import java.util.Map;

/**
 * @Author:wsz
 * @Date: 2022/11/2 22:49
 * @Description:sqlSessionFactory构建器对象。 通过SqlSessionFactoryBuilder build方法来解析
 * godbatis-config.xml文件，然后创SqlSessionFactory对象。
 * @Version: 1.0
 * @Since: 1.0
 */
public class SqlSessionFactoryBuilder {
    public SqlSessionFactoryBuilder() {
    }

    /**
     * 解析godbatis-config.xml文件，来构建SqlSessionFactory对象。
     *
     * @param in 指向godbatis-config.xml文件的一个输入流。
     * @return sqlSessionFactory 对象。
     */
    public SqlSessionFactory bind(InputStream in) {

        Transaction transaction=null;
        Map<String,MappedStatement> mappedStatements=null;

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactory(transaction,mappedStatements);
        return sqlSessionFactory;
    }
}
