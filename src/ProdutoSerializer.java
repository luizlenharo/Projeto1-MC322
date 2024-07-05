import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class ProdutoSerializer extends StdSerializer<Produto> {

    public ProdutoSerializer() {
        this(null);
    }

    public ProdutoSerializer(Class<Produto> t) {
        super(t);
    }

    @Override
    public void serialize(Produto produto, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("custo", produto.getCusto());
        jsonGenerator.writeStringField("nome", produto.getNome());
        jsonGenerator.writeNumberField("estoque", produto.getEstoque());
        jsonGenerator.writeNumberField("preco", produto.getPreco());
        jsonGenerator.writeStringField("tipo", produto.getTipo().toString());
        jsonGenerator.writeEndObject();
    }
}
