import fintech.dao.TransacaoDAO;
import fintech.models.Transacao;

import java.sql.*;
import java.util.UUID;

public class TesteView {

    public static void main(String... args) {
        Connection conexao = null;
        PreparedStatement stmt = null;
        ResultSet resultSet = null;

        try {
            // Opening database connection
            conexao = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:",
                    "mynewschema",
                    "mypassword");
            System.out.println("Connected!");

            java.util.Date dataPrimeiraTransacao = new java.util.Date();
            String descricaoPrimeiraTransacao = "Primeira transacao do sistema";
            Float valorPrimeiraTransacao = 1.22F;
            String tipoPrimeiraTransacao = "Cartao";
            String categoriaPrimeiraTransacao = "Nacional";
            Transacao primeiraTransacao = new Transacao(
                    UUID.randomUUID(),
                    dataPrimeiraTransacao,
                    descricaoPrimeiraTransacao,
                    valorPrimeiraTransacao,
                    tipoPrimeiraTransacao,
                    categoriaPrimeiraTransacao
            );
            TransacaoDAO transacaoDAO = new TransacaoDAO();
            transacaoDAO.insert(conexao, primeiraTransacao);

            // Closing the PreparedStatement
            if (stmt != null) {
                stmt.close();
            }

            // Preparing the SQL statement for selection
            String sqlSelect = "SELECT * FROM TRANSACOES";
            stmt = conexao.prepareStatement(sqlSelect);

            // Executing the query
            resultSet = stmt.executeQuery();

            // Processing the results
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("ID"));
                System.out.println("USUARIO_ID: " + resultSet.getInt("USUARIO_ID"));
                System.out.println("DATA: " + resultSet.getDate("DATA"));
                System.out.println("DESCRICAO: " + resultSet.getString("DESCRICAO"));
                System.out.println("VALOR: " + resultSet.getDouble("VALOR"));
                System.out.println("TIPO: " + resultSet.getString("TIPO"));
                System.out.println("CATEGORIA: " + resultSet.getString("CATEGORIA"));
                System.out.println("-------------");
            }

        } catch (SQLException exception) {
            System.err.println("Não foi possível conectar ao Banco de Dados");
            exception.printStackTrace();

        } finally {
            // Closing the ResultSet
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            // Closing the PreparedStatement
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            // Closing the database connection
            if (conexao != null) {
                try {
                    conexao.close();
                    System.out.println("Conexao fechada! " + conexao.isClosed());
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
