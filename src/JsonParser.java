import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.util.ArrayList;

public class JsonParser {
    private final ObjectMapper mapper;

    public JsonParser() {
        mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    public void salvarMecanicaParaJson() {
        File arquivoClientes = new File("assets/clientes.json");
        File arquivoProdutos = new File("assets/produtos.json");
        File arquivoServicos = new File("assets/servicos.json");
        File arquivoFinancas = new File("assets/financas.json");
        try {
            mapper.writeValue(arquivoClientes, Mecanica.getClientes());
            mapper.writeValue(arquivoProdutos, Mecanica.getProdutos());
            mapper.writeValue(arquivoServicos, Mecanica.getServicos());
            mapper.writeValue(arquivoFinancas, Mecanica.getFinancas());
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void carregarMecanicaDoJson() {
        File arquivoClientes = new File("assets/clientes.json");
        File arquivoProdutos = new File("assets/produtos.json");
        File arquivoServicos = new File("assets/servicos.json");
        File arquivoFinancas = new File("assets/financas.json");
        try {
            Mecanica.setClientes(mapper.readValue(arquivoClientes, new TypeReference<ArrayList<Cliente>>(){}));
            Mecanica.setProdutos(mapper.readValue(arquivoProdutos, new TypeReference<ArrayList<Produto>>(){}));
            Mecanica.setServicos(mapper.readValue(arquivoServicos, new TypeReference<ArrayList<Servico>>(){}));
            Mecanica.setFinancas(mapper.readValue(arquivoFinancas, Financas.class));
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
