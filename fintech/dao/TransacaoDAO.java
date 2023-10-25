package fintech.dao;

import fintech.models.Transacao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TransacaoDAO {
    public void insert(Connection conexao, Transacao transacao) throws SQLException {
        // Preparando o sql insert
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

        // TODO: adicionar try catch para tabela inexistente ou erro inserindo
        stmt.executeUpdate();
        System.out.println("Record inserted successfully!");
    }

    public ResultSet getAll(Connection conexao) throws SQLException {
        // Preparando o sql all
        String sqlSelect = "SELECT * FROM TRANSACOES";
        PreparedStatement stmt = conexao.prepareStatement(sqlSelect);

        // TODO: adicionar try catch para tabela inexistente ou erro selecionando
        ResultSet resultSet = stmt.executeQuery();
        return resultSet;
    }
}
