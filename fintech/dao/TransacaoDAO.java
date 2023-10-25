package fintech.dao;

import fintech.models.Transacao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransacaoDAO {
    public void insert(Connection conexao, Transacao transacao) throws SQLException {
        // Preparing the SQL statement for insertion
        String sqlInsert = "INSERT INTO TRANSACOES " +
                "(USUARIO_ID, DATA, DESCRICAO, VALOR, TIPO, CATEGORIA)" +
                " VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = conexao.prepareStatement(sqlInsert);

        // Filling in the values
        stmt.setInt(1, 1); // Assuming you have a user with ID=1 in USUARIOS table
        stmt.setDate(2, new Date(System.currentTimeMillis()));
        stmt.setString(3,  transacao.getDescricao());
        stmt.setDouble(4, transacao.getValor());
        stmt.setString(5, transacao.getTipo());
        stmt.setString(6, transacao.getCategoria());

        // Executing the statement
        stmt.executeUpdate();
        System.out.println("Record inserted successfully!");
    }
}
