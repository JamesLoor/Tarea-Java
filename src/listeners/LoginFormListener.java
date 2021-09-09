package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import gui.VtnSistema;
import modelo.BaseDatos;
import modelo.Serializacion;
import modelo.Usuario;

public class LoginFormListener implements ActionListener {
	private JTextField txtNombreUsuario;
	private JPasswordField pwContrasena;
	private JFrame ventanaBienvenida;
	
	public LoginFormListener(JTextField txtNombreUsuario, JPasswordField pwContrasena, JFrame ventanaBienvenida) {
		this.txtNombreUsuario = txtNombreUsuario;
		this.pwContrasena = pwContrasena;
		this.ventanaBienvenida = ventanaBienvenida;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			String nombreDeUsuario = txtNombreUsuario.getText();
			String pwContrase�a = pwContrasena.getText();
			Usuario usuario = validarCredencial(nombreDeUsuario, pwContrase�a);
			
			VtnSistema sistema = new VtnSistema(usuario);
			sistema.setVisible(true);
			ventanaBienvenida.dispose();
		} catch (Exception error) {
			JOptionPane.showMessageDialog(null, error.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		} finally {
			limpiarFormulario();
		}
	}
	
	private Usuario validarCredencial(String nombreDeUsuario, String pwContrasena) {
		if(nombreDeUsuario.isEmpty() && pwContrasena.isEmpty()) {
			throw new RuntimeException("Debe ingresar nombre de usuario y contrasena.");
		} else if(nombreDeUsuario.isEmpty()) {
			throw new RuntimeException("Debe ingresar nombre de usuario");
		} else if(pwContrasena.isEmpty()) {
			throw new RuntimeException("Debe ingresar contrase�a");
		}
		
		boolean usuarioEncontrado = (BaseDatos.buscarUsuario(nombreDeUsuario, pwContrasena) != null);
		if(!usuarioEncontrado) {
			throw new RuntimeException("El usuario ingresado no esta registrado.");
		} else {
			return BaseDatos.buscarUsuario(nombreDeUsuario, pwContrasena);
		}
	}
	
	private void limpiarFormulario() {
		txtNombreUsuario.setText("");
		pwContrasena.setText("");
	}
}
