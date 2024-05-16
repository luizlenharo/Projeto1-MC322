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
            return false;
        }
        financas.setCaixa(financas.getCaixa() - custo);
        produto.setEstoque(produto.getEstoque() + quantidade);
        return true;
    }

    public static Cliente cadastrarCliente() {
        /*
        Cria um novo cliente e adiciona ele na arraylist clientes
         */
        String nome, cpf;
        Scanner entrada = new Scanner(System.in);
        System.out.print("\n--- Cadastro de Cliente ---\n");
        System.out.print("informe o nome: ");
        nome = entrada.nextLine();

        System.out.print("informe o cpf: ");
        cpf = entrada.nextLine();

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
        Scanner entrada = new Scanner(System.in);
        System.out.print("\n--- Cadastro de Produto ---\n");
        System.out.print("informe o nome: ");
        nome = entrada.nextLine();

        System.out.print("informe o preço: ");
        preco = entrada.nextFloat();

        System.out.print("informe o custo: ");
        custo = entrada.nextFloat();

        System.out.print("informe o tipo: [(1) mecanica/ (2) estética]: ");
        resposta = entrada.nextInt();

        if (resposta == 1) {
            tipo = TipoProduto.MECANICA;
        } else {
            tipo = TipoProduto.ESTETICA;
        }

        Produto newProduto = new Produto(preco, custo, nome, tipo);
        produtos.add(newProduto);
    }

    public static Servico cadastrarServico() {
        /*
        Cria um novo serviço e adiciona ele na arraylist serviços
         */
        String nome, descricao;
        float preco, custo;
        Scanner entrada = new Scanner(System.in);
        System.out.print("\n--- Cadastro de Serviço ---\n");
        System.out.print("informe o nome: ");
        nome = entrada.nextLine();

        System.out.print("informe o preço: ");
        preco = entrada.nextFloat();

        System.out.print("informe o custo: ");
        custo = entrada.nextFloat();

        System.out.print("informe a descrição: ");
        descricao = entrada.nextLine();

        Servico newServico = new Servico(preco, custo, nome, descricao);
        servicos.add(newServico);
        return newServico;
    }
}
