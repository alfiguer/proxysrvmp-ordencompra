package cl.mercadopublico.poc.oracle.ordencompra.message.request;

import cl.mercadopublico.poc.oracle.ordencompra.domain.OrdenCompra;

public class GenerarOrdenCompraRequest {
	
	private OrdenCompra ordenCompra;
	
	public GenerarOrdenCompraRequest() {
		super();
	}

	public GenerarOrdenCompraRequest(OrdenCompra ordenCompra) {
		this.ordenCompra = ordenCompra;
	}

	public OrdenCompra getOrdenCompra() {
		return ordenCompra;
	}

	public void setOrdenCompra(OrdenCompra ordenCompra) {
		this.ordenCompra = ordenCompra;
	}
	
}
