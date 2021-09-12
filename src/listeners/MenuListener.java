package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import gui.VtnBienvenida;
import gui.VtnCrearDocumento;
import gui.VtnCrearUsuario;
import gui.VtnEliminarDocumento;
import gui.VtnEliminarUsuario;
import gui.VtnSistema;

public class MenuListener implements ActionListener {
	private VtnSistema vtnSistema;
	
	public MenuListener() {}
	
	public MenuListener(VtnSistema vtn) {
		this.vtnSistema = vtn;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj == vtnSistema.getMenuCrearDocumento()) {
			VtnCrearDocumento ventana = new VtnCrearDocumento();
			ventana.setVisible(true);
		}
		
		if(obj == vtnSistema.getMenuCrearUsuario()) {
			VtnCrearUsuario ventana = new VtnCrearUsuario(vtnSistema);
			ventana.setVisible(true);
		}
		
		if(obj == vtnSistema.getMenuUsuarioCerrarSesion()) {
			vtnSistema.dispose();
			new VtnBienvenida().setVisible(true);
		}
		
		if(obj == vtnSistema.getMenuEliminarUsuario()) {
			VtnEliminarUsuario ventana = new VtnEliminarUsuario(vtnSistema);
			ventana.setVisible(true);
		}
		
		if(obj == vtnSistema.getMenuEliminarDocumento()) {
			VtnEliminarDocumento ventana = new VtnEliminarDocumento();
			ventana.setVisible(true);
		}
	}
}
