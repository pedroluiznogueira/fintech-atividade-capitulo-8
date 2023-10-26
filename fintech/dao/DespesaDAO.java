package fintech.dao;

import fintech.models.Despesa;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DespesaDAO {
    public void insert(Connection conexao, Despesa despesa) {
        try {
            // Preparando o insert
            String sqlInsert = "INSERT INTO DESPESAS " +
                    "(USUARIO_ID, CATEGORIA, DESCRICAO, VALOR)" +
                    " VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conexao.prepareStatement(sqlInsert);

            // Inserindo os valores nas mascaras do insert
            stmt.setInt(1, 1);
            stmt.setString(2,  despesa.getCategoria());
            stmt.setString(3,  despesa.getDescricao());
            stmt.setDouble(4,  despesa.getValor());

            stmt.executeUpdate();
            System.out.println("Despesa inserida com sucesso!");
        } catch (SQLException exception) {
            System.err.println("Algo deu errado ao tentar inserir uma Despesa");
            exception.printStackTrace();
        }
    }

    public ResultSet getAll(Connection conexao) {
        ResultSet resultSet = null;
        try {
            // Preparando o select all
            String sqlSelect = "SELECT * FROM DESPESAS";
            PreparedStatement stmt = conexao.prepareStatement(sqlSelect);

            resultSet = stmt.executeQuery();
        } catch (SQLException exception) {
            System.err.println("Algo deu errado ao tentar selecionar todas as Despesas");
            exception.printStackTrace();
        }
        return resultSet;
    }
}
