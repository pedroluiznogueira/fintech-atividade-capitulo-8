package fintech.models;

import fintech.BancoEmMemoria;

import java.util.UUID;

public class Despesa extends Entidade {
    private final int idUsuario;
    private final String categoria;
    private final String descricao;
    private final Float valor;

    public Despesa(
            int idUsuario,
            String categoria,
            String descricao,
            Float valor) {
        this.idUsuario = idUsuario;
        this.categoria = categoria;
        this.descricao = descricao;
        this.valor = valor;
    }

    public int getIdUsuario() {
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
}