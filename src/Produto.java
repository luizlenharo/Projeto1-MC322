import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

//@JsonSerialize(using = ProdutoSerializer.class)
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
        return super.calculaPreco() * ((float) 0.75);
    }

    /* Define como um objeto Produto deve ser printado */
    @Override
    public String toString(){
        String out = "";
        out += "Nome: " + getNome() + ",Preço: " + getPreco() + ",Custo: " + getCusto() + ",Estoque: " + getEstoque() + ",Tipo: " + getTipo();
        return out;
    }

    /*
    public String toJson() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(this);
        }
        catch(Exception e) {
            e.printStackTrace();
            throw new Exception("Erro ao converter produto para Json");
        }
    }
    */
}
