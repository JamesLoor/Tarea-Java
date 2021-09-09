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
import modelo.BaseDatos;
import modelo.Serializacion;
import modelo.Usuario;

public class Principal {
	public static void main(String[] args) {
		BaseDatos bd = new BaseDatos();
		if(BaseDatos.buscarUsuario("ad", "ad") == null) bd.crearAdminPredeterminado();
		bd.imprimirLstUsuario();
		new VtnBienvenida().setVisible(true);
		
	}
}
