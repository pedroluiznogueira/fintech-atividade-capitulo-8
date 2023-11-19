import fintech.dao.ContaDAO;
import fintech.dao.DespesaDAO;
import fintech.dao.InvestimentoDAO;
import fintech.dao.ReceitaDAO;
import fintech.dao.TelefoneDAO;
import fintech.dao.TransacaoDAO;
import fintech.models.Conta;
import fintech.models.Despesa;
import fintech.models.Investimento;
import fintech.models.Receita;
import fintech.models.Telefone;
import fintech.models.Transacao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.UUID;

public class TesteView {

    public static void main(String... args) {
        Connection conexao = null;

        try {
            // Abrindo a conexao com o banco de dados
            conexao = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:",
                    "fintech",
                    "mysecretpassword");
            System.out.println("Conectado ao Banco de Dados!");

            System.out.println("-------TRANSACOES-------");

            // Instanciando uma transacao
            Date dataTransacao = new Date();
            String descricaoTransacao = " transacao do sistema";
            Float valorTransacao = 1.22F;
            String tipoTransacao = "Cartao";
            String categoriaTransacao = "Nacional";
            Transacao transacao = new Transacao(
                    UUID.randomUUID(),
                    dataTransacao,
                    descricaoTransacao,
                    valorTransacao,
                    tipoTransacao,
                    categoriaTransacao
            );

            // Instanciando classe responsavel por se comunicar com a tabela de transacoes
            TransacaoDAO transacaoDAO = new TransacaoDAO();

            // Criando uma transacao
            transacaoDAO.insert(conexao, transacao);

            // Select em todas as transacoes
            ResultSet resultSetTransacoes = transacaoDAO.getAll(conexao);

            // Processando as transacoes
            while (resultSetTransacoes.next()) {
                System.out.println("ID: " + resultSetTransacoes.getInt("ID"));
                System.out.println("-------------");
            }

            System.out.println("-------INVESTIMENTOS-------");

            // Instanciando um investimento
            String tipoInvestimento = "Cartao";
            String descricaoInvestimento = "Primeira transacao do sistema";
            Float valorInvestidoInvestimento = 1.22F;
            Date dataInvestimento = new Date();
            Float retornoEstimadoInvestimento = 2.22F;
            Investimento investimento = new Investimento(
                    UUID.randomUUID(),
                    tipoInvestimento,
                    descricaoInvestimento,
                    valorInvestidoInvestimento,
                    dataInvestimento,
                    retornoEstimadoInvestimento
            );

            // Instanciando classe responsavel por se comunicar com a tabela de investimentos
            InvestimentoDAO investimentoDAO = new InvestimentoDAO();

            // Criando um investimento
            investimentoDAO.insert(conexao, investimento);

            // Select em todas os investimentos
            ResultSet resultSetInvestimento = investimentoDAO.getAll(conexao);

            // Processando os investimentos
            while (resultSetInvestimento.next()) {
                System.out.println("ID: " + resultSetInvestimento.getInt("ID"));
                System.out.println("-------------");
            }

            System.out.println("-------TELEFONES-------");

            // Instanciando um telefone
            String numeroTelefone = "1234567890";
            Telefone telefone = new Telefone(
                    UUID.randomUUID(),
                    numeroTelefone
            );

            // Instanciando classe responsavel por se comunicar com a tabela de telefones
            TelefoneDAO telefoneDAO = new TelefoneDAO();

            // Criando um telefone
            telefoneDAO.insert(conexao, telefone);

            // Select em todas os investimentos
            ResultSet resultSetTelefone = telefoneDAO.getAll(conexao);

            // Processando os investimentos
            while (resultSetTelefone.next()) {
                System.out.println("ID: " + resultSetTelefone.getInt("ID"));
                System.out.println("-------------");
            }

            System.out.println("-------RECEITAS-------");

            // Instanciando uma receita
            String tipoReceita = "investimento";
            String descricaoReceita = " receita do sistema";
            Float valorReceita = 1.60F;
            Receita receita = new Receita(
                    UUID.randomUUID(),
                    tipoReceita,
                    descricaoReceita,
                    valorReceita
            );

            // Instanciando classe responsavel por se comunicar com a tabela de receitas
            ReceitaDAO receitaDAO = new ReceitaDAO();

            // Criando uma receita
            receitaDAO.insert(conexao, receita);

            // Select em todas as receitas
            ResultSet resultSetReceita = receitaDAO.getAll(conexao);

            // Processando as receitas
            while (resultSetReceita.next()) {
                System.out.println("ID: " + resultSetReceita.getInt("ID"));
                System.out.println("-------------");
            }

            System.out.println("-------CONTAS-------");

            // Instanciando uma conta
            String nomeConta = "corrente";
            Float saldoConta = 2500F;
            Conta conta = new Conta(
                    UUID.randomUUID(),
                    nomeConta,
                    saldoConta
            );

            // Instanciando classe responsavel por se comunicar com a tabela de contas
            ContaDAO contaDAO = new ContaDAO();

            // Criando uma conta
            contaDAO.insert(conexao, conta);

            // Select em todas as contas
            ResultSet resultSetConta = contaDAO.getAll(conexao);

            // Processando as contas
            while (resultSetConta.next()) {
                System.out.println("ID: " + resultSetConta.getInt("ID"));
                System.out.println("-------------");
            }

            System.out.println("-------DESPESAS-------");

            // Instanciando uma despesa
            String categoriaDespesa = "mensal";
            String descricaoDespesa = "conta para gastos mensais";
            Float valorDespesa = 2500F;
            Despesa despesa = new Despesa(
                    UUID.randomUUID(),
                    categoriaDespesa,
                    descricaoDespesa,
                    valorDespesa
            );

            // Instanciando classe responsavel por se comunicar com a tabela de despesas
            DespesaDAO despesaDAO = new DespesaDAO();

            // Criando uma despesa
            despesaDAO.insert(conexao, despesa);

            // Select em todas as despesas
            ResultSet resultSetDespesa = despesaDAO.getAll(conexao);

            // Processando as despesas
            while (resultSetDespesa.next()) {
                System.out.println("ID: " + resultSetDespesa.getInt("ID"));
                System.out.println("-------------");
            }

        } catch (SQLException exception) {
            System.err.println("Não foi possível conectar ao Banco de Dados");
            exception.printStackTrace();

        } finally {
            // Fechando a conexao com o banco
            if (conexao != null) {
                try {
                    conexao.close();
                    System.out.println("Conexao fechada! " + conexao.isClosed());
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
