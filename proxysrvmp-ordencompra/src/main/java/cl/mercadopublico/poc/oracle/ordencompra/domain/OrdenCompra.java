package cl.mercadopublico.poc.oracle.ordencompra.domain;

import java.util.List;

public class OrdenCompra {
	
	private String idTienda;
	
	private String codigoCompra;
	
	private String rutProveedor;
	
	private String razonSocialProveedor;
	
	private String direccionProveedor;
	
	private String rutComprador;
	
	private String codigoUsuario;
	
	private String codigoUsuarioTienda;
	
	private String fechaCompra;
	
	private Integer montoTotal;
	
	private String monedaCompra;
	
	private String direccionDespacho;
	
	private String fechaEntrega;
	
	private List<Producto> productos;

	public OrdenCompra() {
		super();
	}

	public String getIdTienda() {
		return idTienda;
	}

	public void setIdTienda(String idTienda) {
		this.idTienda = idTienda;
	}

	public String getCodigoCompra() {
		return codigoCompra;
	}

	public void setCodigoCompra(String codigoCompra) {
		this.codigoCompra = codigoCompra;
	}

	public String getRutProveedor() {
		return rutProveedor;
	}

	public void setRutProveedor(String rutProveedor) {
		this.rutProveedor = rutProveedor;
	}

	public String getRazonSocialProveedor() {
		return razonSocialProveedor;
	}

	public void setRazonSocialProveedor(String razonSocialProveedor) {
		this.razonSocialProveedor = razonSocialProveedor;
	}

	public String getDireccionProveedor() {
		return direccionProveedor;
	}

	public void setDireccionProveedor(String direccionProveedor) {
		this.direccionProveedor = direccionProveedor;
	}

	public String getRutComprador() {
		return rutComprador;
	}

	public void setRutComprador(String rutComprador) {
		this.rutComprador = rutComprador;
	}

	public String getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(String codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	public String getCodigoUsuarioTienda() {
		return codigoUsuarioTienda;
	}

	public void setCodigoUsuarioTienda(String codigoUsuarioTienda) {
		this.codigoUsuarioTienda = codigoUsuarioTienda;
	}

	public String getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(String fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	public Integer getMontoTotal() {
		return montoTotal;
	}

	public void setMontoTotal(Integer montoTotal) {
		this.montoTotal = montoTotal;
	}

	public String getMonedaCompra() {
		return monedaCompra;
	}

	public void setMonedaCompra(String monedaCompra) {
		this.monedaCompra = monedaCompra;
	}

	public String getDireccionDespacho() {
		return direccionDespacho;
	}

	public void setDireccionDespacho(String direccionDespacho) {
		this.direccionDespacho = direccionDespacho;
	}

	public String getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(String fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
}
