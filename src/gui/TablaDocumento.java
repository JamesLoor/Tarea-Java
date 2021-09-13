package gui;

import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelo.Documento;
import modelo.Serializacion;

public class TablaDocumento extends JTable {
	private static final long serialVersionUID = 1L;
	private String cabecera[] = {"Codigo", "Titulo", "Emisor", "Receptor", "F. Creacion", "F. Caducidad", "Estado"};
	private Object data[][];
	private DefaultTableModel modelo;
	
	public TablaDocumento() {
		initComponents();
	}
	
	private void initComponents() {
		modelo = new DefaultTableModel(null, cabecera);
		cargarTabla();
		setModel(modelo);
		setEnabled(false);
		setDragEnabled(false);
		getTableHeader().setEnabled(false);
	}
	
	public void cargarTabla() {
		modelo.setRowCount(0);
		data = null;
		List<Documento> lstDocumento = Serializacion.leerListaDocumento();
		if(lstDocumento != null) {
			for(int i = 0; i < lstDocumento.size(); i++) {
				Documento documento = lstDocumento.get(i);
				modelo.addRow(data);
				modelo.setValueAt(documento.getCodigo(), i, 0);
			}
		} 
	}
}
