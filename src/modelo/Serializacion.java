package modelo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class Serializacion {
	
	public static void guardarListaUsuario(List<Usuario> lstUsuario) {
		try {
			ObjectOutputStream objSalida = new ObjectOutputStream(new FileOutputStream("src/usuarios.txt"));
			objSalida.writeObject(lstUsuario);
			objSalida.close();
		} catch(IOException e) {e.printStackTrace();}
	}
	
	public static List<Usuario> leerListaUsuario() {
		List<Usuario> lstUsuario = null;
		try {
			ObjectInputStream objEntrada = new ObjectInputStream(new FileInputStream("src/usuarios.txt"));
			lstUsuario = (List<Usuario>) objEntrada.readObject();
			objEntrada.close();
		} catch (IOException e){e.printStackTrace();}
		  catch (ClassNotFoundException e){e.printStackTrace () ;}
		
		return lstUsuario;
	}
}
