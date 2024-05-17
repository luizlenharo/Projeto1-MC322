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
        if (itemQuantidade.get(item) != null)
            quantidade += itemQuantidade.get(item);
        itemQuantidade.put(item, quantidade);
        precoTotal = precoTotal + quantidade*item.calculaPreco();
    }

    // Para usar com servicos, que nao têm quantidade
    public void adicionarItem(Item item) {
        itemQuantidade.put(item, 0);
    }

    public float getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(float precoTotal) {
        this.precoTotal = precoTotal;
    }

    @Override
    public String toString() {
        float precoTotal = 0;

        String retorno = "Servicos:\n\t";
        boolean haServicos = false;
        for (Item i: Collections.list(itemQuantidade.keys()))  {
            if (i.getClass() == Servico.class) {
                haServicos = true;
                retorno += i.getNome();
                retorno += ", ";
                precoTotal += ((Servico) i).getPreco();
            }
        }
        if (haServicos)
            retorno = retorno.substring(0, retorno.length()-2); // Retura a ultima virgula e seu espaco
        else
            retorno += "Nao ha servicos no pedido";

        retorno += "\nProdutos:\n\t";
        boolean haProdutos = false;
        for (Item i: Collections.list(itemQuantidade.keys()))  {
            if (i.getClass() == Produto.class) {
                haProdutos = true;
                retorno += itemQuantidade.get(i).toString() + " " + i.getNome() + "(s)";
                retorno += ", ";
                precoTotal += ((Produto) i).getPreco() * itemQuantidade.get(i);
            }
        }
        if (haProdutos)
            retorno = retorno.substring(0, retorno.length()-2); // Retura a ultima virgula e seu espaco
        else
            retorno += "Nao ha produtos no pedido";


        retorno += String.format("\nPreco total: R$ %.2f", precoTotal);


        return retorno;
    }
}
