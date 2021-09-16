/**
 * Clase TablaDocumento
 * 
 * Creado el 3 de septiembre, 2021, 15:00
 * 
 * @Author James Mendoza, Derian Paez
 * 
 * @Version POO SOF-S-NO-2-5 - 2021
 * 
 */

package gui;

import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelo.BaseDatos;
import modelo.Documento;
import modelo.DocumentoInformativo;
import modelo.DocumentoOficio;
import modelo.Serializacion;
import modelo.TipoDocumento;
import modelo.Usuario;

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
				if(lstDocumento.get(i).getTipo().equals(TipoDocumento.OFICIO) && BaseDatos.getUsuarioLogeado().getClass().getSimpleName().equals("Jefe")) {
					DocumentoOficio documento = (DocumentoOficio) lstDocumento.get(i);
					if(BaseDatos.getUsuarioLogeado().getNombreUsuario().equals(documento.getReceptor().getNombreUsuario())) {
						modelo.addRow(data);
						modelo.setValueAt(documento.getCodigo(), i, 0);
						modelo.setValueAt(documento.getTitulo(), i, 1);
						modelo.setValueAt(documento.getEmisor().getNombreUsuario(), i, 2);
						modelo.setValueAt(documento.getReceptor().getNombreUsuario(), i, 3);
						modelo.setValueAt(documento.getFechaCreacion(), i, 4);
						modelo.setValueAt(documento.getFechaCaducidad(), i, 5);
						modelo.setValueAt(documento.getEstado(), i, 6);
					}
				} else if(lstDocumento.get(i).getTipo().equals(TipoDocumento.INFORMATIVO) && BaseDatos.getUsuarioLogeado().getClass().getSimpleName().equals("Empleado")) {
					DocumentoInformativo documento = (DocumentoInformativo) lstDocumento.get(i);
					modelo.addRow(data);
					modelo.setValueAt(documento.getCodigo(), i, 0);
					modelo.setValueAt(documento.getTitulo(), i, 1);
				}
			}
		} 
	}
}
