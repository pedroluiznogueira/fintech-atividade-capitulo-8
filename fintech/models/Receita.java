package fintech.models;

import fintech.BancoEmMemoria;
import java.util.UUID;

public class Receita extends Entidade {
    private final BancoEmMemoria bancoEmMemoria;
    private final UUID idUsuario;
    private final String tipo;
    private final String descricao;
    private final Float valor;

    public Receita(
            BancoEmMemoria bancoEmMemoria,
            UUID idUsuario,
            String tipo,
            String descricao,
            Float valor
    ) {
        this.bancoEmMemoria = bancoEmMemoria;
        this.idUsuario = idUsuario;
        this.tipo = tipo;
        this.descricao = descricao;
        this.valor = valor;
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

    public Float getValor() {
        return valor;
    }

    public void cadastrarReceita() {
        bancoEmMemoria.getReceitas().add(this);
    }

    public void alterarReceita(Integer posicaoReceita, Receita receita) {
        bancoEmMemoria.getReceitas().set(posicaoReceita, receita);
    }

    public void excluirReceita() {
        bancoEmMemoria.getReceitas().remove(this);
    }

    public Receita consultarReceita() {
        return this;
    }
}