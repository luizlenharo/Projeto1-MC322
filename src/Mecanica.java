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
        financas.setGastos(financas.getGastos() + custo);
        financas.setCaixaEmProdutos(financas.getCaixaEmProdutos() + (produto.calculaPreco() * quantidade));
        produto.setEstoque(produto.getEstoque() + quantidade);
        return true;
    }
}
