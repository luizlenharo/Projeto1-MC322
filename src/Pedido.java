import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.lang.invoke.MutableCallSite;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;

public class Pedido {
    @JsonProperty("produtoQuantidade")
    @JsonDeserialize(keyUsing = ProdutoDeserializer.class)
    private Hashtable<Produto, Integer> produtoQuantidade;
    private ArrayList<Servico> servicos;
    private float precoTotal;


    public Pedido(){
        this.precoTotal = 0;
        this.produtoQuantidade = new Hashtable<Produto, Integer>();
        this.servicos = new ArrayList<Servico>();
    }

    public Hashtable<Produto, Integer> getProdutoQuantidade() {
        return produtoQuantidade;
    }

    public void setProdutoQuantidade(Hashtable<Produto, Integer> produtoQuantidade) {
        this.produtoQuantidade = produtoQuantidade;
    }

    public ArrayList<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(ArrayList<Servico> servicos) {
        this.servicos = servicos;
    }

    // Para usar com produtos
    public void adicionarItem(Produto item, int quantidade) {
        float precoItens;
        int quantidadeNova = quantidade;
        if (produtoQuantidade.get(item) != null)
            quantidadeNova = produtoQuantidade.get(item) + quantidade;
        produtoQuantidade.put(item, quantidadeNova);
        precoItens = quantidade*item.calculaPreco();
        precoTotal = precoTotal + precoItens;
        //Mecanica.getFinancas().setCaixaEmProdutos(Mecanica.getFinancas().getCaixaEmProdutos() - precoItens);
    }

    // Para usar com servicos, que nao têm quantidade
    public void adicionarItem(Servico item) {
        servicos.add(item);
        precoTotal += item.calculaPreco();
        //Mecanica.getFinancas().setGastos(Mecanica.getFinancas().getGastos() + item.getCusto());
        //Mecanica.getFinancas().setCaixa(Mecanica.getFinancas().getCaixa() - item.getCusto());
    }

    public void finalizarPedido() {
        Mecanica.getFinancas().setFaturamento(Mecanica.getFinancas().getFaturamento() + precoTotal);
        Mecanica.getFinancas().setCaixa(Mecanica.getFinancas().getCaixa() + precoTotal);
        Mecanica.getFinancas().setCaixaEmProdutos(Mecanica.getFinancas().getCaixaEmProdutos() - precoTotal);
    }
    public float getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(float precoTotal) {
        this.precoTotal = precoTotal;
    }

    @Override
    public String toString() {

        // Enumera os servicos, separados por virgulas
        String retorno = "Servicos:\n\t";
        for (Servico i: servicos)  {
            retorno += i.getNome();
            retorno += ", ";
        }
        // Verifica se ha algum servico no pedido
        if (!servicos.isEmpty())
            retorno = retorno.substring(0, retorno.length()-2); // Retira a ultima virgula e seu espaco
        else
            retorno += "Nao ha servicos no pedido";

        // Enumera os produtos e suas quantidades, separados por virgulas
        retorno += "\nProdutos:\n\t";
        for (Item i: Collections.list(produtoQuantidade.keys()))  {
            retorno += produtoQuantidade.get(i).toString() + " " + i.getNome() + "(s)";
            retorno += ", ";
        }
        // Verifica se ha produtos no pedido
        if (!produtoQuantidade.isEmpty())
            retorno = retorno.substring(0, retorno.length()-2); // Retira a ultima virgula e seu espaco
        else
            retorno += "Nao ha produtos no pedido";

        // Informa o subtotal do pedido na string
        retorno += String.format("\nPreco total: R$%.2f", precoTotal);

        return retorno;
    }
}
