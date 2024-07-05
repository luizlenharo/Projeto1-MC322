import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

//@JsonSerialize(using=ServicoSerializer.class)
public class Servico extends Item{
    private String descricao;
    private float preco;

    public Servico() {
        super();
    }

    /* Construtor da classe Servico */
    public Servico(float custo, String nome, String descricao){
        super(custo, nome);
        this.preco = 0;
        this.descricao = descricao;
    }

    /* Getters e Setters da classe */
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    /* Retorna o preco de um serviço com base no custo */
    public float calculaPreco(){
        return super.calculaPreco() * ((float) 1.25);
    }

    /* Define como um objeto Servico deve ser printado */
    public String toString(){
        String out = " ";
        out += "Nome: " + getNome() + ",Preço: " + getPreco() + ",Custo: " + getCusto();
        return out;
    }
}
