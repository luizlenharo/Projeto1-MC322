import java.util.ArrayList;

public class Cliente {
    private int cpf;
    private String nome;
    private Pedido pedidoAtual=null;

    public Cliente(int cpf, String nome){
        this.cpf = cpf;
        this.nome = nome;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
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

    public boolean fazerPedido(){
        return true;
    }
}
