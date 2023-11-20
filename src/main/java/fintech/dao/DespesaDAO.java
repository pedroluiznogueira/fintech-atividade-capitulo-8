package fintech.dao;

import fintech.models.Despesa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DespesaDAO {
    private Connection conexao;

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

    public boolean insert(Despesa despesa) {
        try {
            conexao = ConnectionManager
                    .getInstance()
                    .getConnection();

            // Preparando o insert
            String sqlInsert = "INSERT INTO DESPESAS" +
                    "(USUARIO_ID, CATEGORIA, DESCRICAO, VALOR)" +
                    " VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conexao.prepareStatement(sqlInsert);

            // Inserindo os valores nas mascaras do insert
            stmt.setInt(1, despesa.getIdUsuario());
            stmt.setString(2, despesa.getCategoria());
            stmt.setString(3,  despesa.getDescricao());
            stmt.setDouble(4, despesa.getValor());

            stmt.executeUpdate();
            System.out.println("Gasto inserido com sucesso");
            return true;
        } catch (SQLException exception) {
            System.err.println("Algo deu errado ao tentar inserir um gasto");
            exception.printStackTrace();
            return false;
        }
    }

    public ResultSet getDespesas(int idUsuario) {
        ResultSet resultSet = null;
        try {
            conexao = ConnectionManager
                    .getInstance()
                    .getConnection();

            // Preparando o select all
            String sqlSelect = "SELECT * FROM DESPESAS WHERE USUARIO_ID = ?";
            PreparedStatement stmt = conexao.prepareStatement(sqlSelect);
            stmt.setInt(1, idUsuario);

            resultSet = stmt.executeQuery();
        } catch (SQLException exception) {
            System.err.println("Algo deu errado ao tentar selecionar todas as Despesas");
            exception.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet getQuantidadeDeDespesas(int idUsuario) {
        ResultSet resultSet = null;
        try {
            conexao = ConnectionManager
                    .getInstance()
                    .getConnection();

            // Preparando o select count
            String sqlSelect = "SELECT COUNT(*) as despesas_count FROM DESPESAS WHERE USUARIO_ID = ?";
            PreparedStatement stmt = conexao.prepareStatement(sqlSelect);
            stmt.setInt(1, idUsuario);

            resultSet = stmt.executeQuery();
        } catch (SQLException exception) {
            System.err.println("Algo deu errado ao tentar selecionar o count das despesas");
            exception.printStackTrace();
        }
        return resultSet;
    }
}
