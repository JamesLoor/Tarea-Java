package modelo;

import java.util.Arrays;
import java.util.Date;

public class Documento {
	private String codigo;
	private String[] palabrasClaves;
	private String title;
	private String descripcion;
	private Usuario emisor;
	private Usuario receptor;
	private Date fechaCreacion;
	private Date fechaCaducidad;
	private EstadoDocumento estado;
	private TipoDocumento tipo;
	
	public Documento() {}
		
	public Documento(String codigo, String[] palabrasClaves, String title, String descripcion, Usuario emisor,
			Usuario receptor, Date fechaCreacion, Date fechaCaducidad, EstadoDocumento estado, TipoDocumento tipo) {
		super();
		this.codigo = codigo;
		this.palabrasClaves = palabrasClaves;
		this.title = title;
		this.descripcion = descripcion;
		this.emisor = emisor;
		this.receptor = receptor;
		this.fechaCreacion = fechaCreacion;
		this.fechaCaducidad = fechaCaducidad;
		this.estado = estado;
		this.tipo = tipo;
	}

	public void registrarDocumento() {
		
	}
	
	public void cambiarEstado() {
		
	}

	@Override
	public String toString() {
		return "Documento [codigo=" + codigo + ", palabrasClaves=" + Arrays.toString(palabrasClaves) + ", title="
				+ title + ", descripcion=" + descripcion + ", emisor=" + emisor + ", receptor=" + receptor
				+ ", fechaCreacion=" + fechaCreacion + ", fechaCaducidad=" + fechaCaducidad + ", estado=" + estado
				+ ", tipo=" + tipo + "]";
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public Usuario getReceptor() {
		return receptor;
	}

	public void setReceptor(Usuario receptor) {
		this.receptor = receptor;
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

	public EstadoDocumento getEstado() {
		return estado;
	}

	public void setEstado(EstadoDocumento estado) {
		this.estado = estado;
	}

	public TipoDocumento getTipo() {
		return tipo;
	}

	public void setTipo(TipoDocumento tipo) {
		this.tipo = tipo;
	}
}
