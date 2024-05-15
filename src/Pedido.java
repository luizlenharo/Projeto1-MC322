import java.util.Hashtable;

public class Pedido {
    private Hashtable<Item, Integer> itemQuantidade;
    private float precoTotal;

    public Pedido(){
        this.precoTotal = 0;
    }

    public Hashtable<Item, Integer> getItemQuantidade() {
        return itemQuantidade;
    }

    public void setItemQuantidade(Hashtable<Item, Integer> itemQuantidade) {
        this.itemQuantidade = itemQuantidade;
    }

    public float getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(float precoTotal) {
        this.precoTotal = precoTotal;
    }
}
