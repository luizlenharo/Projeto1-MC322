import java.util.Scanner;

public class Main {
    public static void limparTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
//        for (int i = 0; i < 10; i++) {
//            System.out.print("\n\n");
//        }
    }

    public static void produtos() {
        Scanner entrada = new Scanner(System.in);
        int opcao;
        limparTela();
        while (true) {
            System.out.print("\n--- Produtos ---\n");
            System.out.println("(1) Cadastrar novo produto");
            for (int i = 0; i < Mecanica.getProdutos().size(); i++) {
                System.out.printf("(%d) %s\n",
                        i + 2, Mecanica.getProdutos().get(i).getNome());
            }
            System.out.println("\n(0) Voltar\nSelecione: ");

            opcao = entrada.nextInt();
            if (opcao == 0) {
                break;
            } else if (opcao == 1) { //Cadastrar Produto
                Mecanica.cadastrarProduto();
            } else {  //Produto n
                while (true) { // Exibir os produtos
                    Produto produto = Mecanica.getProdutos().get(opcao - 2);
                    System.out.printf("\n--- %s ---\n",
                            produto.getNome());
                    System.out.printf("- Preço: %f\n- Custo: %f\n- Estoque: %d\n- Tipo: %s\n",
                            produto.getPreco(), produto.getCusto(), produto.getEstoque(), produto.getTipo());

                    System.out.print("(1) Repor estoque\n(2) Remover produto\n\n(0) Voltar\nSelecione: ");
                    opcao = entrada.nextInt();
                    if (opcao == 0) {
                        break;
                    } else if (opcao == 1) { //Repor estoque
                        int quantidade;
                        System.out.print("Insira a quantidade para adicionar: ");
                        quantidade = entrada.nextInt();
                        Mecanica.reporEstoque(produto, quantidade);
                    } else if (opcao == 2) {
                        Mecanica.getProdutos().remove(produto);
                        break;
                    }
                }
            }
        }
    }

    public static void servicos() {
        Scanner entrada = new Scanner(System.in);
        int opcao;
        while (true) {
            System.out.print("\n--- Serviços ---\n");
            for (int i = 0; i < Mecanica.getServicos().size(); i++) {
                System.out.printf("(%d) %s\n",
                        i + 1, Mecanica.getServicos().get(i).getNome());
            }
            System.out.printf("(%d) Cadastrar serviço\n\n(0) Voltar\nSelecione: ",
                    Mecanica.getServicos().size() + 1);
            opcao = entrada.nextInt();
            if (opcao == 0) {
                break;
            } else if (opcao == Mecanica.getServicos().size() + 1) { //Cadastrar Serviço
                Mecanica.cadastrarServico();
            } else {  //Serviço n
                while (true) {
                    Servico servico = Mecanica.getServicos().get(opcao - 1);
                    System.out.printf("\n--- %s ---\n",
                            servico.getNome());
                    System.out.printf("- Preço: %f\n- Custo: %f\n",
                            servico.getPreco(), servico.getCusto());
                    System.out.print("(1) Remover serviço\n\n(0) Voltar\nSelecione:");
                    opcao = entrada.nextInt();
                    if (opcao == 0) {
                        break;
                    } else if (opcao == 1) {  //Remover serviço
                        Mecanica.getServicos().remove(servico);
                        break;
                    }
                }
            }
        }
    }

    public static void clientes() {
        Scanner entrada = new Scanner(System.in);
        int opcao;
        while (true) {
            System.out.print("\n--- Clientes ---\n");
            for (int i = 0; i < Mecanica.getClientes().size(); i++) {
                System.out.printf("(%d) %s\n",
                        i + 1, Mecanica.getClientes().get(i).getNome());
            }
            System.out.printf("(%d) Cadastrar cliente\n\n(0) Voltar\nSelecione: ",
                    Mecanica.getClientes().size() + 1);
            opcao = entrada.nextInt();
            if (opcao == 0) {
                break;
            } else if (opcao == Mecanica.getClientes().size() + 1) {  //Cadastrar Clientes
                Mecanica.cadastrarCliente();
            } else {  //Cliente n
                while (true) {
                    Cliente cliente = Mecanica.getClientes().get(opcao - 1);
                    System.out.printf("\n--- %s ---\n",
                            cliente.getNome());
                    System.out.printf("- CPF: %s\n", cliente.getCpf());
                    if (cliente.getPedidoAtual() != null) {
                        System.out.printf("- Pedido: %s\n", cliente.getPedidoAtual().toString());
                    }
                    System.out.print("(1) Remover cliente\n\n(0) Voltar\nSelecione:");
                    opcao = entrada.nextInt();
                    if (opcao == 0) {
                        break;
                    } else if (opcao == 1) {  //Remover cliente
                        Mecanica.getClientes().remove(cliente);
                        break;
                    }
                }
            }
        }
    }

    public static void novoPedido() {
        Scanner entrada = new Scanner(System.in);
        int opcao;
        while (true) {
            System.out.print("\n--- Novo Pedido ---\n");
            for (int i = 0; i < Mecanica.getClientes().size(); i++) {
                System.out.printf("(%d) %s\n",
                        i + 1, Mecanica.getClientes().get(i).getNome());
            }
            System.out.printf("\n(0) Voltar\nSelecione o cliente: ",
                    Mecanica.getClientes().size() + 1);
            opcao = entrada.nextInt();
            if (opcao == 0) {
                break;
            } else {  //Cliente n
                Mecanica.getClientes().get(opcao - 1).fazerPedido();
                break;
            }
        }
    }

    public static void financas() {
        Scanner entrada = new Scanner(System.in);
        int opcao;
        System.out.print("\n--- Finanças ---\n");
        Financas financas = Mecanica.getFinancas();
        System.out.printf("- faturamento: %f\n- gastos: %f\n- caixa: %f\n\n",
                financas.getFaturamento(), financas.getGastos(), financas.getCaixa());
        System.out.print("Pressione qualquer tecla para continuar. ");
        entrada.nextLine();
    }

    public static void Menu() {
        int opcao = -1;
        Scanner entrada = new Scanner(System.in);
        while (opcao != 0) {
            System.out.print("\n--- Mecânica ---\n");
            System.out.println("(0) Sair");
            System.out.println("(1) Produtos");
            System.out.println("(2) Serviços");
            System.out.println("(3) Clientes");
            System.out.println("(4) Novo Pedido");
            System.out.println("(5) Visualizar Financas");
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
                    System.out.println("Opcao invalida. Escolha novamente.");
            }
        }
    }

    public static void main(String[] args) {
        Menu();
    }
}