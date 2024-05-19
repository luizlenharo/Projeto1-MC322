import java.util.Scanner;

public class Leitor {
    private static final Scanner entrada = new Scanner(System.in);

    public static void esperarEnter() {
        entrada.nextLine(); // Reseta o buffer
        entrada.nextLine();
    }

    public static String lerLinha() {
        String retorno = entrada.nextLine(); // Reseta o buffer
        if (retorno.length() > 0)
            return retorno;

        while (true) {
            try {
                retorno = entrada.nextLine();
                break;
            }
            catch(Exception e) {
                System.out.println("O valor digitado deve ser uma string. Digite novamente: ");
            }
            entrada.nextLine(); // Reseta o buffer
        }
        return retorno;
    }

    public static int lerInt() {
        int retorno;
        while (true) {
            try {
                retorno = entrada.nextInt();
                break;
            }
            catch(Exception e) {
                System.out.println("O valor digitado deve ser um inteiro. Digite novamente: ");
            }
            entrada.nextLine(); // Reseta o buffer
        }
        return retorno;
    }

    public static float lerFloat() {
        float retorno;
        while (true) {
            try {
                retorno = entrada.nextFloat();
                break;
            }
            catch(Exception e) {
                System.out.println("O valor digitado deve ser um float. Digite novamente: ");
            }
            entrada.nextLine(); // Reseta o buffer
        }
        return retorno;
    }
}
