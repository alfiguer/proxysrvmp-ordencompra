package cl.mercadopublico.poc.oracle.ordencompra.domain;

import java.util.Optional;

public class Producto {

	private String tipoCodigoProducto;

	private String codigoProducto;

	private String nombreProducto;

	private Integer cantidadProducto;

	private Integer precioUnitario;

	private String informacion;

	public Producto() {
		super();
	}

	public String getTipoCodigoProducto() {
		return tipoCodigoProducto;
	}

	public void setTipoCodigoProducto(String tipoCodigoProducto) {
		this.tipoCodigoProducto = tipoCodigoProducto;
	}

	public String getCodigoProducto() {
		return codigoProducto;
	}

	public void setCodigoProducto(String codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public Integer getCantidadProducto() {
		return cantidadProducto;
	}

	public void setCantidadProducto(Integer cantidadProducto) {
		this.cantidadProducto = cantidadProducto;
	}

	public Integer getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(Integer precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public String getInformacion() {
		return informacion;
	}

	public void setInformacion(String informacion) {
		this.informacion = informacion;
	}
	
	@Override
	public String toString() {
		StringBuilder trace = new StringBuilder();
		if (Optional.ofNullable(this.getTipoCodigoProducto()).isPresent()) {
			trace.append("tipoCodigoProducto=").append(this.getTipoCodigoProducto()).append(",");
		}
		if (Optional.ofNullable(this.getCodigoProducto()).isPresent()) {
			trace.append("codigoProducto=").append(this.getCodigoProducto()).append(",");
		}
		if (Optional.ofNullable(this.getNombreProducto()).isPresent()) {
			trace.append("nombreProducto=").append(this.getNombreProducto()).append(",");
		}
		if (Optional.ofNullable(this.getCantidadProducto()).isPresent()) {
			trace.append("cantidadProducto=").append(this.getCantidadProducto()).append(",");
		}
		if (Optional.ofNullable(this.getPrecioUnitario()).isPresent()) {
			trace.append("precioUnitario=").append(this.getPrecioUnitario()).append(",");
		}
		if (Optional.ofNullable(this.getInformacion()).isPresent()) {
			trace.append("informacion=").append(this.getInformacion()).append(",");
		}
		return trace.toString();
	}

}
