/**
 * Clase BaseDatos
 * 
 * Creado el 8 de septiembre, 2021, 15:00
 * 
 * @Author James Mendoza, Derian Paez
 * 
 * @Version POO SOF-S-NO-2-5 - 2021
 * 
 */

package modelo;

import java.util.ArrayList;
import java.util.List;

public class BaseDatos {
	private static List<Usuario> lstUsuario = Serializacion.leerListaUsuario();
	private static List<Documento> lstDocumento = Serializacion.leerListaDocumento();
	private static Usuario usuarioLogeado;
	
	/**
	 * Constructor por defecto
	 */
	public BaseDatos() {}
	
	/**
	 * Añadir documento de oficio
	 * @param d recibe documento
	 */
	public static void addDocumento(DocumentoOficio d) {
		if(lstDocumento == null) lstDocumento = new ArrayList<Documento>();
		lstDocumento.add(d);
	}
	
	/**
	 * Añadir documento informativo
	 * @param d recibe documento
	 */
	public static void addDocumento(DocumentoInformativo d) {
		if(lstDocumento == null) lstDocumento = new ArrayList<Documento>();
		lstDocumento.add(d);
	}
	
	/**
	 * Añadir usuario
	 * @param u recibe usuario
	 */
	public static void addUsuario(Usuario u) {
		if(lstUsuario == null) lstUsuario = new ArrayList<Usuario>();
		lstUsuario.add(u);
	}
	
	/**
	 * Crea documento de oficio
	 * @param documento recibe documento
	 */
	public static void crearDocumento(DocumentoOficio documento) {
		addDocumento(documento);
		Serializacion.guardarListaDocumento(lstDocumento);
	}
	
	/**
	 * Crea docuento informativo
	 * @param documento recibe documento
	 */
	public static void crearDocumento(DocumentoInformativo documento) {
		addDocumento(documento);
		Serializacion.guardarListaDocumento(lstDocumento);
	}
	
	/**
	 * Crea usuario
	 * @param tipo recibe tipo
	 * @param nombreDeUsuario recibe nombre de usuario
	 * @param contrasena recibe contraseña
	 */
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
	
	/**
	 * elimina usuario
	 * @param nombreUsuario recibe nombre de usuario
	 * @return boolean
	 */
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
	
	/**
	 * Busca ususario
	 * @param nombreDeUsuario recibe nombre de usuario
	 * @param contrasena recibe contrasña
	 * @return documento
	 */
	public static boolean eliminarDocumento(String ID) {
		if(lstUsuario != null) {
			for (Documento doc : lstDocumento) {
				if(doc.getCodigo().equals(ID)) {
					lstDocumento.remove(doc);
					Serializacion.guardarListaDocumento(lstDocumento);
					return true;
				}
			}
		}
		
		return false;
	}
	
	/**
	 * busca usuario
	 * @param nombreDeUsuario nombre de usuario
	 * @param contrasena contraseña
	 * @return usuario
	 */
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
	
	/**
	 * Busca documento de oficio por id
	 * @param ID recibe id
	 * @return documento
	 */
	public static Documento buscarDocumentoPorID(String ID) {
		if(lstDocumento != null) {
			for (Documento d : lstDocumento) {
				if(d.getCodigo().equals(ID)) {
					return d;
				}
			}
		}
		return null;
	}
	
	/**
	 * Busca documento de oficio por id
	 * @param ID id
	 * @return  documento oficio
	 */
	public static DocumentoOficio buscarDocumentoOficioPorID(String ID) {
		if(lstDocumento != null) {
			for (Documento d : lstDocumento) {
				if(d.getCodigo().equals(ID)) {
					return ((DocumentoOficio) d);
				}
			}
		}
		return null;
	}
	
	/**
	 * Busca documento informativo por id
	 * @param ID recibe id
	 * @return documento informativo
	 */
	public static DocumentoInformativo buscarDocumentoInformativoPorID(String ID) {
		if(lstDocumento != null) {
			for (Documento d : lstDocumento) {
				if(d.getCodigo().equals(ID)) {
					return ((DocumentoInformativo) d);
				}
			}
		}
		return null;
	}
	
	/**
	 * Busca ususario pro nombre
	 * @param nombreDeUsuario recibe nombre de usuario
	 * @return usuario
	 */
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
	
	/**
	 * Crea el admin predeterminado
	 */
	public static void crearAdminPredeterminado() {
		addUsuario(new Administrador("administrador", "admin"));
		Serializacion.guardarListaUsuario(lstUsuario);
	}
	
	/**
	 * Imprime la lista de usuario
	 */
	public static void imprimirLstUsuario() {
		if(lstUsuario != null) {
			for (Usuario usuario : lstUsuario) {
				System.out.println(usuario);
			}
		}
	}
	
	/**
	 * Imprime la lista de documento
	 */
	public static void imprimirLstDocumento() {
		if(lstDocumento != null) {
			for (Documento documento : lstDocumento) {
				System.out.println(documento);
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
