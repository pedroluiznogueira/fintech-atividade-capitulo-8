package oop;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    List<Usuario> usuarios = new ArrayList<>();

    public void cadastrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public Usuario consultarUsuario(Integer posicaoUsuario) {
        return usuarios.get(posicaoUsuario);
    }

    public void alterarUsuario(Integer posicaoUsuario, Usuario usuario) {
        usuarios.set(posicaoUsuario, usuario);
    }

    public void excluirUsuario(Usuario usuario) {
        usuarios.remove(usuario);
    }
}
