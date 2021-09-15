package modelo;

import java.util.Arrays;
import java.util.Date;

public abstract class Documento {
	protected String codigo = "001-001";
	protected String titulo;
	protected String descripcion;
	protected String[] palabrasClaves;
	protected Usuario emisor;
	protected Date fechaCreacion;
	protected Date fechaCaducidad;
	protected TipoDocumento tipo;
	
	public Documento() {}
		
	public Documento(String codigo, String titulo, String descripcion, String[] palabrasClaves, Date fechaCreacion, Date fechaCaducidad, 
			Usuario emisor, TipoDocumento tipo) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.palabrasClaves = palabrasClaves;
		this.fechaCreacion = fechaCreacion;
		this.fechaCaducidad = fechaCaducidad;
		this.emisor = emisor;
		this.tipo = tipo;
	}

	public void cambiarEstado() {
		
	}

	@Override
	public String toString() {
		return "Documento [codigo=" + codigo + ", palabrasClaves=" + Arrays.toString(palabrasClaves) + ", titulo="
				+ titulo + ", descripcion=" + descripcion + ", emisor=" + emisor + ", fechaCreacion=" + fechaCreacion
				+ ", fechaCaducidad=" + fechaCaducidad + ", tipo=" + tipo + "]";
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String[] getPalabrasClaves() {
		return palabrasClaves;
	}

	public void setPalabrasClaves(String[] palabrasClaves) {
		this.palabrasClaves = palabrasClaves;
	}

	public String gettitulo() {
		return titulo;
	}

	public void settitulo(String titulo) {
		this.titulo = titulo;
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
}
