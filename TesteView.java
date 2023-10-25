import fintech.dao.TransacaoDAO;
import fintech.models.Transacao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.UUID;

public class TesteView {

    public static void main(String... args) {
        Connection conexao = null;

        try {
            // Abrindo a conexao com o banco de dados
            conexao = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:",
                    "mynewschema",
                    "mypassword");
            System.out.println("Conectado ao Banco de Dados!");

            // Instanciando uma transacao
            Date dataPrimeiraTransacao = new Date();
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

            // Instanciando classe responsavel por se comunicar com a tabela de transacoes
            TransacaoDAO transacaoDAO = new TransacaoDAO();

            // Criando uma transacao
            transacaoDAO.insert(conexao, primeiraTransacao);

            // Select em todas as transacoes
            ResultSet resultSet = transacaoDAO.getAll(conexao);

            // Processando as transacoes
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
            // Fechando a conexao com o banco
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
