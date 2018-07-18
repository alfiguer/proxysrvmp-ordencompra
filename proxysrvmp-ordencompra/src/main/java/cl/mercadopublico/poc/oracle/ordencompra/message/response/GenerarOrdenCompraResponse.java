package cl.mercadopublico.poc.oracle.ordencompra.message.response;

import java.util.Optional;

import cl.mercadopublico.poc.oracle.ordencompra.domain.Estado;

public class GenerarOrdenCompraResponse {

	private Estado estado;

	private String fechaRespuesta;

	private String codigoRespuesta;

	private String respuesta;

	private String url;

	public GenerarOrdenCompraResponse() {
		super();
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public String getFechaRespuesta() {
		return fechaRespuesta;
	}

	public void setFechaRespuesta(String fechaRespuesta) {
		this.fechaRespuesta = fechaRespuesta;
	}

	public String getCodigoRespuesta() {
		return codigoRespuesta;
	}

	public void setCodigoRespuesta(String codigoRespuesta) {
		this.codigoRespuesta = codigoRespuesta;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		StringBuilder trace = new StringBuilder();
		if (Optional.ofNullable(this.getEstado()).isPresent()) {
			trace.append(this.getEstado().toString()).append(",");
		}
		if (Optional.ofNullable(this.getFechaRespuesta()).isPresent()) {
			trace.append("fechaRespuesta=").append(this.getFechaRespuesta()).append(",");
		}
		if (Optional.ofNullable(this.getCodigoRespuesta()).isPresent()) {
			trace.append("codigoRespuesta=").append(this.getCodigoRespuesta()).append(",");
		}
		if (Optional.ofNullable(this.getRespuesta()).isPresent()) {
			trace.append("respuesta=").append(this.getRespuesta()).append(",");
		}
		if (Optional.ofNullable(this.getUrl()).isPresent()) {
			trace.append("url=").append(this.getUrl()).append(",");
		}
		return trace.toString();
	}

}
