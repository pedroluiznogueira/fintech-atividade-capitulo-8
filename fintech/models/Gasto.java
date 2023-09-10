package fintech.models;

import fintech.BancoEmMemoria;

import java.util.UUID;

public class Gasto extends Entidade {
    private final BancoEmMemoria bancoEmMemoria;
    private final UUID idUsuario;
    private final String categoria;
    private final String descricao;
    private final Float valor;

    public Gasto(
            BancoEmMemoria bancoEmMemoria,
            UUID idUsuario,
            String categoria,
            String descricao,
            Float valor
    ) {
        this.bancoEmMemoria = bancoEmMemoria;
        this.idUsuario = idUsuario;
        this.categoria = categoria;
        this.descricao = descricao;
        this.valor = valor;
    }

    public UUID getIdUsuario() {
        return idUsuario;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public Float getValor() {
        return valor;
    }

    public void cadastrarGasto() {
        bancoEmMemoria.getGastos().add(this);
    }

    public void alterarGasto(Integer posicaoGasto, Gasto gasto) {
        bancoEmMemoria.getGastos().set(posicaoGasto, gasto);
    }

    public void excluirGasto() {
        bancoEmMemoria.getGastos().remove(this);
    }

    public Gasto consultarGasto() {
        return this;
    }
}