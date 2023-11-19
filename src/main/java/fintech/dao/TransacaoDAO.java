package fintech.dao;

import fintech.models.Transacao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TransacaoDAO {
    public void insert(Connection conexao, Transacao transacao) {
        try {
            // Preparando o insert
            String sqlInsert = "INSERT INTO TRANSACOES " +
                    "(USUARIO_ID, DATA, DESCRICAO, VALOR, TIPO, CATEGORIA)" +
                    " VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conexao.prepareStatement(sqlInsert);

            // Inserindo os valores nas mascaras do insert
            stmt.setInt(1, 1); // TODO: por hora nao usando um Usuario real, dito que foi pedido para nao fazemos para a tabela de usuarios ainda
            stmt.setDate(2, new Date(System.currentTimeMillis()));
            stmt.setString(3,  transacao.getDescricao());
            stmt.setDouble(4, transacao.getValor());
            stmt.setString(5, transacao.getTipo());
            stmt.setString(6, transacao.getCategoria());

            stmt.executeUpdate();
            System.out.println("Transacao inserida com sucesso");
        } catch (SQLException exception) {
            System.err.println("Algo deu errado ao tentar inserir uma transacao");
            exception.printStackTrace();
        }
    }

    public ResultSet getAll(Connection conexao) {
        ResultSet resultSet = null;
        try {
            // Preparando o select all
            String sqlSelect = "SELECT * FROM TRANSACOES";
            PreparedStatement stmt = conexao.prepareStatement(sqlSelect);

            resultSet = stmt.executeQuery();
        } catch (SQLException exception) {
            System.err.println("Algo deu errado ao tentar selecionar todas as transacoes");
            exception.printStackTrace();
        }
        return resultSet;
    }
}
