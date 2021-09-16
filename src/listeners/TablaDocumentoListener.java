package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import gui.TablaDocumento;
import gui.VtnDocumento;
import gui.VtnSistema;
import modelo.BaseDatos;
import modelo.DocumentoOficio;

public class TablaDocumentoListener implements MouseListener {
	private TablaDocumento tabla;
	
	public TablaDocumentoListener() {}
	
	public TablaDocumentoListener(TablaDocumento tabla) {
		this.tabla = tabla;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int fila = tabla.rowAtPoint(e.getPoint());
		String id = (String) tabla.getValueAt(fila, 0);
		
		if(BaseDatos.getUsuarioLogeado().getClass().getSimpleName().equals("Jefe")) {
			DocumentoOficio documentoOficio =BaseDatos.buscarDocumentoOficioPorID(id);
			new VtnDocumento(documentoOficio).setVisible(true);
		} else if (BaseDatos.getUsuarioLogeado().getClass().getSimpleName().equals("Empleado")) {
			new VtnDocumento(BaseDatos.buscarDocumentoInformativoPorID(id)).setVisible(true);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}
}
