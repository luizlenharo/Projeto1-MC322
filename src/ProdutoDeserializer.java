import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.io.IOException;

public class ProdutoDeserializer extends KeyDeserializer {
    @Override
    public Produto deserializeKey(String key, DeserializationContext ctxt) throws IOException {
//        key = key.substring(key.indexOf(' ')+1);
//        String nome = key.substring(0, key.indexOf(','));
//        System.out.println(nome);

        return new Produto(0,"teste",TipoProduto.MECANICA);
//        return new MyPair(key);
    }
}
