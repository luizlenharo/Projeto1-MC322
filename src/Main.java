import java.util.Scanner;

public class Main {
    public static void limparTela() {
        for (int i = 0; i < 10; i++) {
            System.out.print("\n\n");
        }
    }

    public static void Menu() {
        int resposta;
        Scanner entrada = new Scanner(System.in);
        while (true) {
            System.out.print("\n--- Mecânica ---\n");
            System.out.print("(1) Produtos\n(2) Serviços\n(3) Clientes\n" +
                    "(4) Novo Pedido\n(5) Finanças\n\n(0) Sair\nSelecione: ");
            resposta = entrada.nextInt();
            if (resposta == 0) {
                break;
            } else if (resposta == 1) {  //Produtos
                limparTela();
                while (true) {
                    System.out.print("\n--- Produtos ---\n");
                    for (int i = 0; i < Mecanica.getProdutos().size(); i++) {
                        System.out.printf("(%d) %s\n",
                                i + 1, Mecanica.getProdutos().get(i).getNome());
                    }
                    System.out.printf("(%d) Cadastrar produto\n\n(0) Voltar\nSelecione: ",
                            Mecanica.getProdutos().size() + 1);
                    resposta = entrada.nextInt();
                    if (resposta == 0) {
                        break;
                    } else if (resposta == Mecanica.getProdutos().size() + 1) { //Cadastrar Produto
                        Mecanica.cadastrarProduto();
                    } else {  //Produto n
                        while (true) {
                            Produto produto = Mecanica.getProdutos().get(resposta - 1);
                            System.out.printf("\n--- %s ---\n",
                                    produto.getNome());
                            System.out.printf("- Preço: %f\n- Custo: %f\n- Estoque: %d\n- Tipo: %s\n",
                                    produto.getPreco(), produto.getCusto(), produto.getEstoque(), produto.getTipo());
                            System.out.print("(1) Repor estoque\n(2) Remover produto\n\n(0) Voltar\nSelecione: ");
                            resposta = entrada.nextInt();
                            if (resposta == 0) {
                                break;
                            } else if (resposta == 1) { //Repor estoque
                                int quantidade;
                                System.out.print("Insira a quantidade para adicionar: ");
                                quantidade = entrada.nextInt();
                                Mecanica.reporEstoque(produto, quantidade);
                            } else if (resposta == 2) {
                                Mecanica.getProdutos().remove(produto);
                                break;
                            }
                        }
                    }
                }
            } else if (resposta == 2) {  //Serviços
                while (true) {
                    System.out.print("\n--- Serviços ---\n");
                    for (int i = 0; i < Mecanica.getServicos().size(); i++) {
                        System.out.printf("(%d) %s\n",
                                i + 1, Mecanica.getServicos().get(i).getNome());
                    }
                    System.out.printf("(%d) Cadastrar serviço\n\n(0) Voltar\nSelecione: ",
                            Mecanica.getServicos().size() + 1);
                    resposta = entrada.nextInt();
                    if (resposta == 0) {
                        break;
                    } else if (resposta == Mecanica.getServicos().size() + 1) { //Cadastrar Serviço
                        Mecanica.cadastrarServico();
                    } else {  //Serviço n
                        while (true) {
                            Servico servico = Mecanica.getServicos().get(resposta - 1);
                            System.out.printf("\n--- %s ---\n",
                                    servico.getNome());
                            System.out.printf("- Preço: %f\n- Custo: %f\n",
                                    servico.getPreco(), servico.getCusto());
                            System.out.print("(1) Remover serviço\n\n(0) Voltar\nSelecione:");
                            resposta = entrada.nextInt();
                            if (resposta == 0) {
                                break;
                            } else if (resposta == 1) {  //Remover serviço
                                Mecanica.getServicos().remove(servico);
                                break;
                            }
                        }
                    }
                }
            } else if (resposta == 3) {  //Clientes
                while (true) {
                    System.out.print("\n--- Clientes ---\n");
                    for (int i = 0; i < Mecanica.getClientes().size(); i++) {
                        System.out.printf("(%d) %s\n",
                                i + 1, Mecanica.getClientes().get(i).getNome());
                    }
                    System.out.printf("(%d) Cadastrar cliente\n\n(0) Voltar\nSelecione: ",
                            Mecanica.getClientes().size() + 1);
                    resposta = entrada.nextInt();
                    if (resposta == 0) {
                        break;
                    } else if (resposta == Mecanica.getClientes().size() + 1) {  //Cadastrar Clientes
                        Mecanica.cadastrarCliente();
                    } else {  //Cliente n
                        while (true) {
                            Cliente cliente = Mecanica.getClientes().get(resposta - 1);
                            System.out.printf("\n--- %s ---\n",
                                    cliente.getNome());
                            System.out.printf("- CPF: %s\n", cliente.getCpf());
                            if (cliente.getPedidoAtual() != null) {
                                System.out.printf("- Pedido: %s\n", cliente.getPedidoAtual().toString());
                            }
                            System.out.print("(1) Remover cliente\n\n(0) Voltar\nSelecione:");
                            resposta = entrada.nextInt();
                            if (resposta == 0) {
                                break;
                            } else if (resposta == 1) {  //Remover cliente
                                Mecanica.getClientes().remove(cliente);
                                break;
                            }
                        }
                    }
                }
            } else if (resposta == 4) {
                while (true) {
                    System.out.print("\n--- Novo Pedido ---\n");
                    for (int i = 0; i < Mecanica.getClientes().size(); i++) {
                        System.out.printf("(%d) %s\n",
                                i + 1, Mecanica.getClientes().get(i).getNome());
                    }
                    System.out.printf("\n(0) Voltar\nSelecione o cliente: ",
                            Mecanica.getClientes().size() + 1);
                    resposta = entrada.nextInt();
                    if (resposta == 0) {
                        break;
                    } else {  //Cliente n
                        Mecanica.getClientes().get(resposta - 1).fazerPedido();
                        break;
                    }
                }
            } else if (resposta == 5) {
                while (true) {
                    System.out.print("\n--- Finanças ---\n");
                    Financas financas = Mecanica.getFinancas();
                    System.out.printf("- faturamento: %f\n- gastos: %f\n- caixa: %f\n\n",
                            financas.getFaturamento(), financas.getGastos(), financas.getCaixa());
                    System.out.print("(0) Voltar\nSelecione: ");
                    resposta = entrada.nextInt();
                    if (resposta == 0) {
                        break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Menu();
    }
}