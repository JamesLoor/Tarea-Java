package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.VtnDocumento;

public class DocumentoListener implements ActionListener {
	private VtnDocumento vtnDocumento;

	public DocumentoListener() {}

	public DocumentoListener(VtnDocumento vtnDocumento) {
		this.vtnDocumento = vtnDocumento;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		vtnDocumento.dispose();
	}
}
