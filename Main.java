import oop.Transacao;
import oop.Usuario;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Transacao transacaoUm = new Transacao();
        Transacao transacaoDois = new Transacao();
        transacaoUm.adicionarTransacao(transacaoUm);
        transacaoUm.adicionarTransacao(transacaoDois);

        List<Transacao> transacoes = transacaoUm.listarTransacoes();
        System.out.println("Lista de transacoes");
        System.out.println(transacoes);

        Usuario usuarioUm = new Usuario();
        Usuario usuarioDois = new Usuario();
        usuarioUm.cadastrarUsuario(usuarioUm);
        usuarioUm.cadastrarUsuario(usuarioDois);

        Usuario usuarioUmConsultado = usuarioUm.consultarUsuario(0);
        System.out.println("oop.Usuario 1");
        System.out.println(usuarioUmConsultado);

        Usuario usuarioDoisConsultado = usuarioUm.consultarUsuario(1);
        System.out.println("oop.Usuario 2");
        System.out.println(usuarioDoisConsultado);

        usuarioUm.excluirUsuario(usuarioUm);

        Usuario usuarioAposExcluir = usuarioUm.consultarUsuario(0);
        System.out.println("oop.Usuario apos excluir");
        System.out.println(usuarioAposExcluir);

        Usuario novoUsuario = new Usuario();
        System.out.println("Novo usuario para substituir");
        System.out.println(novoUsuario);
        usuarioUm.alterarUsuario(0, novoUsuario);

        Usuario usuarioSubstituido = usuarioUm.consultarUsuario(0);
        System.out.println("oop.Usuario substituido");
        System.out.println(usuarioSubstituido);
    }
}
