public class Item {
    private float custo;
    private String nome;

    /* Construtor da classe Item */
    public Item(float custo, String nome){
        this.custo = custo;
        this.nome = nome;
    }

    /* Getters e Setter da classe */
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

    /* Retorna um preço base a partir do custo */
    public float calculaPreco(){
        return custo * 2;
    }
}
