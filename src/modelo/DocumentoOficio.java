package modelo;

import java.util.Arrays;
import java.util.Date;

public class DocumentoOficio extends Documento {
	private Usuario receptor; 
	private EstadoDocumento estado; 
	
	public DocumentoOficio() {
		super();
	}

	public DocumentoOficio(String codigo, String[] palabrasClaves, String titulo, String descripcion, Usuario emisor,
			Date fechaCreacion, Date fechaCaducidad, TipoDocumento tipo, Usuario receptor, EstadoDocumento estado) {
		super(codigo, palabrasClaves, titulo, descripcion, emisor, fechaCreacion, fechaCaducidad, tipo);
		this.receptor = receptor;
		this.estado = estado;
	}

	public Usuario getReceptor() {
		return receptor;
	}

	public void setReceptor(Usuario receptor) {
		this.receptor = receptor;
	}

	public EstadoDocumento getEstado() {
		return estado;
	}

	public void setEstado(EstadoDocumento estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "DocumentoOficio [receptor=" + receptor + ", estado=" + estado + ", codigo=" + codigo
				+ ", palabrasClaves=" + Arrays.toString(palabrasClaves) + ", titulo=" + titulo + ", descripcion="
				+ descripcion + ", emisor=" + emisor + ", fechaCreacion=" + fechaCreacion + ", fechaCaducidad="
				+ fechaCaducidad + ", tipo=" + tipo + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DocumentoOficio other = (DocumentoOficio) obj;
		if (estado != other.estado)
			return false;
		if (receptor == null) {
			if (other.receptor != null)
				return false;
		} else if (!receptor.equals(other.receptor))
			return false;
		return true;
	}
}
