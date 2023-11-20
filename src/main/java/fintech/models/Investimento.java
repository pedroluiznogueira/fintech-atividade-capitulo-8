package fintech.models;

import java.util.Date;

/**
 *
 * Poderia ser um Record, porem deixando como classe por conta
 * do conteudo ensinado ate entao.
 *
**/
public class Investimento {
    private final int idUsuario;
    private final String tipo;
    private final String descricao;
    private final Float valorInvestido;
    private final Date dataInvestimento;
    private final Float retornoEstimado;

    public Investimento(
            int idUsuario,
            String tipo,
            String descricao,
            Float valorInvestido,
            Date dataInvestimento,
            Float retornoEstimado) {
        this.idUsuario = idUsuario;
        this.tipo = tipo;
        this.descricao = descricao;
        this.valorInvestido = valorInvestido;
        this.dataInvestimento = dataInvestimento;
        this.retornoEstimado = retornoEstimado;
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

    public Float getValorInvestido() {
        return valorInvestido;
    }

    public Date getDataInvestimento() {
        return dataInvestimento;
    }

    public Float getRetornoEstimado() {
        return retornoEstimado;
    }
}
