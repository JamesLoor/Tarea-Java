/**
 * Clase EliminarUsuarioFormListener
 * 
 * Creado el 4 de septiembre, 2021, 15:00
 * 
 * @Author James Mendoza, Derian Paez
 * 
 * @Version POO SOF-S-NO-2-5 - 2021
 * 
 */

package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import gui.VtnEliminarUsuario;
import gui.VtnSistema;
import modelo.BaseDatos;

public class EliminarUsuarioFormListener implements ActionListener {
	private JTextField txtCodigo;
	private JTextField txtNombreUsuario;
	private VtnEliminarUsuario ventanaEliminarUsuario;
	private VtnSistema vtnSistema;
	
	/**
	 * Constructor por defecto
	 */
	public EliminarUsuarioFormListener() {}
	
	public EliminarUsuarioFormListener(JTextField txtCodigo, JTextField txtNombreUsuario, VtnEliminarUsuario ventanaEliminarUsuario, VtnSistema vtnSistema) {
		this.txtCodigo = txtCodigo;
		this.txtNombreUsuario = txtNombreUsuario;
		this.ventanaEliminarUsuario = ventanaEliminarUsuario;
		this.vtnSistema = vtnSistema;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			String codigo = txtCodigo.getText();
			String nombreDeUsuario = txtNombreUsuario.getText();
			
			validarFormEliminarUsuario(codigo, nombreDeUsuario);
			
			BaseDatos.eliminarUsuario(nombreDeUsuario);
			vtnSistema.getTablaUsuario().cargarTabla();
			ventanaEliminarUsuario.dispose();
		} catch (Exception error) {
			JOptionPane.showMessageDialog(null, error.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * valida que se ingresen los datos
	 * @param codigo recibe codigo
	 * @param nombreDeUsuario recibe nombre de ususario
	 */
	private void validarFormEliminarUsuario(String codigo, String nombreDeUsuario) {
		if(nombreDeUsuario.isEmpty() && codigo.isEmpty()) {
			throw new RuntimeException("Debe ingresar el nombre de usuario y codigo del usuario a eliminar.");
		} else if(nombreDeUsuario.isEmpty()) {
			throw new RuntimeException("Debe ingresar el nombre de usuario del usuario a eliminar");
		} else if(codigo.isEmpty()) {
			throw new RuntimeException("Debe ingresar el codigo del usuario a eliminar");
		}
		
		if(nombreDeUsuario.equals(BaseDatos.getUsuarioLogeado().getNombreUsuario())) {
			throw new RuntimeException("No puede eliminar un usuario que esta usando");
		}
		
		if(nombreDeUsuario.equals("administrador")) {
			throw new RuntimeException("El usuario a eliminar tiene privilegios extendidos");
		}
		
		if(BaseDatos.buscarUsuarioPorNombre(nombreDeUsuario) == null) {
			throw new RuntimeException("El usuario a eliminar no existe, porfavor ingrese un usuario ya registrado.");
		}
		
		if(!BaseDatos.buscarUsuarioPorNombre(nombreDeUsuario).getCodigo().equals(codigo)) {
			throw new RuntimeException("El codigo de usuario a eliminar no existe, porfavor ingrese un codigo de usuario ya registrado.");
		}
	}
	
}
