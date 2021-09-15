package modelo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class Serializacion {
	
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
	
	public static void guardarListaUsuario(List<Usuario> lstUsuario) {
		try {
			ObjectOutputStream objSalida = new ObjectOutputStream(new FileOutputStream("src/usuarios.dat"));
			objSalida.writeObject(lstUsuario);
			objSalida.close();
		} catch(IOException e) {
			System.out.println("El archivo usuarios.dat no fue encontrado, se creara.");
		}
	}
	
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
