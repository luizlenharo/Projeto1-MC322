import java.util.Scanner;

public class Main {
    private static void limparTela() {
        //System.out.print("\033[H\033[2J");
        //System.out.flush();
        for (int i = 0; i < 11; i++) {
            System.out.print("\n\n");
        }
    }

    private static void exibirProduto(Produto produto) {
        Scanner entrada = new Scanner(System.in);
        int opcao = -1;
        while (opcao != 0) { // Exibir os produtos
            limparTela();
            System.out.printf("\n--- %s ---\n",
                    produto.getNome());
            System.out.printf("- Preço: %f\n- Custo: %f\n- Estoque: %d\n- Tipo: %s\n",
                    produto.getPreco(), produto.getCusto(), produto.getEstoque(), produto.getTipo());

            System.out.print("(1) Repor estoque\n(2) Remover produto\n\n(0) Voltar\nSelecione: ");
            opcao = entrada.nextInt();

            switch (opcao) {
                case 0:
                    break;
                case 1:
                    int quantidade;
                    System.out.print("Insira a quantidade para adicionar: ");
                    quantidade = entrada.nextInt();
                    Mecanica.reporEstoque(produto, quantidade);
                    break;
                case 2:
                    Mecanica.getProdutos().remove(produto);
                    break;
                default:
                    System.out.println("Opcao invalida. Pressione [ENTER] e digite novamente.");
                    entrada.nextLine();
                    entrada.nextLine();
            }
        }
    }

    private static void produtos() {
        Scanner entrada = new Scanner(System.in);
        int opcao = -1;
        while (opcao != 0) {
            limparTela();
            System.out.print("\n--- Produtos ---\n");
            System.out.println("(1) Cadastrar novo produto");
            for (int i = 0; i < Mecanica.getProdutos().size(); i++) {
                System.out.printf("(%d) %s\n",
                        i + 2, Mecanica.getProdutos().get(i).getNome());
            }
            System.out.println("\n(0) Voltar\nSelecione: ");
            opcao = entrada.nextInt();

            switch (opcao) {
                case 0: break;
                case 1: limparTela(); Mecanica.cadastrarProduto(); break;
                default:
                    if (opcao - 2 < Mecanica.getProdutos().size())
                        exibirProduto(Mecanica.getProdutos().get(opcao-2));

                    else { // Se a opcao digitada nao esta no intervalo aceito, repete a operacao
                        System.out.println("Opcao invalida. Pressione [ENTER] e digite novamente.");
                        entrada.nextLine();
                        entrada.nextLine();
                    }
            }
        }
    }

    private static void exibirServico(Servico servico) {
        Scanner entrada = new Scanner(System.in);
        int opcao = -1;
        while (opcao != 0) {
            limparTela();
            System.out.printf("\n--- %s ---\n",
                    servico.getNome());
            System.out.printf("%s\n- Preço: %f\n- Custo: %f\n",
                    servico.getDescricao(), servico.getPreco(), servico.getCusto());
            System.out.print("(1) Remover servico\n\n(0) Voltar\nSelecione:");
            opcao = entrada.nextInt();
            switch (opcao) {
                case 0: break;
                case 1: Mecanica.getServicos().remove(servico); break;
                default:
                    System.out.println("Opcao invalida. Pressione [ENTER] e digite novamente.");
                    entrada.nextLine();
                    entrada.nextLine();
            }
        }
    }

    private static void servicos() {
        Scanner entrada = new Scanner(System.in);
        int opcao = -1;
        while (opcao != 0) {
            limparTela();
            System.out.print("\n--- Serviços ---\n");
            System.out.println("(1) Cadastrar servico");
            for (int i = 0; i < Mecanica.getServicos().size(); i++) {
                System.out.printf("(%d) %s\n",
                        i + 2, Mecanica.getServicos().get(i).getNome());
            }
            System.out.println("\n(0) Voltar\nSelecione: ");

            opcao = entrada.nextInt();

            switch (opcao) {
                case 0: break;
                case 1: limparTela(); Mecanica.cadastrarServico(); break;
                default:
                    if (opcao - 2 < Mecanica.getServicos().size())
                        exibirServico(Mecanica.getServicos().get(opcao-2));
                    else { // Se a opcao digitada nao esta no intervalo aceito, repete a operacao
                        System.out.println("Opcao invalida. Pressione [ENTER] e digite novamente.");
                        entrada.nextLine();
                        entrada.nextLine();
                    }
            }
        }
    }

    private static void exibirCliente(Cliente cliente) {
        Scanner entrada = new Scanner(System.in);
        int opcao = -1;
        while (opcao != 0) {
            limparTela();
            System.out.printf("\n--- %s ---\n", cliente.getNome());
            System.out.printf("- CPF: %s\n", cliente.getCpf());
            if (cliente.getPedidoAtual() != null) {
                System.out.printf("- Pedido atual: %s\n", cliente.getPedidoAtual().toString());
            }
            System.out.print("(1) Remover cliente\n\n(0) Voltar\nSelecione:");
            opcao = entrada.nextInt();

            switch (opcao) {
                case 0: break;
                case 1: Mecanica.getClientes().remove(cliente); break;
                default:
                    System.out.println("Opcao invalida. Pressione [ENTER] e digite novamente.");
                    entrada.nextLine();
                    entrada.nextLine();
            }
        }
    }

    private static void clientes() {
        Scanner entrada = new Scanner(System.in);
        int opcao = -1;
        while (opcao != 0) {
            limparTela();
            System.out.print("\n--- Clientes ---\n");
            System.out.println("(1) Cadastrar novo cliente");
            for (int i = 0; i < Mecanica.getClientes().size(); i++) {
                System.out.printf("(%d) %s\n",
                        i + 2, Mecanica.getClientes().get(i).getNome());
            }
            System.out.println("\n(0) Voltar\nSelecione: ");

            opcao = entrada.nextInt();

            switch (opcao) {
                case 0: break;
                case 1: limparTela(); Mecanica.cadastrarCliente(); break;
                default:
                    if (opcao - 2 < Mecanica.getClientes().size())
                        exibirCliente(Mecanica.getClientes().get(opcao-2));
                    else { // Se a opcao digitada nao esta no intervalo aceito, repete a operacao
                        System.out.println("Opcao invalida. Pressione [ENTER] e digite novamente.");
                        entrada.nextLine();
                        entrada.nextLine();
                    }
            }
        }
    }

    private static void novoPedido() {
        Scanner entrada = new Scanner(System.in);
        int opcao = -1;
        limparTela();
        while (opcao != 0) {
            System.out.print("\n--- Novo Pedido ---\n");

            if (Mecanica.getClientes().size() > 0) {
                System.out.println("Clientes atuais:");
                for (int i = 0; i < Mecanica.getClientes().size(); i++) {
                    System.out.printf("(%d) %s\n",
                            i + 1, Mecanica.getClientes().get(i).getNome());
                }
            }
            else
                System.out.println("Nao ha clientes cadastrados ainda");

            System.out.printf("\n(0) Voltar\nSelecione o cliente: ");
            opcao = entrada.nextInt();
            switch (opcao) {
                case 0: break;
                default:
                    if (opcao - 1 < Mecanica.getClientes().size())
                        Mecanica.getClientes().get(opcao-1).fazerPedido();
                    else { // Se a opcao digitada nao esta no intervalo aceito, repete a operacao
                        System.out.println("Opcao invalida. Pressione [ENTER] e digite novamente.");
                        entrada.nextLine();
                        entrada.nextLine();
                    }
            }
        }
    }

    private static void atualizarCaixa() {
        Scanner entrada = new Scanner(System.in);
        int opcao = -1;
        while (opcao != 0) {
            limparTela();
            System.out.print("\n--- Finanças ---\n");
            System.out.printf("Valor atual do caixa: R$ %.2f\n", Mecanica.getFinancas().getCaixa());
            System.out.println("(1) Adicionar um valor no caixa");
            System.out.println("(2) Subtrair um valor no caixa");
            System.out.println("(3) Definir o valor absoluto do caixa");
            System.out.println("(0) Voltar");

            opcao = entrada.nextInt();
            switch (opcao) {
                case 0: break;
                case 1:
                    System.out.println("Digite o valor para adicionar ao caixa: ");
                    Mecanica.getFinancas().setCaixa(Mecanica.getFinancas().getCaixa() + entrada.nextFloat());
                    break;
                case 2:
                    System.out.println("Digite o valor para subtrair ao caixa: ");
                    Mecanica.getFinancas().setCaixa(Mecanica.getFinancas().getCaixa() - entrada.nextFloat());
                    break;
                case 3:
                    System.out.println("Digite o novo valor para o caixa: ");
                    Mecanica.getFinancas().setCaixa(entrada.nextFloat());
                    break;
                default:
                    System.out.println("Opcao invalida. Pressione [ENTER] e digite novamente.");
                    entrada.nextLine();
                    entrada.nextLine();
            }
        }
    }

    private static void financas() {
        Scanner entrada = new Scanner(System.in);
        int opcao = -1;
        while (opcao != 0) {
            limparTela();
            System.out.print("\n--- Finanças ---\n");
            Financas financas = Mecanica.getFinancas();
            System.out.printf("- faturamento: %f\n- gastos: %f\n- caixa: %f\n- caixa em produtos: %f\n",
                    financas.getFaturamento(), financas.getGastos(), financas.getCaixa(), financas.getCaixaEmProdutos());
            System.out.print("(1) Resetar gastos e faturamentos\n");
            System.out.print("(2) Atualizar caixa\n");
            System.out.print("\n(0) Voltar\n");
            System.out.print("Selecione: ");
            opcao = entrada.nextInt();
            switch (opcao) {
                case 0: break;
                case 1: financas.reset(); break;
                case 2: atualizarCaixa(); break;
                default:
                    System.out.println("Opcao invalida. Pressione [ENTER] e digite novamente.");
                    entrada.nextLine();
                    entrada.nextLine();
            }
        }
    }

    public static void Menu() {
        int opcao = -1;
        Scanner entrada = new Scanner(System.in);
        while (opcao != 0) {
            limparTela();
            System.out.print("\n--- Mecânica ---\n");
            System.out.println("(1) Produtos");
            System.out.println("(2) Serviços");
            System.out.println("(3) Clientes");
            System.out.println("(4) Novo Pedido");
            System.out.println("(5) Visualizar Financas");
            System.out.println("\n(0) Sair");
            System.out.println("Escolha a opcao desejada: ");

            opcao = entrada.nextInt();
            switch(opcao) {
                case 0: break;
                case 1: produtos(); break;
                case 2: servicos(); break;
                case 3: clientes(); break;
                case 4: novoPedido(); break;
                case 5: financas(); break;
                default:
                    System.out.println("Opcao invalida. Pressione [ENTER] e digite novamente.");
                    entrada.nextLine();
                    entrada.nextLine();
            }
        }
    }

    public static void main(String[] args) {
        Menu();
    }
}