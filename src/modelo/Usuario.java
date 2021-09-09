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

public abstract class Usuario implements Serializable{
	protected final String CODIGO = generarCodigo();
	protected String nombreUsuario;
	protected String password;
	
	public Usuario() {}

	public Usuario(String nombreUsuario, String password) {
		this.nombreUsuario = nombreUsuario;
		this.password = password;
	}
	
	private static String generarCodigo() {
		return String.valueOf((int) (100 + Math.random() * 900));
	}

	@Override
	public String toString() {
		return "Usuario [codigo=" + CODIGO + ", nombreUsuario=" + nombreUsuario + ", password=" + password + "]";
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
		if (CODIGO == null) {
			if (other.CODIGO != null) {
				return false;
			}
		} else if (!CODIGO.equals(other.CODIGO)) {
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
		return CODIGO;
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
