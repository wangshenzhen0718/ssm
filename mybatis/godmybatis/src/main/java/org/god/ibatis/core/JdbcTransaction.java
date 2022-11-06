package org.god.ibatis.core;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JdbcTransaction implements Transaction {


    private DataSource dataSource;
    private boolean isAutoCommit;

    private Connection connection;


    public JdbcTransaction(DataSource dataSource, boolean isAutoCommit) {
        this.dataSource = dataSource;
        this.isAutoCommit = isAutoCommit;
    }

    @Override
    public void rollback() {
        try {
            connection.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void commit() {
        try {
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    @Override
    public void openConnection() {
        if (connection==null){
            try {
                connection=dataSource.getConnection();
                connection.setAutoCommit(isAutoCommit);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public Connection getConnection() {
        return connection;
    }
}
