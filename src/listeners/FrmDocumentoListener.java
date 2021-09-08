package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import gui.VtnCrearDocumento;

public class FrmDocumentoListener implements ActionListener {
	private JFrame VtnSistema;
	
	public FrmDocumentoListener() {}
	
	public FrmDocumentoListener(JFrame VtnSistema) {
		this.VtnSistema = VtnSistema;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		VtnCrearDocumento ventanaCrearDocumento = new VtnCrearDocumento();
		ventanaCrearDocumento.setVisible(true);
		VtnSistema.setEnabled(false);
		// Se tiene que bloquear la ventana de Sistema mientras se esta creando el usuario.
		// tnSistema.dispose();
	}
}
