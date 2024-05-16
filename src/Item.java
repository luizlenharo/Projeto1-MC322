public class Item {
    private float preco;
    private float custo;
    private String nome;

    /* Construtor da classe Item */
    public Item(float custo, String nome){
        this.custo = custo;
        this.nome = nome;
        this.preco = 0;
    }

    /* Getters e Setter da classe */
    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public float getCusto() {
        return custo;
    }

    public void setCusto(float custo) {
        this.custo = custo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float calculaPreco(){
        return this.custo * 2;
    }
}
