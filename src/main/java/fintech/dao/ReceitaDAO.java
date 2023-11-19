package fintech.dao;

import fintech.models.Receita;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReceitaDAO {
    public void insert(Connection conexao, Receita receita) {
        try {
            // Preparando o insert
            String sqlInsert = "INSERT INTO RECEITAS " +
                    "(USUARIO_ID, TIPO, DESCRICAO, VALOR)" +
                    " VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conexao.prepareStatement(sqlInsert);

            // Inserindo os valores nas mascaras do insert
            stmt.setInt(1, 1); // TODO: por hora nao usando um Usuario real, dito que foi pedido para nao fazemos para a tabela de usuarios ainda
            stmt.setString(2, receita.getTipo());
            stmt.setString(3, receita.getDescricao());
            stmt.setDouble(4, receita.getValor());

            stmt.executeUpdate();
            System.out.println("Receita inserida com sucesso!");
        } catch (SQLException exception) {
            System.err.println("Algo deu errado ao tentar inserir uma receita");
            exception.printStackTrace();
        }
    }

    public ResultSet getAll(Connection conexao) {
        ResultSet resultSet = null;
        try {
            // Preparando o select all
            String sqlSelect = "SELECT * FROM RECEITAS";
            PreparedStatement stmt = conexao.prepareStatement(sqlSelect);

            resultSet = stmt.executeQuery();
        } catch (SQLException exception) {
            System.err.println("Algo deu errado ao tentar selecionar todas as receitas");
            exception.printStackTrace();
        }
        return resultSet;
    }
}
