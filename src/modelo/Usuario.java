package modelo;

import java.io.Serializable;

/**
 * Clase 
 * 
 * Creado el 2 de septiembre, 2021, 14:51
 * 
 * @Author James Mendoza, Derian Paez
 * 
 * @Version POO SOF-S-NO-2-5 - 2021
 * 
 */

public class Usuario implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String codigo;
	protected String nombreUsuario;
	protected String password;
	
	public Usuario() {}

	public Usuario(String codigo, String nombreUsuario, String password) {
		this.codigo = codigo;
		this.nombreUsuario = nombreUsuario;
		this.password = password;
	}

	@Override
	public String toString() {
		return "Usuario [codigo=" + codigo + ", nombreUsuario=" + nombreUsuario + ", password=" + password + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Usuario other = (Usuario) obj;
		if (codigo == null) {
			if (other.codigo != null) {
				return false;
			}
		} else if (!codigo.equals(other.codigo)) {
			return false;
		}
		if (nombreUsuario == null) {
			if (other.nombreUsuario != null) {
				return false;
			}
		} else if (!nombreUsuario.equals(other.nombreUsuario)) {
			return false;
		}
		if (password == null) {
			if (other.password != null) {
				return false;
			}
		} else if (!password.equals(other.password)) {
			return false;
		}
		return true;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
