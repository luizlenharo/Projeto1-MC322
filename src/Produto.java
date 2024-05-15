public class Produto extends Item{
    private int estoque=0;

    /* Construtor da classe Produto */
    public Produto(float preco, float custo, String nome){
        super(preco, custo, nome);
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
