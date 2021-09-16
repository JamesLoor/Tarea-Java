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

import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.BaseDatos;
import modelo.Documento;
import modelo.DocumentoInformativo;
import modelo.DocumentoOficio;
import modelo.Serializacion;
import modelo.TipoDocumento;

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
		List<DocumentoOficio> lstDocumentoOficio = null;
		List<DocumentoInformativo> lstDocumentoInformativo = null;
		
		if(lstDocumento != null) {
			for(int i = 0; i < lstDocumento.size(); i++) {
				if(lstDocumento.get(i).getTipo().equals(TipoDocumento.OFICIO)) {
					if(lstDocumentoOficio == null) lstDocumentoOficio = new ArrayList<DocumentoOficio>();
					lstDocumentoOficio.add((DocumentoOficio) lstDocumento.get(i));
				}
				
				if(lstDocumento.get(i).getTipo().equals(TipoDocumento.INFORMATIVO)) {
					if(lstDocumentoInformativo == null) lstDocumentoInformativo = new ArrayList<DocumentoInformativo>();
					lstDocumentoInformativo.add((DocumentoInformativo) lstDocumento.get(i));
				}
			}
		}
		
		boolean esJefeElUsuarioLogeado = BaseDatos.getUsuarioLogeado().getClass().getSimpleName().equals("Jefe");
		boolean esEmpleadoElUsuarioLogeado = BaseDatos.getUsuarioLogeado().getClass().getSimpleName().equals("Empleado");
		int k = 0;
				
		if(esJefeElUsuarioLogeado && lstDocumentoOficio != null) {
			modelo.setRowCount(0);
			for(int j = 0; j < lstDocumentoOficio.size(); j++) {
				DocumentoOficio documento = lstDocumentoOficio.get(j);
				boolean esEnviadoParaElUsuarioLogeado = BaseDatos.getUsuarioLogeado().getNombreUsuario().equals(documento.getReceptor().getNombreUsuario());
				if(esEnviadoParaElUsuarioLogeado) {
					modelo.addRow(data);
					modelo.setValueAt(documento.getCodigo(), k, 0);
					modelo.setValueAt(documento.getTitulo(), k, 1);
					modelo.setValueAt(documento.getEmisor().getNombreUsuario(), k, 2);
					modelo.setValueAt(documento.getReceptor().getNombreUsuario(), k, 3);
					modelo.setValueAt(documento.getFechaCreacion(), k, 4);
					modelo.setValueAt(documento.getFechaCaducidad(), k, 5);
					modelo.setValueAt(documento.getEstado(), k++, 6);
				}
			}
		} else if(esEmpleadoElUsuarioLogeado && lstDocumentoInformativo != null) {
			for(int i = 0; i < lstDocumentoInformativo.size(); i++) {
				DocumentoInformativo documento = lstDocumentoInformativo.get(i);
				modelo.addRow(data);
				modelo.setValueAt(documento.getCodigo(), i, 0);
				modelo.setValueAt(documento.getTitulo(), i, 1);
				modelo.setValueAt(documento.getEmisor().getNombreUsuario(), i, 2);
				modelo.setValueAt(documento.getRolReceptor(), i, 3);
				modelo.setValueAt(documento.getFechaCreacion(), i, 4);
				modelo.setValueAt(documento.getFechaCaducidad(), i, 5);
				modelo.setValueAt("ENVIADO", i, 6);
			}
		}
	}
}
