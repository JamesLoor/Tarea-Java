package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginFormListener implements ActionListener {
	private JTextField txtNombreUsuario;
	private JPasswordField pwContraseña;
	
	public LoginFormListener(JTextField txtNombreUsuario, JPasswordField pwContraseña) {
		this.txtNombreUsuario = txtNombreUsuario;
		this.pwContraseña = pwContraseña;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(txtNombreUsuario.getText() == "") {
			JOptionPane.showMessageDialog(null, "No debe haber inputs vacios");
			return;
		}
		
		String message = txtNombreUsuario.getText() + " : " + pwContraseña.getText();
		JOptionPane.showMessageDialog(null, message);
	}
}
