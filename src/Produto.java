public class Produto extends Item{
    private int estoque;
    private TipoProduto tipo;

    /* Construtor da classe Produto */
    public Produto(float preco, float custo, String nome, TipoProduto tipo){
        super(preco, custo, nome);
        this.tipo = tipo;
        estoque = 0;
    }

    /* Getters e Setters da classe */
    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    /* Define como um objeto Produto deve ser printado */
    public String toString(){
        String out = " ";
        out += "Nome: " + getNome() + ",Preço: " + getPreco() + ",Custo: " + getCusto() + ",Estoque: " + getEstoque();
        return out;
    }
}
