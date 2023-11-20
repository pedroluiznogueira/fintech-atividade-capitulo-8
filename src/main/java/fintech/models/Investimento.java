package fintech.models;

import fintech.BancoEmMemoria;

import java.util.Date;
import java.util.UUID;

public class Investimento {
    private final BancoEmMemoria bancoEmMemoria;
    private final UUID idUsuario;
    private final String tipo;
    private final String descricao;
    private final Float valorInvestido;
    private final Date dataInvestimento;
    private final Float retornoEstimado;

    public Investimento(
            BancoEmMemoria bancoEmMemoria,
            UUID idUsuario,
            String tipo,
            String descricao,
            Float valorInvestido,
            Date dataInvestimento,
            Float retornoEstimado) {
        this.bancoEmMemoria = bancoEmMemoria;
        this.idUsuario = idUsuario;
        this.tipo = tipo;
        this.descricao = descricao;
        this.valorInvestido = valorInvestido;
        this.dataInvestimento = dataInvestimento;
        this.retornoEstimado = retornoEstimado;
    }

    public Investimento(
            UUID idUsuario,
            String tipo,
            String descricao,
            Float valorInvestido,
            Date dataInvestimento,
            Float retornoEstimado) {
        this.bancoEmMemoria = null;
        this.idUsuario = idUsuario;
        this.tipo = tipo;
        this.descricao = descricao;
        this.valorInvestido = valorInvestido;
        this.dataInvestimento = dataInvestimento;
        this.retornoEstimado = retornoEstimado;
    }

    public Investimento(
            String tipo,
            String descricao,
            Float valorInvestido,
            Date dataInvestimento,
            Float retornoEstimado) {
        this.bancoEmMemoria = null;
        this.idUsuario = null;
        this.tipo = tipo;
        this.descricao = descricao;
        this.valorInvestido = valorInvestido;
        this.dataInvestimento = dataInvestimento;
        this.retornoEstimado = retornoEstimado;
    }

    public UUID getIdUsuario() {
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
