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

import gui.VtnDocumento;
import modelo.BaseDatos;

public class Principal {
	public static void main(String[] args) {
		if(BaseDatos.buscarUsuario("administrador", "admin") == null) BaseDatos.crearAdminPredeterminado();
//		new VtnBienvenida().setVisible(true);
		new VtnDocumento().setVisible(true);
	}
}
