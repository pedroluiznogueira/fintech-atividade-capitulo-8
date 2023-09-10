import java.util.Date;
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
    public static void main(String... args) {
        BancoEmMemoria bancoEmMemoria = new BancoEmMemoria();

        Date dataPrimeiraTransacao = new Date();
        String descricaoPrimeiraTransacao = "Primeira transacao do sistema";
        Float valorPrimeiraTransacao = 1.22F;
        String tipoPrimeiraTransacao = "Cartao";
        String categoriaPrimeiraTransacao = "Nacional";
        Transacao primeiraTransacao = new Transacao(bancoEmMemoria,
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
                dataSegundaTransacao,
                descricaoSegundaTransacao,
                valorSegundaTransacao,
                tipoSegundaTransacao,
                categoriaSegundaTransacao
        );
        segundaTransacao.adicionarTransacao();

        List<Transacao> primeiraListaDetransacoes = primeiraTransacao.listarTransacoes();
        System.out.println("---Quantidade de transacoes encontradas no banco---");
        System.out.printf("'%s' transacoes encontradas no banco de dados %n", primeiraListaDetransacoes.size());
        System.out.println("---ID de cada transacao encontrada no banco---");
        primeiraListaDetransacoes.forEach(transacao ->
                System.out.printf("Transacao com ID: '%s' encontrada no banco %n", transacao.getId()));
    }
}
