public class Produto extends Item{
    private int estoque;
    private float preco;
    private TipoProduto tipo;

    /* Construtor da classe Produto */
    public Produto(float custo, String nome, TipoProduto tipo){
        super(custo, nome);
        this.tipo = tipo;
        this.preco = 0;
        this.estoque = 0;
    }

    /* Getters e Setters da classe */
    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public TipoProduto getTipo() {
        return tipo;
    }

    public void setTipo(TipoProduto tipo) {
        this.tipo = tipo;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    /* Retorna o preco de um produto com base no custo */
    public float calculaPreco(){
        return super.calculaPreco() * ((float) 1.25);
    }

    /* Define como um objeto Produto deve ser printado */
    public String toString(){
        String out = " ";
        out += "Nome: " + getNome() + ",Preço: " + getPreco() + ",Custo: " + getCusto() + ",Estoque: " + getEstoque() + ",Tipo: " + getTipo();
        return out;
    }
}
