package fintech.controller.utils;

import fintech.dao.UsuarioDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.ResultSet;
import java.sql.SQLException;

public final class HttpSessionUtils {
    public static int getUsuarioIdUsingHttpSessionCpf(HttpServletRequest req, UsuarioDAO usuarioDAO) {
        HttpSession httpSession = req.getSession();
        String loggedUserCpf = (String) httpSession.getAttribute("cpf");
        ResultSet getByCpfResultSet = usuarioDAO.getByCpf(loggedUserCpf);

        try {
            if (getByCpfResultSet.next()) {
                return getByCpfResultSet.getInt("ID");
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
            throw new RuntimeException(exception);
        }
        // Caso o fluxo de registro nao seja seguido, para evitar erros em tempo de execucao
        // retornando um id de usuario padrao, dado que nao temos um mecanismo complexo de autenticacao
        // que evitaria que esse fluxo nao fosse seguido
        return 1;
    }
}
