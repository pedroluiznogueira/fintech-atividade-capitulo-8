package fintech.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionManager {
    private static ConnectionManager connectionManager;

    private ConnectionManager() {}

    public static ConnectionManager getInstance() {
        if (connectionManager == null) {
            connectionManager = new ConnectionManager();
        }
        return connectionManager;
    }

    public Connection getConnection() {
        Connection connection = null;

        try {
            Properties properties = new Properties();
            InputStream input = getClass()
                    .getClassLoader()
                    .getResourceAsStream("application.properties");
            properties.load(input);

            String jdbcUrl = properties.getProperty("DB_URL");
            String username = properties.getProperty("DB_USERNAME");
            String password = properties.getProperty("DB_PASSWORD");

            connection = DriverManager.getConnection(jdbcUrl, username, password);
        } catch (Exception exception){
            exception.printStackTrace();
        }
        return connection;
    }
}
