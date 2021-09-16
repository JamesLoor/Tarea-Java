package listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import gui.TablaDocumento;

public class TablaDocumentoListener implements MouseListener {
	private TablaDocumento tabla;
	
	public TablaDocumentoListener() {}
	
	public TablaDocumentoListener(TablaDocumento tabla) {
		this.tabla = tabla;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int fila = tabla.rowAtPoint(e.getPoint());
		System.out.println(tabla.getValueAt(fila, 0));
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
