package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class FrmUsuarioListener implements ActionListener {
	private JFrame VtnSistema;
	
	public FrmUsuarioListener() {}
	
	public FrmUsuarioListener(JFrame VtnSistema) {
		this.VtnSistema = VtnSistema;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Se abrira lo de crear otra ventana");
	}
}
