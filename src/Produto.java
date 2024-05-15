public class Produto extends Item{
    private int estoque=0;

    public Produto(float preco, float custo, String nome){
        super(preco, custo, nome);
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public String toString(){
        String out = " ";
        out += "Nome: " + getNome() + ",Preço: " + getPreco() + ",Custo: " + getCusto() + ",Estoque: " + getEstoque();
        return out;
    }
}
