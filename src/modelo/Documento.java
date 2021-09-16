/**
 * Clase Documento
 * 
 * Creado el 8 de septiembre, 2021, 15:00
 * 
 * @Author James Mendoza, Derian Paez
 * 
 * @Version POO SOF-S-NO-2-5 - 2021
 * 
 */

package modelo;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

public abstract class Documento implements Serializable{
	protected String codigo = generarCodigo();
	protected String titulo;
	protected String descripcion;
	protected String[] palabrasClaves;
	protected String fechaCreacion;
	protected String fechaCaducidad;
	protected Usuario emisor;
	protected TipoDocumento tipo;
	protected String ruta;
	
	/**
	 * Constructor por defecto
	 */
	public Documento() {}
		
	/**
	 * Constructor de documento
	 * @param titulo titulo
	 * @param descripcion descripcion
	 * @param palabrasClaves palabras claves
	 * @param fechaCreacion fecha de creacion
	 * @param fechaCaducidad fecha de caducidad
	 * @param emisor emisor
	 * @param tipo tipo
	 * @param ruta ruta
	 */
	public Documento(String titulo, String descripcion, String[] palabrasClaves, 
			String fechaCreacion, String fechaCaducidad, Usuario emisor, TipoDocumento tipo, String ruta) {
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.palabrasClaves = palabrasClaves;
		this.fechaCreacion = fechaCreacion;
		this.fechaCaducidad = fechaCaducidad;
		this.emisor = emisor;
		this.tipo = tipo;
		this.ruta = ruta;
	}
	
	/**
	 * genera el codigo
	 * @return numero
	 */
	private static String generarCodigo() {
		return String.valueOf((int) (100 + Math.random() * 900));
	}

	@Override
	public String toString() {
		return "Documento [codigo=" + codigo + ", palabrasClaves=" + Arrays.toString(palabrasClaves) + ", titulo="
				+ titulo + ", descripcion=" + descripcion + ", emisor=" + emisor + ", fechaCreacion=" + fechaCreacion
				+ ", fechaCaducidad=" + fechaCaducidad + ", tipo=" + tipo + ", ruta=" + ruta + "]";
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String[] getPalabrasClaves() {
		return palabrasClaves;
	}

	public void setPalabrasClaves(String[] palabrasClaves) {
		this.palabrasClaves = palabrasClaves;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Usuario getEmisor() {
		return emisor;
	}

	public void setEmisor(Usuario emisor) {
		this.emisor = emisor;
	}

	public String getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getFechaCaducidad() {
		return fechaCaducidad;
	}

	public void setFechaCaducidad(String fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}

	public TipoDocumento getTipo() {
		return tipo;
	}

	public void setTipo(TipoDocumento tipo) {
		this.tipo = tipo;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
}
