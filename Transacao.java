import java.util.Date;
import java.util.List;

public class Transacao extends Entidade {
    private final BancoEmMemoria bancoEmMemoria;
    private final Date data;
    private final String descricao;
    private final Float valor;
    private final String tipo;
    private final String categoria;


    public Transacao(
            BancoEmMemoria bancoEmMemoria,
            Date data,
            String descricao,
            Float valor,
            String tipo,
            String categoria
    ) {
        this.bancoEmMemoria = bancoEmMemoria;
        this.data = data;
        this.descricao = descricao;
        this.valor = valor;
        this.tipo = tipo;
        this.categoria = categoria;
    }

    public Date getData() {
        return data;
    }

    public String getDescricao() {
        return descricao;
    }

    public Float getValor() {
        return valor;
    }

    public String getTipo() {
        return tipo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void adicionarTransacao() {
        bancoEmMemoria.getTransacoes().add(this);
    }

    public List<Transacao> listarTransacoes() {
        return bancoEmMemoria.getTransacoes();
    }
}