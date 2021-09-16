/**
 * Clase DocumentoOficio
 * 
 * Creado el 10 de septiembre, 2021, 15:00
 * 
 * @Author James Mendoza, Derian Paez
 * 
 * @Version POO SOF-S-NO-2-5 - 2021
 * 
 */

package modelo;

import java.util.Arrays;
import java.util.Date;

public class DocumentoOficio extends Documento {
	private Usuario receptor; 
	private EstadoDocumento estado; 
	
	/**
	 * Constructor por defecto
	 */
	public DocumentoOficio() {
		super();
	}

	/**
	 * Constructor de documento de oficio
	 * @param titulo titulo
	 * @param descripcion descripcion
	 * @param palabrasClaves palabras claves 
	 * @param fechaCreacion fecha de creacion
	 * @param fechaCaducidad fecha de caducidad
	 * @param emisor emisor
	 * @param receptor receptor
	 * @param tipo tipo 
	 * @param ruta ruta
	 * @param estado estado
	 */
	public DocumentoOficio(String titulo, String descripcion, String palabrasClaves[], String fechaCreacion,
			String fechaCaducidad, Usuario emisor, Usuario receptor, TipoDocumento tipo, String ruta, EstadoDocumento estado) {
		super(titulo, descripcion, palabrasClaves, fechaCreacion, fechaCaducidad, emisor, tipo, ruta);
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
