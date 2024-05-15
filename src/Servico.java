public class Servico extends Item{
    private String descricao;

    /* Construtor da classe Servico */
    public Servico(float preco, float custo, String nome, String descricao){
        super(preco, custo, nome);
        this.descricao = descricao;
    }

    /* Getters e Setters da classe */
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /* Define como um objeto Servico deve ser printado */
    public String toString(){
        String out = " ";
        out += "Nome: " + getNome() + ",Preço: " + getPreco() + ",Custo: " + getCusto();
        return out;
    }
}
