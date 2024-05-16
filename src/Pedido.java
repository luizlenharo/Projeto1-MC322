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

    public void adicionarItem(Item item, int quantidade) {
        if (itemQuantidade.get(item) != null)
            quantidade += itemQuantidade.get(item);
        itemQuantidade.put(item, quantidade);
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
        String retorno = "Servicos:\n";
        for (Item i: Collections.list(itemQuantidade.keys()))  {
            if (i.getClass() == Servico.class)
                retorno += i.getNome();
            retorno += ", ";
        }
        retorno = retorno.substring(0, retorno.length()-2); // Retura a ultima virgula e seu espaco

        retorno += "\nProdutos:\n";
        for (Item i: Collections.list(itemQuantidade.keys()))  {
            if (i.getClass() == Produto.class)
                retorno += itemQuantidade.get(i).toString() + " " + i.getNome() + "(s)";
                //         Quantidade do produto                    Nome do produto
            retorno += ", ";
        }
        retorno = retorno.substring(0, retorno.length()-2); // Retura a ultima virgula e seu espaco
        retorno += "\n";

        return retorno;
    }
}
