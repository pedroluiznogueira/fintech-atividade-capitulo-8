import java.util.ArrayList;
import java.util.List;

public class BancoEmMemoria {
    private final List<Usuario> usuarios = new ArrayList<>();
    private final List<Transacao> transacoes = new ArrayList<>();

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }

    public int listarQuantidadeDeEntidades() {
        return usuarios.size() + transacoes.size();
    }

    public List<Entidade> listarEntidades() {
        List<Entidade> entidades = new ArrayList<>();
        entidades.addAll(usuarios);
        entidades.addAll(transacoes);
        return entidades;
    }
}
