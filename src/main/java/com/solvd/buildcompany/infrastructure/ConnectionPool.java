package com.solvd.buildcompany.infrastructure;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ConnectionPool {

    private static ConnectionPool instance;
    private List<Connection> connectionPool;
    private List<Connection> usedConnections = new ArrayList<>();
    private static int INITIAL_POOL_SIZE = 10;

    private ConnectionPool(List<Connection> pool) {
        connectionPool = pool;
    }

    public Connection getConnection() {
        Connection connection = connectionPool.remove(connectionPool.size() - 1);
        usedConnections.add(connection);
        return connection;
    }

    public void releaseConnection(Connection connection) {
        connectionPool.add(connection);
        usedConnections.remove(connection);
    }

    public int getConnectionPoolSize() {
        return connectionPool.size();
    }

    public int getUsedConnectionsSize() {
        return usedConnections.size();
    }

    public static ConnectionPool getInstance() {
        if (instance == null) {
            try(InputStream input = ConnectionPool.class.getClassLoader().getResourceAsStream("db.properties")) {
                Properties prop = new Properties();
                prop.load(input);

                List<Connection> pool = new ArrayList<>(INITIAL_POOL_SIZE);
                for (int i = 0; i < INITIAL_POOL_SIZE; i++) {
                    pool.add(DriverManager.getConnection(
                            prop.getProperty("db.url"),
                            prop.getProperty("db.user"),
                            prop.getProperty("db.password"))
                    );
                    instance = new ConnectionPool(pool);
                }
            } catch (SQLException | IOException e) {
                System.out.println("Connection Pool error.");
                System.out.println(e.toString());
            }
        }
        return instance;
    }
}
