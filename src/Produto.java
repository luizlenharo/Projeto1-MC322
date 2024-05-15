public class Produto extends Item{
    private int estoque;

    public Produto(float preco, float custo, String nome, int estoque){
        super(preco, custo, nome);
        this.estoque = estoque;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public String toString(){
        String out = " ";
        return out;
    }
}
