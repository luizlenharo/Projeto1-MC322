import java.util.ArrayList;
import java.util.Scanner;

public class Mecanica {
    private static ArrayList<Cliente> clientes;
    private static ArrayList<Produto> produtos;
    private static ArrayList<Servico> servicos;
    private static float caixa;

    //Geters e Seters

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

    public static float getCaixa() {
        return caixa;
    }

    public static void setCaixa(float caixa) {
        Mecanica.caixa = caixa;
    }

    public void reporEstoque(Produto produto, int quantidade) {

    }

    public Cliente cadastrarCliente() {
        String nome, cpf;
        Scanner entrada = new Scanner(System.in);
        System.out.print("--- Cadastro de Cliente ---\n\n");
        System.out.print("informe o nome: ");
        nome = entrada.nextLine();

        System.out.print("informe o cpf: ");
        cpf = entrada.nextLine();

        Cliente newCliente = new Cliente(cpf, nome);
        return newCliente;
    }

    public Produto cadatrarProduto() {
        String nome;
        float preco, custo;
        Scanner entrada = new Scanner(System.in);
        System.out.print("--- Cadastro de Produto ---\n\n");
        System.out.print("informe o nome: ");
        nome = entrada.nextLine();

        System.out.print("informe o preço: ");
        preco = entrada.nextFloat();

        System.out.print("informe o custo: ");
        custo = entrada.nextFloat();

        Produto newProduto = new Produto(preco, custo, nome);
        return newProduto;
    }

    public Servico cadastrarServico() {
        String nome, descricao;
        float preco, custo;
        Scanner entrada = new Scanner(System.in);
        System.out.print("--- Cadastro de Serviço ---\n\n");
        System.out.print("informe o nome: ");
        nome = entrada.nextLine();

        System.out.print("informe o preço: ");
        preco = entrada.nextFloat();

        System.out.print("informe o custo: ");
        custo = entrada.nextFloat();

        System.out.print("informe a descrição: ");
        descricao = entrada.nextLine();

        Servico newServico = new Servico(preco, custo, nome, descricao);
        return newServico;
    }
}
