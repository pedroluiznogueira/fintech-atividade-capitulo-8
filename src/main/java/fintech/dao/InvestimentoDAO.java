package fintech.dao;

import fintech.models.Investimento;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InvestimentoDAO {
    private Connection conexao;

    public void insert(Connection conexao, Investimento investimento) {
        try {
            // Preparando o insert
            String sqlInsert = "INSERT INTO INVESTIMENTOS " +
                    "(USUARIO_ID, TIPO, DESCRICAO, VALOR_INVESTIDO, DATA_INVESTIMENTO, RETORNO_ESTIMADO)" +
                    " VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conexao.prepareStatement(sqlInsert);

            // Inserindo os valores nas mascaras do insert
            stmt.setInt(1, 1); // TODO: por hora nao usando um Usuario real, dito que foi pedido para nao fazemos para a tabela de usuarios ainda
            stmt.setString(2, investimento.getTipo());
            stmt.setString(3,  investimento.getDescricao());
            stmt.setDouble(4, investimento.getValorInvestido());
            stmt.setDate(5, new Date(System.currentTimeMillis()));
            stmt.setDouble(6, investimento.getRetornoEstimado());

            stmt.executeUpdate();
            System.out.println("Investimento inserido com sucesso");
        } catch (SQLException exception) {
            System.err.println("Algo deu errado ao tentar inserir um investimento");
            exception.printStackTrace();
        }
    }

    public boolean insert(Investimento investimento) {
        try {
            conexao = ConnectionManager
                    .getInstance()
                    .getConnection();

            // Preparando o insert
            String sqlInsert = "INSERT INTO INVESTIMENTOS " +
                    "(USUARIO_ID, TIPO, DESCRICAO, VALOR_INVESTIDO, DATA_INVESTIMENTO, RETORNO_ESTIMADO)" +
                    " VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conexao.prepareStatement(sqlInsert);

            // Inserindo os valores nas mascaras do insert
            stmt.setInt(1, investimento.getIdUsuario());
            stmt.setString(2, investimento.getTipo());
            stmt.setString(3,  investimento.getDescricao());
            stmt.setDouble(4, investimento.getValorInvestido());
            stmt.setDate(5, new Date(System.currentTimeMillis()));
            stmt.setDouble(6, investimento.getRetornoEstimado());

            stmt.executeUpdate();
            System.out.println("Investimento inserido com sucesso");
            return true;
        } catch (SQLException exception) {
            System.err.println("Algo deu errado ao tentar inserir um investimento");
            exception.printStackTrace();
            return false;
        }
    }

    public ResultSet getAll(Connection conexao) {
        ResultSet resultSet = null;
        try {
            // Preparando o select all
            String sqlSelect = "SELECT * FROM INVESTIMENTOS";
            PreparedStatement stmt = conexao.prepareStatement(sqlSelect);

            resultSet = stmt.executeQuery();
        } catch (SQLException exception) {
            System.err.println("Algo deu errado ao tentar selecionar todos os investimentos");
            exception.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet getInvestimentos(int usuarioId) {
        ResultSet resultSet = null;
        try {
            conexao = ConnectionManager
                    .getInstance()
                    .getConnection();

            // Preparando o select all
            String sqlSelect = "SELECT * FROM INVESTIMENTOS WHERE USUARIO_ID = ?";
            PreparedStatement stmt = conexao.prepareStatement(sqlSelect);
            stmt.setInt(1, usuarioId);

            resultSet = stmt.executeQuery();
        } catch (SQLException exception) {
            System.err.println("Algo deu errado ao tentar selecionar todos os investimentos");
            exception.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet getQuantidadeDeInvestimentos(int idUsuario) {
        ResultSet resultSet = null;
        try {
            conexao = ConnectionManager
                    .getInstance()
                    .getConnection();

            // Preparando o select count
            String sqlSelect = "SELECT COUNT(*) as investimentos_count FROM INVESTIMENTOS WHERE USUARIO_ID = ?";
            PreparedStatement stmt = conexao.prepareStatement(sqlSelect);
            stmt.setInt(1, idUsuario);

            resultSet = stmt.executeQuery();
        } catch (SQLException exception) {
            System.err.println("Algo deu errado ao tentar selecionar o count dos investimentos");
            exception.printStackTrace();
        }
        return resultSet;
    }

}
