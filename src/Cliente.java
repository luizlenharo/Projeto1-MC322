import java.util.ArrayList;
import java.util.Scanner;

public class Cliente {
    private String cpf;
    private String nome;
    private Pedido pedidoAtual=null;

    public Cliente(String cpf, String nome){
        this.cpf = cpf;
        this.nome = nome;
    }

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

    public boolean fazerPedido(){
        int i=0, acao_p=0, acao_s = 0, selecionado=10;
        Scanner scanner = new Scanner(System.in);
        while (selecionado != 0) {
            System.out.println("Selecione:\n (1) Produtos\n (2) Serviços\n (0) Voltar");
            selecionado = scanner.nextInt();
            if (selecionado == 1) {
                System.out.println("Selecione o produto:");
                for (i = 0; i < Mecanica.getProdutos().size(); i++) {
                    System.out.println("(" + (i + 1) + ") " + Mecanica.getProdutos().get(i).getNome());
                }
                System.out.println("(0) Voltar");
                acao_p = scanner.nextInt();
                if (acao_p != 0) {
                    System.out.println("Digite a quantidade: ");
                    int quantidade = scanner.nextInt();
                    if (quantidade > Mecanica.getProdutos().get(acao_p - 1).getEstoque()) {
                        System.out.println("Sem estoque");
                        acao_p = 0;
                    }
                    Pedido newPedido = new Pedido(Mecanica.getProdutos().get(acao_p-1).getNome(), quantidade);
                }
            } else if (selecionado == 2) {
                System.out.println("Selecione o serviço: ");
                for (i = 0; i < Mecanica.getServicos().size(); i++) {
                    System.out.println("(" + (i + 1) + ") " + Mecanica.getProdutos().get(i).getNome());
                }
                System.out.println("(0) Voltar");
                acao_s = scanner.nextInt();
                Pedido newPedido = new Pedido(Mecanica.getServicos().get(acao_s-1).getNome(), 0);
            }
        }

        //acao_p-1 indice do produto, acao_s indice do serviço

        return true;
    }
}
