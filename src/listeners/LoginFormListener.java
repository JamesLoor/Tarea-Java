package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import gui.VtnSistema;

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
			validarCredencial(nombreDeUsuario, pwContrase�a);
			
			VtnSistema sistema = new VtnSistema();
			sistema.setVisible(true);
			ventanaBienvenida.dispose();
		} catch (Exception error) {
			JOptionPane.showMessageDialog(null, error.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void validarCredencial(String nombreDeUsuario, String pwContrase�a) {
		if(nombreDeUsuario.isEmpty() && pwContrase�a.isEmpty()) {
			throw new RuntimeException("Debe ingresar nombre de usuario y contrase�a.");
		} else if(nombreDeUsuario.isEmpty()) {
			throw new RuntimeException("Debe ingresar nombre de usuario");
		} else if(pwContrase�a.isEmpty()) {
			throw new RuntimeException("Debe ingresar contrase�a");
		}
	}
}
