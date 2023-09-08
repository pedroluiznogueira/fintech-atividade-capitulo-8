package oop;

import java.util.ArrayList;
import java.util.List;

public class Transacao {
    List<Transacao> transacoes = new ArrayList<>();

    public void adicionarTransacao(Transacao transacao) {
        transacoes.add(transacao);
    }

    public List<Transacao> listarTransacoes() {
        return transacoes;
    }
}
