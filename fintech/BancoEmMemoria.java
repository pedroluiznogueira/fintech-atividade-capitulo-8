package fintech;

import fintech.models.Conta;
import fintech.models.Entidade;
import fintech.models.Gasto;
import fintech.models.Receita;
import fintech.models.Telefone;
import fintech.models.Transacao;
import fintech.models.Usuario;

import java.util.ArrayList;
import java.util.List;

public class BancoEmMemoria {
    private final List<Usuario> usuarios = new ArrayList<>();
    private final List<Transacao> transacoes = new ArrayList<>();
    private final List<Conta> contas = new ArrayList<>();
    private final List<Gasto> gastos = new ArrayList<>();
    private final List<Receita> receitas = new ArrayList<>();
    private final List<Telefone> telefones = new ArrayList<>();

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public List<Gasto> getGastos() {
        return gastos;
    }

    public List<Receita> getReceitas() {
        return receitas;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    // TODO: utilizar esses metodos
    public int listarQuantidadeDeEntidades() {
        return usuarios.size() + transacoes.size();
    }

    public List<Entidade> listarEntidades() {
        List<Entidade> entidades = new ArrayList<>();
        entidades.addAll(usuarios);
        entidades.addAll(transacoes);
        return entidades;
    }
}
