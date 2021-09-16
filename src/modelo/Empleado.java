/**
 * Clase Empleado
 * 
 * Creado el 10 de septiembre, 2021, 15:00
 * 
 * @Author James Mendoza, Derian Paez
 * 
 * @Version POO SOF-S-NO-2-5 - 2021
 * 
 */

package modelo;

public class Empleado extends Usuario {
	private final String rol = "Empleado";

	public Empleado() {
		super();
	}

	public Empleado(String nombreUsuario, String password) {
		super(nombreUsuario, password);
	}

	@Override
	public String toString() {
		return "Empleado [rol=" + rol + ", CODIGO=" + CODIGO + ", nombreUsuario=" + nombreUsuario + ", password="
				+ password + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Empleado other = (Empleado) obj;
		if (!rol.equals(other.rol)) {
			return false;
		}
		return true;
	}

	public String getRol() {
		return rol;
	}
}
