import java.util.List;

public class Transacao extends Entidade {
    private final BancoEmMemoria bancoEmMemoria;

    public Transacao(BancoEmMemoria bancoEmMemoria) {
        this.bancoEmMemoria = bancoEmMemoria;
    }

    public void adicionarTransacao(Transacao transacao) {
        bancoEmMemoria.getTransacoes().add(transacao);
    }

    public List<Transacao> listarTransacoes() {
        return bancoEmMemoria.getTransacoes();
    }
}
