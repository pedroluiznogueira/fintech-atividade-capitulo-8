package fintech.models;

import fintech.BancoEmMemoria;

import java.util.UUID;

public class Telefone extends Entidade {
    private final BancoEmMemoria bancoEmMemoria;
    private final UUID idUsuario;
    private final String telefone;

    public Telefone(
            BancoEmMemoria bancoEmMemoria,
            UUID idUsuario,
            String telefone
    ) {
        this.bancoEmMemoria = bancoEmMemoria;
        this.idUsuario = idUsuario;
        this.telefone = telefone;
    }

    public Telefone(
            UUID idUsuario,
            String telefone
    ) {
        this.bancoEmMemoria = null;
        this.idUsuario = idUsuario;
        this.telefone = telefone;
    }

    public UUID getIdUsuario() {
        return idUsuario;
    }

    public String getTelefone() {
        return telefone;
    }

    public void cadastrarTelefone() {
        bancoEmMemoria.getTelefones().add(this);
    }

    public void alterarTelefone(Integer posicaoTelefone, Telefone telefone) {
        bancoEmMemoria.getTelefones().set(posicaoTelefone, telefone);
    }

    public void excluirTelefone() {
        bancoEmMemoria.getTelefones().remove(this);
    }

    public Telefone consultarTelefone() {
        return this;
    }
}