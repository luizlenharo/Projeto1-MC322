import java.util.Collections;
import java.util.Hashtable;

public class Pedido {
    private Hashtable<Item, Integer> itemQuantidade;
    private float precoTotal;

    public Pedido(){
        this.precoTotal = 0;
        this.itemQuantidade = new Hashtable<Item, Integer>();
    }

    public Hashtable<Item, Integer> getItemQuantidade() {
        return itemQuantidade;
    }

    public void setItemQuantidade(Hashtable<Item, Integer> itemQuantidade) {
        this.itemQuantidade = itemQuantidade;
    }

    // Para usar com produtos
    public void adicionarItem(Item item, int quantidade) {
        float precoItens;
        if (itemQuantidade.get(item) != null)
            quantidade += itemQuantidade.get(item);
        itemQuantidade.put(item, quantidade);
        precoItens = quantidade*item.calculaPreco();
        precoTotal = precoTotal + precoItens;
        Mecanica.getFinancas().setCaixaEmProdutos(Mecanica.getFinancas().getCaixaEmProdutos() - precoItens);
    }

    // Para usar com servicos, que nao têm quantidade
    public void adicionarItem(Item item) {
        itemQuantidade.put(item, 0);
        precoTotal = precoTotal + item.calculaPreco();
        Mecanica.getFinancas().setGastos(Mecanica.getFinancas().getGastos() + item.getCusto());
        Mecanica.getFinancas().setCaixa(Mecanica.getFinancas().getCaixa() - item.getCusto());
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
        boolean haServicos = false;
        for (Item i: Collections.list(itemQuantidade.keys()))  {
            if (i.getClass() == Servico.class) {
                haServicos = true;
                retorno += i.getNome();
                retorno += ", ";
            }
        }
        // Verifica se ha algum servico no pedido
        if (haServicos)
            retorno = retorno.substring(0, retorno.length()-2); // Retira a ultima virgula e seu espaco
        else
            retorno += "Nao ha servicos no pedido";

        // Enumera os produtos e suas quantidades, separados por virgulas
        retorno += "\nProdutos:\n\t";
        boolean haProdutos = false;
        for (Item i: Collections.list(itemQuantidade.keys()))  {
            if (i.getClass() == Produto.class) {
                haProdutos = true;
                retorno += itemQuantidade.get(i).toString() + " " + i.getNome() + "(s)";
                retorno += ", ";
            }
        }
        // Verifica se ha produtos no pedido
        if (haProdutos)
            retorno = retorno.substring(0, retorno.length()-2); // Retira a ultima virgula e seu espaco
        else
            retorno += "Nao ha produtos no pedido";

        // Informa o subtotal do pedido na string
        retorno += String.format("\nPreco total: R$%.2f", precoTotal);

        return retorno;
    }
}
