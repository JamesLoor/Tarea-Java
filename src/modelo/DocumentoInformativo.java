package modelo;

import java.util.Arrays;
import java.util.Date;

public class DocumentoInformativo extends Documento {
	private String rolReceptor = "Empleado";
	
	public DocumentoInformativo() {
		super();
	}

	public DocumentoInformativo(String titulo, String descripcion, String[] palabrasClaves,
			String fechaCreacion, String fechaCaducidad, Usuario emisor, TipoDocumento tipo, String ruta, String RolReceptor) {
		super(titulo, descripcion, palabrasClaves, fechaCreacion, fechaCaducidad, emisor, tipo, ruta);
		this.rolReceptor = RolReceptor;
	}

	public String getRolReceptor() {
		return rolReceptor;
	}

	public void setRolReceptor(String rolReceptor) {
		this.rolReceptor = rolReceptor;
	}

	@Override
	public String toString() {
		return "DocumentoInformativo [rolReceptor=" + rolReceptor + ", codigo=" + codigo + ", titulo=" + titulo
				+ ", descripcion=" + descripcion + ", palabrasClaves=" + Arrays.toString(palabrasClaves)
				+ ", fechaCreacion=" + fechaCreacion + ", fechaCaducidad=" + fechaCaducidad + ", emisor=" + emisor
				+ ", tipo=" + tipo + ", ruta=" + ruta + "]";
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
		if (rolReceptor == null) {
			if (other.rolReceptor != null)
				return false;
		} else if (!rolReceptor.equals(other.rolReceptor))
			return false;
		return true;
	}
}