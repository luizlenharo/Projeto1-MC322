import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.io.IOException;

public class ProdutoDeserializer extends KeyDeserializer {
    @Override
    public Produto deserializeKey(String key, DeserializationContext ctxt) throws IOException {
        key = key.substring(key.indexOf(' ')+1);
        String nome = key.substring(0, key.indexOf(','));
        key = key.substring(key.indexOf(' ')+1);
        Float preco = Float.parseFloat(key.substring(0, key.indexOf(',')));
        key = key.substring(key.indexOf(' ')+1);
        Float custo = Float.parseFloat(key.substring(0, key.indexOf(',')));
        key = key.substring(key.indexOf(' ')+1);
        Integer estoque = Integer.parseInt(key.substring(0, key.indexOf(',')));
        key = key.substring(key.indexOf(' ')+1);
        String tipo = key;
        TipoProduto tipoEnum;

        if (tipo.toLowerCase().equals("mecanica"))
            tipoEnum = TipoProduto.MECANICA;
        else if (tipo.toLowerCase().equals("estetica"))
            tipoEnum = TipoProduto.MECANICA;
        else
            throw new IOException("Tipo incorreto");

        return new Produto(custo, nome, tipoEnum, preco, estoque);
    }
}
