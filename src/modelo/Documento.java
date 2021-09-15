package modelo;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

public abstract class Documento implements Serializable{
	protected String codigo = "001-001";
	protected String titulo;
	protected String descripcion;
	protected String[] palabrasClaves;
	protected String fechaCreacion;
	protected String fechaCaducidad;
	protected Usuario emisor;
	protected TipoDocumento tipo;
	protected String ruta;
	
	public Documento() {}
		
	public Documento(String titulo, String descripcion, String[] palabrasClaves, 
			Date fechaCreacion, Date fechaCaducidad, Usuario emisor, TipoDocumento tipo, String ruta) {
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.palabrasClaves = palabrasClaves;
		this.fechaCreacion = fechaCreacion;
		this.fechaCaducidad = fechaCaducidad;
		this.emisor = emisor;
		this.tipo = tipo;
		this.ruta = ruta;
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

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaCaducidad() {
		return fechaCaducidad;
	}

	public void setFechaCaducidad(Date fechaCaducidad) {
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
