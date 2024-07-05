import java.util.ArrayList;
import java.util.Scanner;

public class Mecanica {
    private static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    private static ArrayList<Produto> produtos = new ArrayList<Produto>();
    private static ArrayList<Servico> servicos = new ArrayList<Servico>();
    private static Financas financas = new Financas();

    public static ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public static void setClientes(ArrayList<Cliente> clientes) {
        Mecanica.clientes = clientes;
    }

    public static ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public static void setProdutos(ArrayList<Produto> produtos) {
        Mecanica.produtos = produtos;
    }

    public static ArrayList<Servico> getServicos() {
        return servicos;
    }

    public static void setServicos(ArrayList<Servico> servicos) {
        Mecanica.servicos = servicos;
    }

    public static Financas getFinancas() {
        return financas;
    }

    public static void setFinancas(Financas financas) {
        Mecanica.financas = financas;
    }

    public static boolean reporEstoque(Produto produto, int quantidade) {
        float custo = quantidade * produto.getCusto();
        if (custo > financas.getCaixa()) {
            System.out.println("A Mecanica nao tem caixa para fazer essa aquisicao.");
            System.out.printf("Caixa atual: %f. Custo do(s) produto(s): %f\n", financas.getCaixa(), custo);
            System.out.print("Pressione [ENTER] tecla para continuar. ");
            Leitor.esperarEnter();
            return false;
        }
        financas.setCaixa(financas.getCaixa() - custo);
        financas.setGastos(financas.getGastos() + custo);
        financas.setCaixaEmProdutos(financas.getCaixaEmProdutos() + (produto.calculaPreco() * quantidade));
        produto.setEstoque(produto.getEstoque() + quantidade);
        return true;
    }

    public static Cliente cadastrarCliente() {
        /*
        Cria um novo cliente e adiciona ele na arraylist clientes
         */
        String nome, cpf;
        System.out.print("\n--- Cadastro de Cliente ---\n");
        System.out.print("Informe o nome do cliente: ");
        nome = Leitor.lerLinha();

        System.out.print("Informe o cpf do cliente: ");
        cpf = Leitor.lerLinha();

        Cliente newCliente = new Cliente(cpf, nome);
        clientes.add(newCliente);
        return newCliente;
    }

    public static void cadastrarProduto() {
        /*
        Cria um novo produto e adiciona ele na arraylist produtos
         */
        String nome;
        int resposta;
        TipoProduto tipo;
        float preco, custo;
        System.out.print("\n--- Cadastro de Produto ---\n");
        System.out.print("Informe o nome do produto: ");
        nome = Leitor.lerLinha();

        System.out.print("Informe o custo de aquisicao do produto: ");
        custo = Leitor.lerFloat();

        System.out.print("Informe o tipo: [(1) Mecanica/ (2) Estetica]: ");
        resposta = Leitor.lerInt();

        if (resposta == 1) {
            tipo = TipoProduto.MECANICA;
        } else {
            tipo = TipoProduto.ESTETICA;
        }

        Produto newProduto = new Produto(custo, nome, tipo);
        newProduto.setPreco(newProduto.calculaPreco());

        produtos.add(newProduto);
    }

    public static void cadastrarServico() {
        // Cria um novo serviço e adiciona ele na arraylist serviços
        String nome, descricao;
        float custo;
        System.out.print("\n--- Cadastro de Serviço ---\n");
        System.out.print("Informe o nome do servico: ");
        nome = Leitor.lerLinha();

        System.out.print("Informe o custo de execucao do servico: ");
        custo = Leitor.lerFloat();

        System.out.print("Informe a descrição: ");
        descricao = Leitor.lerLinha();

        Servico newServico = new Servico(custo, nome, descricao);
        newServico.setPreco(newServico.calculaPreco());

        servicos.add(newServico);
    }
}
