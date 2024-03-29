/**
 * Clase TablaUsuario
 * 
 * Creado el 3 de septiembre, 2021, 15:00
 * 
 * @Author James Mendoza, Derian Paez
 * 
 * @Version POO SOF-S-NO-2-5 - 2021
 * 
 */

package gui;

import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Serializacion;
import modelo.Usuario;

public class TablaUsuario extends JTable {
	private String cabecera[] = {"ID", "Nombre", "Contraseņa", "Rol"};
	private Object data[][];
	private DefaultTableModel modelo;
	
	/**
	 * Constructor de la tabla de usuarios
	 */
	public TablaUsuario() {
		initComponents();
	}
	
	/**
	 * Inicializa la tabla de usuarios
	 */
	private void initComponents() {
		modelo = new DefaultTableModel(null, cabecera);
		cargarTabla();
		setModel(modelo);
		setEnabled(false);
		setDragEnabled(false);
		getTableHeader().setEnabled(false);
	}
	
	/**
	 * Carga la tabla de Usuarios
	 */
	public void cargarTabla() {
		modelo.setRowCount(0);
		data = null;
		List<Usuario> lstUsuario = Serializacion.leerListaUsuario();
		for(int i = 0; i < lstUsuario.size(); i++) {
			Usuario usuario = lstUsuario.get(i);
			modelo.addRow(data);
			modelo.setValueAt(usuario.getCodigo(), i, 0);
			modelo.setValueAt(usuario.getNombreUsuario(), i, 1);
			modelo.setValueAt(usuario.getPassword(), i, 2);
			modelo.setValueAt(usuario.getClass().getSimpleName(), i, 3);
		}
	}
	
}
