package cl.mercadopublico.poc.oracle.ordencompra.json.deserializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import cl.mercadopublico.poc.oracle.ordencompra.message.response.GenerarOrdenCompraResponse;

public class OrdenCompraResponseDeserializer extends StdDeserializer<GenerarOrdenCompraResponse> {

	private static final long serialVersionUID = 5760783598721201554L;

	public OrdenCompraResponseDeserializer() {
		this(null);
	}

	public OrdenCompraResponseDeserializer(Class<?> vc) {
		super(vc);
	}

	@Override
	public GenerarOrdenCompraResponse deserialize(JsonParser parser, DeserializationContext deserializer)
			throws IOException, JsonProcessingException {
		GenerarOrdenCompraResponse response = null;

		try {
			if (parser.getCurrentToken() != JsonToken.START_OBJECT) {
				throw new IOException("invalid start marker");
			}
			response = new GenerarOrdenCompraResponse();
			while (parser.nextToken() != JsonToken.END_OBJECT) {
				String fieldname = parser.getCurrentName();
				parser.nextToken(); // move to next token in string
				if ("FechaRespuesta".equals(fieldname)) {
					response.setFechaRespuesta(parser.getText());
				} else if ("CodigoRespuesta".equals(fieldname)) {
					response.setCodigoRespuesta(parser.getText());
				} else if ("Respuesta".equals(fieldname)) {
					response.setRespuesta(parser.getText());
				} else if ("Url".equals(fieldname)) {
					response.setUrl(parser.getText());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			response = null;
		}
		return response;
	}

}
