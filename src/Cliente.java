import com.fasterxml.jackson.annotation.JsonProperty;

public class Cliente {
    private String cpf;
    private String nome;
    @JsonProperty("pedido")
    private Pedido pedidoAtual = null;

    public Cliente(){}

    //Construtor do Cliente
    public Cliente(String cpf, String nome){
        this.cpf = cpf;
        this.nome = nome;
    }

    //Getters e Setters
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Pedido getPedidoAtual() {
        return pedidoAtual;
    }

    public void setPedidoAtual(Pedido pedidoAtual) {
        this.pedidoAtual = pedidoAtual;
    }
}
