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
import modelo.BaseDatos;

public class Principal {
	public static void main(String[] args) {
		BaseDatos bd = new BaseDatos();
		bd.crearAdminPredeterminado();
		
		new VtnBienvenida().setVisible(true);
	}
}
