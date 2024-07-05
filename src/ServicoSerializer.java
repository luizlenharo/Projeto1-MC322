import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class ServicoSerializer extends StdSerializer<Servico> {

public ServicoSerializer() {
        this(null);
    }

    public ServicoSerializer(Class<Servico> t) {
        super(t);
    }

    @Override
    public void serialize(Servico servico, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("custo", servico.getCusto());
        jsonGenerator.writeStringField("nome", servico.getNome());
        jsonGenerator.writeStringField("descricao", servico.getDescricao());
        jsonGenerator.writeNumberField("preco", servico.getPreco());
        jsonGenerator.writeEndObject();
    }
}
