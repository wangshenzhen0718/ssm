package org.god.ibatis.core;

import java.sql.Connection;

public class ManagedTransaction implements Transaction {
    @Override
    public void rollback() {

    }

    @Override
    public void commit() {

    }

    @Override
    public void close() {

    }

    @Override
    public void openSession() {

    }

    @Override
    public Connection getConnection() {
        return null;
    }
}
