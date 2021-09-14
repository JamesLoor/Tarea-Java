/**
 * Clase Principal
 * 
 * Creado el 2 de septiembre, 2021, 14:38
 * 
 * @Author James Mendoza, Derian Paez
 * 
 * @Version POO SOF-S-NO-2-5 - 2021
 * 
 */

import gui.VtnBienvenida;
import gui.VtnCrearDocumento;
import gui.VtnEliminarUsuario;
import modelo.BaseDatos;
import modelo.Serializacion;
import modelo.Usuario;

public class Principal {
	public static void main(String[] args) {
		if(BaseDatos.buscarUsuario("administrador", "admin") == null) BaseDatos.crearAdminPredeterminado();
		new VtnBienvenida().setVisible(true);
		
	}
}
