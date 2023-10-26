package fintech.dao;

import fintech.models.Conta;
import fintech.models.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
* Implementando o insert de usuario para poder ter um usuario por padrao no banco de dados.
* Do contrario nao teriamos uma FK para ser referenciada nas tabelas que tem relacionamento
* com a tabela de usuarios.
* */
public class UsuarioDAO {
    public void insert(Connection conexao, Usuario usuario) {
        try {
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
        } catch (SQLException exception) {
            System.err.println("Algo deu errado ao tentar inserir um usuario");
            exception.printStackTrace();
        }
    }
}
