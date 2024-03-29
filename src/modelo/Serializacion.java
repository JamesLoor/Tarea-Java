/**
 * Clase Serializacion
 * 
 * Creado el 10 de septiembre, 2021, 15:00
 * 
 * @Author James Mendoza, Derian Paez
 * 
 * @Version POO SOF-S-NO-2-5 - 2021
 * 
 */

package modelo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class Serializacion {
	
	/**
	 * Guarda lista de documentos
	 * @param lstDocumento lista de documentos
	 */
	public static void guardarListaDocumento(List<Documento> lstDocumento) {
		try {
			ObjectOutputStream objSalida = new ObjectOutputStream(new FileOutputStream("src/documentos.dat"));
			objSalida.writeObject(lstDocumento);
			objSalida.close();
		} catch(IOException e) {
//			System.out.println("El archivo documentos.dat no fue encontrado, se creara.");
			e.printStackTrace();
		}
	}
	
	/**
	 * Lee la lista de documentos
	 * @return lstdocumeto
	 */
	public static List<Documento> leerListaDocumento() {
		List<Documento> lstDocumento = null;
		try {
			ObjectInputStream objEntrada = new ObjectInputStream(new FileInputStream("src/documentos.dat"));
			lstDocumento = (List<Documento>) objEntrada.readObject();
			objEntrada.close();
		} catch (IOException e) {
			System.out.println("El archivo documentos.dat no fue encontrado, se creara.");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return lstDocumento;
	}
	
	/**
	 * Guadar lista de usuario
	 * @param lstUsuario lista usuario
	 */
	public static void guardarListaUsuario(List<Usuario> lstUsuario) {
		try {
			ObjectOutputStream objSalida = new ObjectOutputStream(new FileOutputStream("src/usuarios.dat"));
			objSalida.writeObject(lstUsuario);
			objSalida.close();
		} catch(IOException e) {
			System.out.println("El archivo usuarios.dat no fue encontrado, se creara.");
		}
	}
	
	/**
	 * Lee lista de usuario
	 * @return
	 */
	public static List<Usuario> leerListaUsuario() {
		List<Usuario> lstUsuario = null;
		try {
			ObjectInputStream objEntrada = new ObjectInputStream(new FileInputStream("src/usuarios.dat"));
			lstUsuario = (List<Usuario>) objEntrada.readObject();
			objEntrada.close();
		} catch (IOException e) {
			System.out.println("El archivo usuarios.dat no fue encontrado, se creara.");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return lstUsuario;
	}
}
