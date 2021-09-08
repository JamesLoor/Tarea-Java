package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import gui.VtnSistema;
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
			String pwContraseña = pwContrasena.getText();
			Usuario usuario = validarCredencial(nombreDeUsuario, pwContraseña);
			
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
			throw new RuntimeException("Debe ingresar nombre de usuario y contraseña.");
		} else if(nombreDeUsuario.isEmpty()) {
			throw new RuntimeException("Debe ingresar nombre de usuario");
		} else if(pwContrasena.isEmpty()) {
			throw new RuntimeException("Debe ingresar contraseña");
		}
		
		List<Usuario> lstUsuario = Serializacion.leerListaUsuario();
		boolean usuarioEncontrado = false;
		
		for (Usuario usuario : lstUsuario) {
			if(nombreDeUsuario.equals(usuario.getNombreUsuario()) && pwContrasena.equals(usuario.getPassword())) {
				usuarioEncontrado = true;
				return usuario;
			}
		}
		
		if(usuarioEncontrado == false) {
			throw new RuntimeException("El usuario ingresado no esta registrado.");
		}
		
		return null;
	}
	
	private void limpiarFormulario() {
		txtNombreUsuario.setText("");
		pwContrasena.setText("");
	}
}
