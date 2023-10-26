package fintech.dao;

import fintech.models.Conta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContaDAO {
    public void insert(Connection conexao, Conta conta) {
        try {
            // Preparando o insert
            String sqlInsert = "INSERT INTO CONTAS " +
                    "(USUARIO_ID, NOME, SALDO)" +
                    " VALUES (?, ?, ?)";
            PreparedStatement stmt = conexao.prepareStatement(sqlInsert);

            // Inserindo os valores nas mascaras do insert
            stmt.setInt(1, 1);
            stmt.setString(2,  conta.getNome());
            stmt.setDouble(3, conta.getSaldo());

            stmt.executeUpdate();
            System.out.println("Conta inserida com sucesso!");
        } catch (SQLException exception) {
            System.err.println("Algo deu errado ao tentar inserir uma conta");
            exception.printStackTrace();
        }
    }

    public ResultSet getAll(Connection conexao) {
        ResultSet resultSet = null;
        try {
            // Preparando o select all
            String sqlSelect = "SELECT * FROM CONTAS";
            PreparedStatement stmt = conexao.prepareStatement(sqlSelect);

            resultSet = stmt.executeQuery();
        } catch (SQLException exception) {
            System.err.println("Algo deu errado ao tentar selecionar todas as contas");
            exception.printStackTrace();
        }
        return resultSet;
    }
}
