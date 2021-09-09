package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import gui.VtnCrearDocumento;
import gui.VtnCrearUsuario;
import gui.VtnSistema;

public class MenuListener implements ActionListener {
	private VtnSistema vtn;
	
	public MenuListener() {}
	
	public MenuListener(VtnSistema vtn) {
		this.vtn = vtn;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj == vtn.getMenuCrearDocumento()) {
			VtnCrearDocumento vtnNuevoDocumento = new VtnCrearDocumento();
			vtnNuevoDocumento.setVisible(true);
			vtnNuevoDocumento.setModal(true);
		}
		
		if(obj == vtn.getMenuCrearUsuario()) {
			VtnCrearUsuario vtnNuevoUsuario = new VtnCrearUsuario();
			vtnNuevoUsuario.setVisible(true);
			vtnNuevoUsuario.setModal(true);
		}
	}
}
