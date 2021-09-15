package modelo;

import java.util.ArrayList;
import java.util.List;

public class BaseDatos {
	private static List<Usuario> lstUsuario = Serializacion.leerListaUsuario();
	private static List<Documento> lstDocumento = Serializacion.leerListaDocumento();
	private static Usuario usuarioLogeado;
	
	public BaseDatos() {}
	
	public static void addDocumento(DocumentoOficio d) {
		if(lstDocumento == null) lstDocumento = new ArrayList<Documento>();
		lstDocumento.add(d);
	}
	
	public static void addDocumento(DocumentoInformativo d) {
		if(lstDocumento == null) lstDocumento = new ArrayList<Documento>();
		lstDocumento.add(d);
	}
	
	public static void addUsuario(Usuario u) {
		if(lstUsuario == null) lstUsuario = new ArrayList<Usuario>();
		lstUsuario.add(u);
	}
	
	public static void crearDocumento(DocumentoOficio documento) {
		System.out.println(documento);
		addDocumento(documento);
		Serializacion.guardarListaDocumento(lstDocumento);
	}
	
	public static void crearDocumento(DocumentoInformativo documento) {
		System.out.println(documento);
		addDocumento(documento);
		Serializacion.guardarListaDocumento(lstDocumento);
	}
	
	public static void crearUsuario(String tipo, String nombreDeUsuario, String contrasena) {
		switch (tipo) {
		case "Administrador": {
			addUsuario(new Administrador(nombreDeUsuario, contrasena));
			break;
		}
		case "Jefe": {
			addUsuario(new Jefe(nombreDeUsuario, contrasena));
			break;
		}
		case "Empleado": {
			addUsuario(new Empleado(nombreDeUsuario, contrasena));
			break;
		}
		default:
			throw new IllegalArgumentException("Tipo de usuario inesperado: " + tipo);
		}
		
		Serializacion.guardarListaUsuario(lstUsuario);
	}
	
	public static boolean eliminarUsuario(String nombreUsuario) {
		if(lstUsuario != null) {
			for (Usuario usuario : lstUsuario) {
				if(nombreUsuario.equals(usuario.getNombreUsuario())) {
					lstUsuario.remove(usuario);
					Serializacion.guardarListaUsuario(lstUsuario);
					return true;
				}
			}
		}
		
		return false;
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
	
	public static void crearAdminPredeterminado() {
		addUsuario(new Administrador("administrador", "admin"));
		Serializacion.guardarListaUsuario(lstUsuario);
	}
	
	public static void imprimirLstUsuario() {
		if(lstUsuario != null) {
			for (Usuario usuario : lstUsuario) {
				System.out.println(usuario);
			}
		}
	}
	
	

	public static List<Documento> getLstDocumento() {
		return lstDocumento;
	}

	public static void setLstDocumento(List<Documento> lstDocumento) {
		BaseDatos.lstDocumento = lstDocumento;
	}

	public static List<Usuario> getLstUsuario() {
		return lstUsuario;
	}

	public static void setLstUsuario(List<Usuario> lstUsuario) {
		BaseDatos.lstUsuario = lstUsuario;
	}

	public static Usuario getUsuarioLogeado() {
		return usuarioLogeado;
	}

	public static void setUsuarioLogeado(Usuario usuarioLogeado) {
		BaseDatos.usuarioLogeado = usuarioLogeado;
	}
}
