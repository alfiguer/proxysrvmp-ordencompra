package cl.mercadopublico.poc.oracle.ordencompra.domain;

import java.util.List;
import java.util.Optional;

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
	
	@Override
	public String toString() {
		StringBuilder trace = new StringBuilder();
		if (Optional.ofNullable(this.getIdTienda()).isPresent()) {
			trace.append("idTienda=").append(this.getIdTienda()).append(",");
		}
		if (Optional.ofNullable(this.getCodigoCompra()).isPresent()) {
			trace.append("codigoCompra=").append(this.getCodigoCompra()).append(",");
		}
		if (Optional.ofNullable(this.getRutProveedor()).isPresent()) {
			trace.append("rutProveedor=").append(this.getRutProveedor()).append(",");
		}
		if (Optional.ofNullable(this.getRazonSocialProveedor()).isPresent()) {
			trace.append("razonSocialProveedor=").append(this.getRazonSocialProveedor()).append(",");
		}
		if (Optional.ofNullable(this.getDireccionProveedor()).isPresent()) {
			trace.append("direccionProveedor=").append(this.getDireccionProveedor()).append(",");
		}
		if (Optional.ofNullable(this.getRutComprador()).isPresent()) {
			trace.append("rutComprador=").append(this.getRutComprador()).append(",");
		}
		if (Optional.ofNullable(this.getCodigoUsuario()).isPresent()) {
			trace.append("codigoUsuario=").append(this.getCodigoUsuario()).append(",");
		}
		if (Optional.ofNullable(this.getCodigoUsuarioTienda()).isPresent()) {
			trace.append("codigoUsuarioTienda=").append(this.getCodigoUsuarioTienda()).append(",");
		}
		if (Optional.ofNullable(this.getFechaCompra()).isPresent()) {
			trace.append("fechaCompra=").append(this.getFechaCompra()).append(",");
		}
		if (Optional.ofNullable(this.getMontoTotal()).isPresent()) {
			trace.append("montoTotal=").append(this.getMontoTotal()).append(",");
		}
		if (Optional.ofNullable(this.getMonedaCompra()).isPresent()) {
			trace.append("monedaCompra=").append(this.getMonedaCompra()).append(",");
		}
		if (Optional.ofNullable(this.getDireccionDespacho()).isPresent()) {
			trace.append("direccionDespacho=").append(this.getDireccionDespacho()).append(",");
		}
		if (Optional.ofNullable(this.getFechaEntrega()).isPresent()) {
			trace.append("fechaEntrega=").append(this.getFechaEntrega()).append(",");
		}
		if (Optional.ofNullable(this.getProductos()).isPresent() && !this.getProductos().isEmpty()) {
			for (Producto producto : productos) {
				trace.append("producto=").append(producto.toString()).append(",");
			}
		}
		return trace.toString();
	}
	
}
