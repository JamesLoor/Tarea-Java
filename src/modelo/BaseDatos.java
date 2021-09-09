package modelo;

import java.util.ArrayList;
import java.util.List;

public class BaseDatos {
	private static List<Usuario> lstUsuario = Serializacion.leerListaUsuario();
	
	public BaseDatos() {}
	
	public static void addUsuario(Usuario u) {
		if(lstUsuario == null) lstUsuario = new ArrayList<Usuario>();
		lstUsuario.add(u);
	}
	
	public static void crearUsuario(String tipo, String nombreDeUsuario, String contrasena) {
		switch (tipo) {
		case "Administrador": {
			addUsuario(new Administrador(nombreDeUsuario, contrasena));
			System.out.println("Se creo usuario Administrador");
			break;
		}
		case "Jefe": {
			addUsuario(new Jefe(nombreDeUsuario, contrasena));
			System.out.println("Se creo usuario Jefe");
			break;
		}
		case "Empleado": {
			addUsuario(new Empleado(nombreDeUsuario, contrasena));
			System.out.println("Se creo usuario Empleado");
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + tipo);
		}
		
		Serializacion.guardarListaUsuario(lstUsuario);
	}
	
	public void borrarUsuario(String codigoUsuario) {
		
	}
	
	public static Usuario buscarUsuario(String nombreDeUsuario, String contrasena) {
		if(lstUsuario != null) {
			for (Usuario usuario : lstUsuario) {
				if(nombreDeUsuario.equals(usuario.getNombreUsuario()) && contrasena.equals(usuario.getPassword())) {
					return usuario;
				}
			}
		}
		
		return null;
	}
	
	public static Usuario buscarUsuarioPorNombre(String nombreDeUsuario) {
		if(lstUsuario != null) {
			for (Usuario usuario : lstUsuario) {
				if(nombreDeUsuario.equals(usuario.getNombreUsuario())) {
					return usuario;
				}
			}
		}
		
		return null;
	}
	
	public void crearAdminPredeterminado() {
		addUsuario(new Administrador("ad", "ad"));
		Serializacion.guardarListaUsuario(lstUsuario);
	}
	
	public void imprimirLstUsuario() {
		if(lstUsuario != null) {
			for (Usuario usuario : lstUsuario) {
				System.out.println(usuario);
			}
		}
	}
}
