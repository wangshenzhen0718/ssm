package org.god.ibatis.core;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * @Author:wsz
 * @Date: 2022/11/2 22:49
 * @Description: 一个数据库一般对应一个SqlSessionFactory对象
 *              一个SqlSessionFactory就可以开启多个SqlSession会话
 * @Version: 1.0
 * @Since: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SqlSessionFactory {

    private Transaction transaction;





    private Map<String,MappedStatement> mappedStatements;
}
