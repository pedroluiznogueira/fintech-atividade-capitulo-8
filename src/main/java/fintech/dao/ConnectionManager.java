package fintech.dao;

import java.sql.Connection;
import java.sql.DriverManager;

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
        // @TODO: usar variaveis de ambiente para as credenciais do banco de dados
        try {
            connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:",
                    "fintech",
                    "mysecretpassword");
        } catch (Exception exception){
            exception.printStackTrace();
        }
        return connection;
    }
}
