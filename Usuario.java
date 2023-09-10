public class Usuario extends Entidade {
    private final BancoEmMemoria bancoEmMemoria;
    private final String nome;
    private final String cpf;
    private final String senha;
    private final String email;
    private final String emailRecuperacao;

    public Usuario(
            BancoEmMemoria bancoEmMemoria,
            String nome,
            String cpf,
            String senha,
            String email,
            String emailRecuperacao
    ) {
        this.bancoEmMemoria = bancoEmMemoria;
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.email = email;
        this.emailRecuperacao = emailRecuperacao;
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
