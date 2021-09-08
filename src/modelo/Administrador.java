package modelo;

public class Administrador extends Usuario {
	private final String rol = "Administrador";

	public Administrador() {
		super();
	}

	public Administrador(String nombreUsuario, String password) {
		super(nombreUsuario, password);
	}

	@Override
	public String toString() {
		return "Administrador [rol=" + rol + ", codigo=" + CODIGO + ", nombreUsuario=" + nombreUsuario + ", password="
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
		Administrador other = (Administrador) obj;
		if (!rol.equals(other.rol)) {
			return false;
		}
		return true;
	}

	public String getRol() {
		return rol;
	}
}
