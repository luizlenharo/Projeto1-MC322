import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;

public class JsonParser {

    public static void salvarMecanicaParaJson() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        File f = new File("assets/mecanica.json");
        Servico s = new Servico(500, "Lavagem", "Lavagem do carro");
        Produto produto = new Produto(100, "Pneu", TipoProduto.MECANICA);
        Pedido p = new Pedido();
        p.adicionarItem(s);
        p.adicionarItem(produto, 1);
        Cliente c = new Cliente("43602354882", "Rafael");
        c.setPedidoAtual(p);
        try {
            objectMapper.writeValue(f, c);
            System.out.printf(objectMapper.writeValueAsString(c));
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void carregarMecanicaDoJson() {
        ObjectMapper objectMapper = new ObjectMapper();
        File f = new File("assets/mecanica.json");

        try {
            Cliente c = objectMapper.readValue(f, Cliente.class);
            System.out.println(c);
            System.out.println(c.getPedidoAtual().getProdutoQuantidade());
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
