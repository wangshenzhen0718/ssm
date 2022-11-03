package org.god.ibatis.core;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;
/**
 * @Author:wsz
 * @Date: 2022/11/3 22:19
 * @Description:
 * @Version: 1.0
 * @Since: 1.0
 */
public class UnpooledDataSource implements DataSource {

    private String url;
    private String username;
    private String password;



    public UnpooledDataSource(String driver, String url,String username,String password) {
        try {
            Class.forName(driver);
            this.url = url;
            this.username = username;
            this.password = password;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
    @Override
    public Connection getConnection() throws SQLException {

        return DriverManager.getConnection(url,username,password);
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }
}
