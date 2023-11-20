package fintech.dao;

import fintech.models.Receita;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReceitaDAO {
    private Connection conexao;

    public void insert(Connection conexao, Receita receita) {
        try {
            // Preparando o insert
            String sqlInsert = "INSERT INTO RECEITA " +
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

    public boolean insert(Receita receita) {
        try {
            conexao = ConnectionManager
                    .getInstance()
                    .getConnection();

            // Preparando o insert
            String sqlInsert = "INSERT INTO RECEITAS" +
                    "(USUARIO_ID, TIPO, DESCRICAO, VALOR)" +
                    " VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conexao.prepareStatement(sqlInsert);

            // Inserindo os valores nas mascaras do insert
            stmt.setInt(1, receita.getIdUsuario());
            stmt.setString(2, receita.getTipo());
            stmt.setString(3,  receita.getDescricao());
            stmt.setDouble(4, receita.getValor());

            stmt.executeUpdate();
            System.out.println("Receita inserida com sucesso");
            return true;
        } catch (SQLException exception) {
            System.err.println("Algo deu errado ao tentar inserir uma receita");
            exception.printStackTrace();
            return false;
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

    public ResultSet getReceitas(int usuarioId) {
        ResultSet resultSet = null;
        try {
            conexao = ConnectionManager
                    .getInstance()
                    .getConnection();

            // Preparando o select all
            String sqlSelect = "SELECT * FROM RECEITAS WHERE USUARIO_ID = ?";
            PreparedStatement stmt = conexao.prepareStatement(sqlSelect);
            stmt.setInt(1, usuarioId);

            resultSet = stmt.executeQuery();
        } catch (SQLException exception) {
            System.err.println("Algo deu errado ao tentar selecionar todas as receitas");
            exception.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet getQuantidadeDeReceitas(int idUsuario) {
        ResultSet resultSet = null;
        try {
            conexao = ConnectionManager
                    .getInstance()
                    .getConnection();

            // Preparando o select count
            String sqlSelect = "SELECT COUNT(*) as receitas_count FROM RECEITAS WHERE USUARIO_ID = ?";
            PreparedStatement stmt = conexao.prepareStatement(sqlSelect);
            stmt.setInt(1, idUsuario);

            resultSet = stmt.executeQuery();
        } catch (SQLException exception) {
            System.err.println("Algo deu errado ao tentar selecionar o count das receitas");
            exception.printStackTrace();
        }
        return resultSet;
    }
}
