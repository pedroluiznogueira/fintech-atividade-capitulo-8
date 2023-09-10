public class Usuario extends Entidade {
    private final BancoEmMemoria bancoEmMemoria;

    public Usuario(BancoEmMemoria bancoEmMemoria) {
        this.bancoEmMemoria = bancoEmMemoria;
    }

    public void cadastrarUsuario(Usuario usuario) {
        bancoEmMemoria.getUsuarios().add(usuario);
    }

    public Usuario consultarUsuario(Integer posicaoUsuario) {
        return bancoEmMemoria.getUsuarios().get(posicaoUsuario);
    }

    public void alterarUsuario(Integer posicaoUsuario, Usuario usuario) {
        bancoEmMemoria.getUsuarios().set(posicaoUsuario, usuario);
    }

    public void excluirUsuario(Usuario usuario) {
        bancoEmMemoria.getUsuarios().remove(usuario);
    }
}
