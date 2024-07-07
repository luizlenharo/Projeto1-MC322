public class Main {
    public static void main(String[] args) {
        JsonParser jp = new JsonParser();
        jp.carregarMecanicaDoJson();

        Interface menu = new Interface();
        menu.Frame();

        jp.salvarMecanicaParaJson();
    }
}