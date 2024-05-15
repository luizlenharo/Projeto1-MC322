import java.util.Scanner;

public class Main {
    public static void Menu(){
        int resposta;
        Scanner entrada = new Scanner(System.in);
        System.out.print("--- Mecânica ---\n");
        System.out.print("(1) Produtos\n(2) Serviços\n(3) Clientes\n" +
                "(4) Novo Pedido\n\n(0) Sair\nSelecione: ");
        resposta = entrada.nextInt();
        while (true) {
            if (resposta == 0) {
                break;
            } else if (resposta == 1) { //Produtos
                while (true) {
                    System.out.print("--- Produtos ---\n");
                    for (int i = 0; i < Mecanica.getProdutos().size(); i++) {
                        System.out.printf("(%d) %s",
                                i+1, Mecanica.getProdutos().get(i).getNome());
                    }
                    System.out.printf("(%d) Cadastrar produto\n\n(0) Voltar\nSelecione: ",
                            Mecanica.getProdutos().size() + 1);
                    resposta = entrada.nextInt();
                    if (resposta == 0){
                        break;
                    } else if (resposta == Mecanica.getProdutos().size()+1) { //Cadastrar Produto
                        Mecanica.cadastrarProduto();
                    } else {
                        while (true) {
                            System.out.printf("--- %s ---",
                                    Mecanica.getProdutos().get(resposta - 1).getNome());
                            System.out.printf("- %f\n- %f\n- %d");
                        }
                    }
                }
            }
        }
    }
    public static void main(String[] args) {

    }
}