package modelo;

import java.util.Arrays;
import java.util.Date;

public class DocumentoInformativo extends Documento {
	private String RolReceptor = "Empleado";
	
	public DocumentoInformativo() {
		super();
	}

	public DocumentoInformativo(String codigo, String[] palabrasClaves, String titulo, String descripcion,
			Usuario emisor, Date fechaCreacion, Date fechaCaducidad, TipoDocumento tipo, String RolReceptor) {
		super(codigo, palabrasClaves, titulo, descripcion, emisor, fechaCreacion, fechaCaducidad, tipo);
		this.RolReceptor = RolReceptor;
	}

	public String getRolReceptor() {
		return RolReceptor;
	}

	public void setRolReceptor(String rolReceptor) {
		RolReceptor = rolReceptor;
	}

	@Override
	public String toString() {
		return "DocumentoInformativo [RolReceptor=" + RolReceptor + ", codigo=" + codigo + ", palabrasClaves="
				+ Arrays.toString(palabrasClaves) + ", titulo=" + titulo + ", descripcion=" + descripcion + ", emisor="
				+ emisor + ", fechaCreacion=" + fechaCreacion + ", fechaCaducidad=" + fechaCaducidad + ", tipo=" + tipo
				+ "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DocumentoInformativo other = (DocumentoInformativo) obj;
		if (RolReceptor == null) {
			if (other.RolReceptor != null)
				return false;
		} else if (!RolReceptor.equals(other.RolReceptor))
			return false;
		return true;
	}
}
