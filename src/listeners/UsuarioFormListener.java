/**
 * Clase UsuarioFormListener
 * 
 * Creado el 5 de septiembre, 2021, 15:00
 * 
 * @Author James Mendoza, Derian Paez
 * 
 * @Version POO SOF-S-NO-2-5 - 2021
 * 
 */

package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import gui.VtnSistema;
import modelo.BaseDatos;

public class UsuarioFormListener implements ActionListener {
	private JTextField txtNombreUsuario;
	private JTextField txtContrasena;
	private JTextField txtComprobarContrasena;
	private JComboBox<String> ComboRol;
	private JDialog ventanaCrearUsuario;
	private VtnSistema vtnSistema;
	
	/**
	 * Constructor por defecto
	 */
	public UsuarioFormListener() {}
	
	/**
	 * Constructor del escuchador del formulario de usuario
	 * @param txtNombreUsuario nombre de usuario
	 * @param txtContrasena contraseña
	 * @param txtComprobarContrasena comprobar contraseña
	 * @param ComboRol rol
	 * @param ventanaCrearUsuario ventana crear usuario
	 * @param vtnSistema ventana sistema
	 */
	public UsuarioFormListener(JTextField txtNombreUsuario, JTextField txtContrasena, 
			JTextField txtComprobarContrasena, JComboBox<String> ComboRol, JDialog ventanaCrearUsuario, VtnSistema vtnSistema) {
		this.txtNombreUsuario = txtNombreUsuario;
		this.txtContrasena = txtContrasena;
		this.txtComprobarContrasena = txtComprobarContrasena;
		this.ComboRol = ComboRol;
		this.ventanaCrearUsuario = ventanaCrearUsuario;
		this.vtnSistema = vtnSistema;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			String nombreDeUsuario = txtNombreUsuario.getText();
			String contrasena = txtContrasena.getText();
			String comprobarContrasena = txtComprobarContrasena.getText();
			String rol = (String) ComboRol.getSelectedItem();
			
			validarFormUsuario(nombreDeUsuario, contrasena, comprobarContrasena);
			
			BaseDatos.crearUsuario(rol, nombreDeUsuario, contrasena);
			vtnSistema.getTablaUsuario().cargarTabla();
			ventanaCrearUsuario.dispose();
		} catch (Exception error) {
			JOptionPane.showMessageDialog(null, error.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * valida que se ingresen los datos
	 * @param nombreDeUsuario recibe nombre de usuario
	 * @param contrasena recibe contraseña
	 * @param comprobarContrasena recibe comprobacion de contraseña
	 */
	private void validarFormUsuario(String nombreDeUsuario, String contrasena, String comprobarContrasena) {
		if(nombreDeUsuario.isEmpty() && contrasena.isEmpty() && comprobarContrasena.isEmpty()) {
			throw new RuntimeException("Debe ingresar nombre de usuario, contrasena y contrasena de comprobacion.");
		} else if(nombreDeUsuario.isEmpty()) {
			throw new RuntimeException("Debe ingresar nombre de usuario");
		} else if(contrasena.isEmpty()) {
			throw new RuntimeException("Debe ingresar contrasena");
		} else if(comprobarContrasena.isEmpty()) {
			throw new RuntimeException("Debe ingresar contraseña de comprobacion");
		}
		
		if(!contrasena.equals(comprobarContrasena)) {
			throw new RuntimeException("Las contrasenas ingresadas no son iguales");
		}
		
		if(BaseDatos.buscarUsuarioPorNombre(nombreDeUsuario) != null) {
			throw new RuntimeException("El nombre de usuario ya ah sido escogido, intente con otro nombre");
		}
	}
}
