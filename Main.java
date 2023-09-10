import fintech.BancoEmMemoria;
import fintech.models.Transacao;
import fintech.models.Usuario;

import java.util.Date;
import java.util.List;

public class Main {

    /*
     * Dadas as classes Transacao e Usuario, na implementacao real de nossa aplicacao
     * ambas seriam entidades representadas no banco de dados.
     *
     * Para efeito de exemplo, criamos a classe fintech.BancoEmMemoria para representar um
     * banco de dado, mantendo os dados das transacoes e usuarios em listas.
     *
     * Dessa forma, ambas as classes utilizam esse mesmo "banco".
     *
     * Para implementacao de heranca, cada entidade sempre tera um ID, que pode ser definido
     * na classe pai, Entidade, dessa forma todas as classes que a implementam carregarao esse ID.
     * */
    public static void main(String... args) {
        BancoEmMemoria bancoEmMemoria = new BancoEmMemoria();

        String nomePrimeiroUsuario = "Joao";
        String cpfPrimeiroUsuario = "11111111111";
        String senhaPrimeiroUsuario = "senha_super_secreta";
        String emailPrimeiroUsuario = "joao@hotmail.com";
        String emailRecuperacaoPrimeiroUsuario = "oaoj@hotmail.com";
        Usuario primeiroUsuario = new Usuario(bancoEmMemoria,
                nomePrimeiroUsuario,
                cpfPrimeiroUsuario,
                senhaPrimeiroUsuario,
                emailPrimeiroUsuario,
                emailRecuperacaoPrimeiroUsuario
        );
        primeiroUsuario.cadastrarUsuario();

        String nomeSegundoUsuario = "Lucas";
        String cpfSegundoUsuario = "22222222222";
        String senhaSegundoUsuario = "outra_senha_super_secreta";
        String emailSegundoUsuario = "lucas@hotmail.com";
        String emailRecuperacaoSegundoUsuario = "sacul@hotmail.com";
        Usuario segundoUsuario = new Usuario(bancoEmMemoria,
                nomeSegundoUsuario,
                cpfSegundoUsuario,
                senhaSegundoUsuario,
                emailSegundoUsuario,
                emailRecuperacaoSegundoUsuario
        );
        segundoUsuario.cadastrarUsuario();

        System.out.println(" ");
        System.out.println("======Consultando o primeiro usuario no banco======");
        Usuario primeiroUsuarioEncontrado = primeiroUsuario.consultarUsuario(0);
        System.out.printf("Usuario com ID: '%s' encontrado no banco %n", primeiroUsuarioEncontrado.getId());

        System.out.println(" ");
        System.out.println("======Consultando o segundo usuario no banco======");
        Usuario segundoUsuarioEncontrado = primeiroUsuario.consultarUsuario(1);
        System.out.printf("Usuario com ID: '%s' encontrado no banco %n", segundoUsuarioEncontrado.getId());

        Usuario segundoUsuarioPreAlteracao = segundoUsuario.consultarUsuario(1);
        System.out.println(" ");
        System.out.println("======Email de recuperacao do segundo usuario pre alteracao======");
        System.out.printf("Email de recuperacao do segundo usuario: '%s' %n", segundoUsuarioPreAlteracao.getEmailRecuperacao());

        String novoEmailRecuperacaoSegundoUsuario = "outroEmailDeRecuperacao@hotmail.com";
        Usuario segundoUsuarioComEmailRecuperacaoAlterado = new Usuario(bancoEmMemoria,
                segundoUsuarioEncontrado.getNome(),
                segundoUsuarioEncontrado.getCpf(),
                segundoUsuarioEncontrado.getSenha(),
                segundoUsuarioEncontrado.getEmail(),
                novoEmailRecuperacaoSegundoUsuario
        );
        segundoUsuario.alterarUsuario(1, segundoUsuarioComEmailRecuperacaoAlterado);

        Usuario segundoUsuarioAposAlteracao = segundoUsuario.consultarUsuario(1);
        System.out.println(" ");
        System.out.println("======Email de recuperacao do segundo usuario apos alteracao======");
        System.out.printf("Email de recuperacao do segundo usuario: '%s' %n", segundoUsuarioAposAlteracao.getEmailRecuperacao());

        segundoUsuarioAposAlteracao.excluirUsuario(primeiroUsuario);
        System.out.println(" ");
        System.out.println("======Recuperando o primeiro usuario da lista apos excluir o primeiro usuario criado======");
        Usuario segundoUsuarioAposExclusaoDoPrimeiro = segundoUsuario.consultarUsuario(0);
        System.out.printf("Email de recuperacao do primeiro usuario da lista: '%s' %n", segundoUsuarioAposExclusaoDoPrimeiro.getEmailRecuperacao());

        Date dataPrimeiraTransacao = new Date();
        String descricaoPrimeiraTransacao = "Primeira transacao do sistema";
        Float valorPrimeiraTransacao = 1.22F;
        String tipoPrimeiraTransacao = "Cartao";
        String categoriaPrimeiraTransacao = "Nacional";
        Transacao primeiraTransacao = new Transacao(bancoEmMemoria,
                primeiroUsuario.getId(),
                dataPrimeiraTransacao,
                descricaoPrimeiraTransacao,
                valorPrimeiraTransacao,
                tipoPrimeiraTransacao,
                categoriaPrimeiraTransacao
        );
        primeiraTransacao.adicionarTransacao();

        Date dataSegundaTransacao = new Date();
        String descricaoSegundaTransacao = "Segunda transacao do sistema";
        Float valorSegundaTransacao = 9.99F;
        String tipoSegundaTransacao = "Pix";
        String categoriaSegundaTransacao = "Internacional";
        Transacao segundaTransacao = new Transacao(bancoEmMemoria,
                segundoUsuario.getId(),
                dataSegundaTransacao,
                descricaoSegundaTransacao,
                valorSegundaTransacao,
                tipoSegundaTransacao,
                categoriaSegundaTransacao
        );
        segundaTransacao.adicionarTransacao();

        List<Transacao> primeiraListaDetransacoes = primeiraTransacao.listarTransacoes();
        System.out.println(" ");
        System.out.println("======Quantidade de transacoes encontradas no banco======");
        System.out.printf("'%s' transacoes encontradas no banco de dados %n", primeiraListaDetransacoes.size());
        System.out.println("======ID de cada transacao encontrada no banco======");
        primeiraListaDetransacoes.forEach(transacao ->
                System.out.printf("Transacao com ID: '%s' encontrada no banco %n", transacao.getId()));

        System.out.println(" ");
        System.out.println("======Dados da primeira transacao======");
        System.out.printf("Primeira transacao pertence ao usuario com id: '%s' %n", primeiraTransacao.getIdUsuario());
        System.out.printf("Data da primeira transacao: '%s' %n", primeiraTransacao.getData());
        System.out.printf("Descricao da primeira transacao: '%s' %n", primeiraTransacao.getDescricao());
        System.out.printf("Valor da primeira transacao: '%s' %n", primeiraTransacao.getValor());
        System.out.printf("Tipo da primeira transacao: '%s' %n", primeiraTransacao.getTipo());
        System.out.printf("Categoria da primeira transacao: '%s' %n", primeiraTransacao.getCategoria());
    }
}
