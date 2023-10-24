import java.sql.DriverManager;

import java.sql.*;

public class TesteView {

    public static void main(String[] args) {
        try {
            Connection conexao = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:",
                    "mynewschema",
                    "mypassword");
            System.out.println("Conectado!");
            conexao.close();
            System.out.println("Conexao fechada! " + conexao.isClosed());
        } catch (SQLException exception) {
            System.err.println("Nao foi possivel conectar no Banco de Dados");
            exception.printStackTrace();
        }
    }
}
