import java.util.ArrayList;
import java.util.Scanner;

public class Cliente {
    private String cpf;
    private String nome;
    private Pedido pedidoAtual=null;

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

    public boolean fazerPedido(){
        this.pedidoAtual = new Pedido();
        int i=0, acao_p=0, acao_s = 0, selecionado=10;

        // Enquanto o cliente não finalizar o pedido, este menu se mantém
        while (selecionado != 0) {
            System.out.println("\nSelecione:\n (1) Produtos\n (2) Serviços\n (3) Carrinho\n (0) Finalizar pedido");
            selecionado = Leitor.lerInt();
            if (selecionado == 1) {
                System.out.println("\nSelecione o produto:");
                // Mostra todos os produtos disponíveis
                for (i = 0; i < Mecanica.getProdutos().size(); i++) {
                    System.out.printf("(%d) %s - R$%.2f\n", i+1, Mecanica.getProdutos().get(i).getNome(),
                            Mecanica.getProdutos().get(i).calculaPreco());
                }
                System.out.println("\n(0) Voltar");
                acao_p = Leitor.lerInt();
                // Caso ele selecione algum pedido
                if (acao_p != 0) {
                    Produto produto = Mecanica.getProdutos().get(acao_p - 1);
                    System.out.println("\nDigite a quantidade: ");
                    int quantidade = Leitor.lerInt();
                    // Verifica se há disponibilidade no estoque, se não houver ele não cria o pedido e volta ao menu inicial
                    if (quantidade > produto.getEstoque()) {
                        System.out.printf("Temos somente %d unidades desse produto", produto.getEstoque());
                        acao_p = 0;
                    }
                    else {
                        pedidoAtual.adicionarItem(produto, quantidade);
                        produto.setEstoque(produto.getEstoque() - quantidade);
                    }
                }
            } else if (selecionado == 2) {
                System.out.println("Selecione o serviço: ");
                // Mostra os serviços disponíveis
                for (i = 0; i < Mecanica.getServicos().size(); i++) {
                    System.out.printf("(%d) %s - R$%.2f\n", i+1, Mecanica.getServicos().get(i).getNome(),
                            Mecanica.getServicos().get(i).calculaPreco());
                }
                System.out.println("\n(0) Voltar");
                Servico servico =  Mecanica.getServicos().get(Leitor.lerInt() - 1);

                pedidoAtual.adicionarItem(servico);
            } else if (selecionado == 3) {
                System.out.print("\n--- Carrinho ---\n");
                System.out.println(pedidoAtual);
                System.out.print("---------------\n");
                System.out.print("Pressione [ENTER] para continuar. ");
                Leitor.esperarEnter();
            }
            else if (selecionado != 0){
                System.out.println("Opcao invalida. Pressione [ENTER] e digite novamente.");
                Leitor.esperarEnter();
            }
        }
        System.out.print("\n-----------\n");
        System.out.println("Pedido finalizado com os seguintes itens:");
        System.out.println(pedidoAtual);
        System.out.print("-----------\n");
        System.out.print("Pressione [ENTER] para continuar. ");
        Leitor.esperarEnter();
        Mecanica.getFinancas().setFaturamento(Mecanica.getFinancas().getFaturamento() + pedidoAtual.getPrecoTotal());
        Mecanica.getFinancas().setCaixa(Mecanica.getFinancas().getCaixa() + pedidoAtual.getPrecoTotal());
        return true;
    }
}
