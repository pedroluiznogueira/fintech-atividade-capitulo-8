package fintech.dao;

import fintech.models.Telefone;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TelefoneDAO {
    public void insert(Connection conexao, Telefone telefone) {
        try {
            // Preparando o insert
            String sqlInsert = "INSERT INTO TELEFONES " +
                    "(USUARIO_ID, TELEFONE)" +
                    " VALUES (?, ?)";
            PreparedStatement stmt = conexao.prepareStatement(sqlInsert);

            // Inserindo os valores nas mascaras do insert
            stmt.setInt(1, 1);
            stmt.setString(2,  telefone.getTelefone());

            stmt.executeUpdate();
            System.out.println("Telefone inserido com sucesso!");
        } catch (SQLException exception) {
            System.err.println("Algo deu errado ao tentar inserir um telefone");
            exception.printStackTrace();
        }
    }

    public ResultSet getAll(Connection conexao) {
        ResultSet resultSet = null;
        try {
            // Preparando o select all
            String sqlSelect = "SELECT * FROM TELEFONES";
            PreparedStatement stmt = conexao.prepareStatement(sqlSelect);

            resultSet = stmt.executeQuery();
        } catch (SQLException exception) {
            System.err.println("Algo deu errado ao tentar selecionar todos os telefones");
            exception.printStackTrace();
        }
        return resultSet;
    }
}
