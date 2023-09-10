import java.util.List;

public class Main {

    /*
    * Dadas as classes Transacao e Usuario, na implementacao real de nossa aplicacao
    * ambas seriam entidades representadas no banco de dados.
    *
    * Para efeito de exemplo, criamos a classe BancoEmMemoria para representar um
    * banco de dado, mantendo os dados das transacoes e usuarios em listas.
    *
    * Dessa forma, ambas as classes utilizam esse mesmo "banco".
    *
    * Para implementacao de heranca, cada entidade sempre tera um ID, que pode ser definido
    * na classe pai, Entidade, dessa forma todas as classes que a implementam carregarao esse ID.
    * */
    public static void main(String[] args) {
        BancoEmMemoria bancoEmMemoria = new BancoEmMemoria();

        Transacao transacaoUm = new Transacao(bancoEmMemoria);
        Transacao transacaoDois = new Transacao(bancoEmMemoria);
        transacaoUm.adicionarTransacao(transacaoUm);
        transacaoUm.adicionarTransacao(transacaoDois);

        List<Transacao> transacoes = transacaoUm.listarTransacoes();
        System.out.println("Lista de transacoes");
        System.out.println(transacoes);

        Usuario usuarioUm = new Usuario(bancoEmMemoria);
        Usuario usuarioDois = new Usuario(bancoEmMemoria);
        usuarioUm.cadastrarUsuario(usuarioUm);
        usuarioUm.cadastrarUsuario(usuarioDois);

        Usuario usuarioUmConsultado = usuarioUm.consultarUsuario(0);
        System.out.println("Usuario 1");
        System.out.println(usuarioUmConsultado);

        Usuario usuarioDoisConsultado = usuarioUm.consultarUsuario(1);
        System.out.println("Usuario 2");
        System.out.println(usuarioDoisConsultado);

        usuarioUm.excluirUsuario(usuarioUm);

        Usuario usuarioAposExcluir = usuarioUm.consultarUsuario(0);
        System.out.println("Usuario apos excluir");
        System.out.println(usuarioAposExcluir);

        Usuario novoUsuario = new Usuario(bancoEmMemoria);
        System.out.println("Novo usuario para substituir");
        System.out.println(novoUsuario);
        usuarioUm.alterarUsuario(0, novoUsuario);

        Usuario usuarioSubstituido = usuarioUm.consultarUsuario(0);
        System.out.println("Usuario substituido");
        System.out.println(usuarioSubstituido);

        int quantidadeDeEntidades = bancoEmMemoria.listarQuantidadeDeEntidades();
        System.out.println("Quantidade de entidades");
        System.out.println(quantidadeDeEntidades);

        List<Entidade> entidades = bancoEmMemoria.listarEntidades();
        entidades.forEach(entidade -> {
            System.out.println("ID de cada entidade presente no banco");
            System.out.println(entidade.getId());
        });

        Transacao novaTransacao = new Transacao(bancoEmMemoria);
        novaTransacao.adicionarTransacao(novaTransacao);
        System.out.println("ID da transacao adicionada");
        System.out.println(novaTransacao.getId());
    }
}
