package cl.mercadopublico.poc.oracle.ordencompra.json.serializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import cl.mercadopublico.poc.oracle.ordencompra.domain.OrdenCompra;
import cl.mercadopublico.poc.oracle.ordencompra.domain.Producto;

public class OrdenCompraSerializer extends StdSerializer<OrdenCompra> {

	private static final long serialVersionUID = 7416940367400718581L;

	public OrdenCompraSerializer() {
		this(null);
	}

	public OrdenCompraSerializer(Class<OrdenCompra> t) {
		super(t);
	}

	@Override
	public void serialize(OrdenCompra ordenCompra, JsonGenerator jsonGenerator, SerializerProvider serializer)
			throws IOException {
		jsonGenerator.writeStartObject();
		jsonGenerator.writeStringField("idTienda", ordenCompra.getIdTienda());
		jsonGenerator.writeStringField("CodigoCompra", ordenCompra.getCodigoCompra());
		jsonGenerator.writeStringField("RutProveedor", ordenCompra.getRutProveedor());
		jsonGenerator.writeStringField("RazonSocialProveedor", ordenCompra.getRazonSocialProveedor());
		jsonGenerator.writeStringField("DireccionProveedor", ordenCompra.getDireccionProveedor());
		jsonGenerator.writeStringField("RutComprador", ordenCompra.getRutComprador());
		jsonGenerator.writeStringField("CodigoUsuario", ordenCompra.getCodigoUsuario());
		jsonGenerator.writeStringField("CodigoUsuarioTienda", ordenCompra.getCodigoUsuarioTienda());
		jsonGenerator.writeStringField("FechaCompra", ordenCompra.getFechaCompra());
		jsonGenerator.writeNumberField("MontoTotal", ordenCompra.getMontoTotal());
		jsonGenerator.writeStringField("MonedaCompra", ordenCompra.getMonedaCompra());
		jsonGenerator.writeStringField("DireccionDespacho", ordenCompra.getDireccionDespacho());
		jsonGenerator.writeStringField("FechaEntrega", ordenCompra.getFechaEntrega());
		if (Optional.ofNullable(ordenCompra.getProductos()).isPresent() && !ordenCompra.getProductos().isEmpty()) {
			jsonGenerator.writeArrayFieldStart("productos");
			for (Producto producto : ordenCompra.getProductos()) {
				jsonGenerator.writeStartObject();
				jsonGenerator.writeStringField("TipoCodigoProducto", producto.getTipoCodigoProducto());
				jsonGenerator.writeStringField("CodigoProducto", producto.getCodigoProducto());
				jsonGenerator.writeStringField("NombreProducto", producto.getNombreProducto());
				jsonGenerator.writeNumberField("CantidadProducto", producto.getCantidadProducto());
				jsonGenerator.writeNumberField("PrecioUnitario", producto.getPrecioUnitario());
				jsonGenerator.writeStringField("Informacion", producto.getInformacion());
				jsonGenerator.writeEndObject();
			}
			jsonGenerator.writeEndArray();
		}
		jsonGenerator.writeEndObject();
	}

	public static void main(String[] args) {
		ObjectMapper mapper = new ObjectMapper();
		SimpleModule module = new SimpleModule("OrdenCompraSerializer", new Version(1, 0, 0, null, null, null));
		module.addSerializer(OrdenCompra.class, new OrdenCompraSerializer());
		mapper.registerModule(module);
		OrdenCompra ordenCompra = new OrdenCompra();
		List<Producto> productos = new ArrayList<Producto>();
		Producto producto1 = new Producto();
		try {
			ordenCompra.setIdTienda("0494425C-5FD2-454A-BD86-3C3929CC216A");
			ordenCompra.setCodigoCompra("codigoXXXXX");
			ordenCompra.setRutProveedor("14.902.900-1");
			ordenCompra.setRazonSocialProveedor("nombreProveedorXXX");
			ordenCompra.setDireccionProveedor("Direccion||ciudad (idCiudad)||region (idRegion)||pais (idPais) ");
			ordenCompra.setRutComprador("22.222.222-2");
			ordenCompra.setCodigoUsuario("1299437_3234");
			ordenCompra.setCodigoUsuarioTienda("codigoEXTXXXXX");
			ordenCompra.setFechaCompra("2009-02-15 12:15:45");
			ordenCompra.setMontoTotal(47.45D);
			ordenCompra.setMonedaCompra("CLP");
			ordenCompra.setDireccionDespacho("Direccion||ciudad (idCiudad)||region (idRegion)||pais (idPais) ");
			ordenCompra.setFechaEntrega("2009-02-15 12:15:45");

			producto1.setTipoCodigoProducto("SKU");
			producto1.setCodigoProducto("codigoProductoXXXX");
			producto1.setNombreProducto("NombreProductoXXXX");
			producto1.setCantidadProducto(12);
			producto1.setPrecioUnitario(41.45D);
			producto1.setInformacion("InformacionXXXX DDDDD DDDDDD DFFFFFF");

			productos.add(producto1);
			ordenCompra.setProductos(productos);

			String ordenCompraJson = mapper.writeValueAsString(ordenCompra);
			System.out.println(ordenCompraJson);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

	}
}
