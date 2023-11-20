package fintech.models;

public class Receita extends Entidade {
    private final int idUsuario;
    private final String tipo;
    private final String descricao;
    private final Float valor;

    public Receita(
            int idUsuario,
            String tipo,
            String descricao,
            Float valor) {
        this.idUsuario = idUsuario;
        this.tipo = tipo;
        this.descricao = descricao;
        this.valor = valor;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public Float getValor() {
        return valor;
    }
}