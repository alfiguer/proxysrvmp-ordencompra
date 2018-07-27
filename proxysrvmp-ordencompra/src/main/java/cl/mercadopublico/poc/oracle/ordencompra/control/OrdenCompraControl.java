package cl.mercadopublico.poc.oracle.ordencompra.control;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import cl.mercadopublico.poc.oracle.ordencompra.domain.Estado;
import cl.mercadopublico.poc.oracle.ordencompra.domain.OrdenCompra;
import cl.mercadopublico.poc.oracle.ordencompra.domain.Producto;
import cl.mercadopublico.poc.oracle.ordencompra.json.deserializer.OrdenCompraResponseDeserializer;
import cl.mercadopublico.poc.oracle.ordencompra.json.serializer.OrdenCompraSerializer;
import cl.mercadopublico.poc.oracle.ordencompra.message.request.GenerarOrdenCompraRequest;
import cl.mercadopublico.poc.oracle.ordencompra.message.response.GenerarOrdenCompraResponse;
import cl.mercadopublico.poc.oracle.ordencompra.prop.Estados;

public class OrdenCompraControl {

	private static final String REQUEST_URL = "https://administradordeserviciosapi.azure-api.net/tienda/OC/Generar";

	private static final String CONTENT_TYPE = "application/json";

	private static OrdenCompraControl instance = null;

	public OrdenCompraControl() {
		super();
	}

	/*
	 * <p> Obtiene la instancia de la clase. Forma parte de la implementaci&oacute;n
	 * del patr&oacute;n singleton. </p>
	 *
	 * @return instancia de <code>OrdenCompraControl</code>.
	 */
	public static OrdenCompraControl getInstance() {

		if (!Optional.ofNullable(OrdenCompraControl.instance).isPresent()) {
			OrdenCompraControl.instance = new OrdenCompraControl();
		}
		return OrdenCompraControl.instance;
	}

	public GenerarOrdenCompraResponse generarOrdenCompra(GenerarOrdenCompraRequest request) {
		GenerarOrdenCompraResponse response = new GenerarOrdenCompraResponse();
		Estado estado = null;
		ObjectMapper mapper;
		SimpleModule module;
		String ordenCompraJson;
		Client client;
		WebTarget target;
		Invocation.Builder invocationBuilder;
		Response responseHttp;
		String responseEntity;
		StringBuilder sb;

		try {
			if (Optional.ofNullable(request).isPresent()) {
				mapper = new ObjectMapper();
				module = new SimpleModule("OrdenCompraSerializer", new Version(1, 0, 0, null, null, null));
				module.addSerializer(OrdenCompra.class, new OrdenCompraSerializer());
				mapper.registerModule(module);
				ordenCompraJson = mapper.writeValueAsString(request.getOrdenCompra());

				sb = new StringBuilder();
				sb.append("Path: tienda/OC/Generar");
				sb.append(" | Entity: ").append(ordenCompraJson);
				System.out.println("HTTP REQUEST: " + sb.toString());

				client = ClientBuilder.newClient();
				target = client.target(OrdenCompraControl.REQUEST_URL);
				invocationBuilder = target.request(OrdenCompraControl.CONTENT_TYPE);
				responseHttp = invocationBuilder.post(Entity.entity(ordenCompraJson, OrdenCompraControl.CONTENT_TYPE));

				responseEntity = (responseHttp.readEntity(String.class));

				sb = new StringBuilder();
				sb.append("Path: tienda/OC/Generar");
				sb.append(" | Estatus: ").append(responseHttp.getStatus());
				sb.append(" | Entity: ").append(responseEntity);
				System.out.println("HTTP RESPONSE: " + sb.toString());

				if (responseHttp.getStatus() == 200) {
					if (Optional.ofNullable(responseEntity).isPresent()) {
						estado = new Estado(Estados.OK.toString(), "OK");
						mapper = new ObjectMapper();
						module = new SimpleModule("OrdenCompraResponseDeserializer",
								new Version(1, 0, 0, null, null, null));
						module.addDeserializer(GenerarOrdenCompraResponse.class, new OrdenCompraResponseDeserializer());
						mapper.registerModule(module);
						response = mapper.readValue(responseEntity, GenerarOrdenCompraResponse.class);
					} else {
						estado = new Estado(Estados.OK.toString(), "OK");
					}
				} else {
					estado = new Estado(Estados.INTERNAL_ERROR.toString(), "Internal Server Error");
				}
			} else {
				estado = new Estado(Estados.BAD_REQUEST.toString(), "Bad Request");
			}

		} catch (Exception e) {
			estado = new Estado(Estados.INTERNAL_ERROR.toString(), "Internal Server Error");
			e.printStackTrace();
		}
		response.setEstado(estado);
		return response;
	}

	public static final void main(String[] args) {
		GenerarOrdenCompraRequest request = new GenerarOrdenCompraRequest();
		OrdenCompra ordenCompra = new OrdenCompra();
		List<Producto> productos = new ArrayList<Producto>();
		Producto producto1 = new Producto();

		ordenCompra.setIdTienda("0494425C-5FD2-454A-BD86-3C3929CC216A");
		ordenCompra.setCodigoCompra("codigoXXXXX");
		ordenCompra.setRutProveedor("14.902.900-1");
		ordenCompra.setRazonSocialProveedor("nombreProveedorXXX");
		ordenCompra.setDireccionProveedor("Direccion||ciudad (idCiudad)||region (idRegion)||pais (idPais) ");
		ordenCompra.setRutComprador("22.222.222-2");
		ordenCompra.setCodigoUsuario("1299437_3234");
		ordenCompra.setCodigoUsuarioTienda("codigoEXTXXXXX");
		ordenCompra.setFechaCompra("2009-02-15 12:15:45");
		ordenCompra.setMontoTotal(147.45D);
		ordenCompra.setMonedaCompra("CLP");
		ordenCompra.setDireccionDespacho("Direccion||ciudad (idCiudad)||region (idRegion)||pais (idPais) ");
		ordenCompra.setFechaEntrega("2009-02-15 12:15:45");

		producto1.setTipoCodigoProducto("SKU");
		producto1.setCodigoProducto("codigoProductoXXXX");
		producto1.setNombreProducto("NombreProductoXXXX");
		producto1.setCantidadProducto(12);
		producto1.setPrecioUnitario(94.55D);
		producto1.setInformacion("InformacionXXXX DDDDD DDDDDD DFFFFFF");

		productos.add(producto1);
		ordenCompra.setProductos(productos);

		request.setOrdenCompra(ordenCompra);
		GenerarOrdenCompraResponse response = OrdenCompraControl.getInstance().generarOrdenCompra(request);
		if (Optional.ofNullable(response).isPresent()) {
			System.out.println(response);
		}
	}

}
