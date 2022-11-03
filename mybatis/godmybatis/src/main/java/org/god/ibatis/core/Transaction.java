package org.god.ibatis.core;

import java.sql.Connection;

/**
 * @Author:wsz
 * @Date: 2022/11/3 21:57
 * @Description:
 * @Version: 1.0
 * @Since: 1.0
 */
public interface Transaction {
    void rollback();
    void commit();
    void close();

    void openSession();

    Connection getConnection();
}
