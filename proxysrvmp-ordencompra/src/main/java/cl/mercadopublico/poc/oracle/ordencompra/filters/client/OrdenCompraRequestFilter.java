package cl.mercadopublico.poc.oracle.ordencompra.filters.client;

import java.io.IOException;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;

public class OrdenCompraRequestFilter implements ClientRequestFilter {

	public OrdenCompraRequestFilter() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void filter(ClientRequestContext requestContext) throws IOException {
		System.out.println("getMethod(): " + requestContext.getMethod());
	}

}
