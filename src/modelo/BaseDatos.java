package modelo;

import java.util.ArrayList;
import java.util.List;

public class BaseDatos {
	private List<Usuario> listaUsuario;
	
	public BaseDatos() {}
	
	public void addUsuario(Usuario u) {
		if(listaUsuario == null) listaUsuario = new ArrayList<Usuario>();
		listaUsuario.add(u);
	}
	
	public void borrarUsuario(String codigoUsuario) {
		
	}
	
	public void crearAdminPredeterminado() {
		Usuario admin = new Administrador("administrador", "admin123");
		addUsuario(admin);
		Serializacion.guardarListaUsuario(listaUsuario);
	}
}