package modelo;

public class Jefe extends Usuario{
	private final String rol = "Jefe";

	public Jefe() {
		super();
	}

	public Jefe(String nombreUsuario, String password) {
		super(nombreUsuario, password);
	}

	@Override
	public String toString() {
		return "Jefe [rol=" + rol + ", CODIGO=" + CODIGO + ", nombreUsuario=" + nombreUsuario + ", password=" + password
				+ "]";
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
		Jefe other = (Jefe) obj;
		if (rol == null) {
			if (other.rol != null) {
				return false;
			}
		} else if (!rol.equals(other.rol)) {
			return false;
		}
		return true;
	}
}
