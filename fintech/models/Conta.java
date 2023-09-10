package fintech.models;

import fintech.BancoEmMemoria;
import java.util.UUID;

public class Conta extends Entidade {
    private final BancoEmMemoria bancoEmMemoria;
    private final UUID idUsuario;
    private final String nome;
    private Float saldo;

    public Conta(
            BancoEmMemoria bancoEmMemoria,
            UUID idUsuario,
            String nome,
            Float saldo
    ) {
        this.bancoEmMemoria = bancoEmMemoria;
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.saldo = saldo;
    }

    public UUID getIdUsuario() {
        return idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public Float getSaldo() {
        return saldo;
    }

    public void cadastrarConta() {
        bancoEmMemoria.getContas().add(this);
    }

    public void excluirConta() {
        bancoEmMemoria.getContas().remove(this);
    }

    public Conta consultarConta() {
        return this;
    }
}