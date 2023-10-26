package fintech.dao;

import fintech.models.Investimento;
import fintech.models.Transacao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InvestimentoDAO {
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
}
