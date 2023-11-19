package fintech.dao;

import fintech.models.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuarioDAO {
    private Connection conexao;

    public boolean insert(Usuario usuario) {
        try {
            conexao = ConnectionManager
                    .getInstance()
                    .getConnection();

            // Preparando o insert
            String sqlInsert = "INSERT INTO USUARIOS " +
                    "(NOME, CPF, SENHA, EMAIL, EMAIL_RECUPERACAO)" +
                    " VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conexao.prepareStatement(sqlInsert);

            // Inserindo os valores nas mascaras do insert
            stmt.setString(1,  usuario.getNome());
            stmt.setString(2,  usuario.getCpf());
            stmt.setString(3,  usuario.getSenha());
            stmt.setString(4,  usuario.getEmail());
            stmt.setString(5,  usuario.getEmailRecuperacao());

            stmt.executeUpdate();
            System.out.println("Usuario inserido com sucesso!");

            return true;
        } catch (SQLException exception) {
            System.err.println("Algo deu errado ao tentar inserir um usuario");
            exception.printStackTrace();

            return false;
        }
    }
}
