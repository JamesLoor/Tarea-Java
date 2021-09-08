package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import gui.VtnCrearUsuario;
import gui.VtnSistema;

public class FrmUsuarioListener implements ActionListener {
	private JFrame VtnSistema;
	
	public FrmUsuarioListener() {}
	
	public FrmUsuarioListener(JFrame VtnSistema) {
		this.VtnSistema = VtnSistema;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		VtnCrearUsuario ventanaCrearUsuario = new VtnCrearUsuario();
		ventanaCrearUsuario.setVisible(true);
		// Se tiene que bloquear la ventana de Sistema mientras se esta creando el usuario.
		// tnSistema.dispose();
	}
}
