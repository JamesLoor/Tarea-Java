package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginFormListener implements ActionListener {
	private JTextField txtNombreUsuario;
	private JPasswordField pwContrase�a;
	
	public LoginFormListener(JTextField txtNombreUsuario, JPasswordField pwContrase�a) {
		this.txtNombreUsuario = txtNombreUsuario;
		this.pwContrase�a = pwContrase�a;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(txtNombreUsuario.getText() == "") {
			JOptionPane.showMessageDialog(null, "No debe haber inputs vacios");
			return;
		}
		
		String message = txtNombreUsuario.getText() + " : " + pwContrase�a.getText();
		JOptionPane.showMessageDialog(null, message);
	}
}
