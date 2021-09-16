/**
 * Clase EliminarDocumentoFormListener
 * 
 * Creado el 4 de septiembre, 2021, 15:00
 * 
 * @Author James Mendoza, Derian Paez
 * 
 * @Version POO SOF-S-NO-2-5 - 2021
 * 
 */

package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import gui.VtnEliminarDocumento;
import gui.VtnEliminarUsuario;
import gui.VtnSistema;
import modelo.BaseDatos;

public class EliminarDocumentoFormListener implements ActionListener {
	private JTextField txtCodigo;
	private JTextField txtTitulo;
	private VtnEliminarDocumento ventanaEliminarDocumento;
	private VtnSistema vtnSistema;
	
	public EliminarDocumentoFormListener() {}
	
	public EliminarDocumentoFormListener(JTextField txtCodigo, JTextField txtTitulo, VtnEliminarDocumento ventanaEliminarDocumento, VtnSistema vtnSistema) {
		this.txtCodigo = txtCodigo;
		this.txtTitulo = txtTitulo;
		this.ventanaEliminarDocumento = ventanaEliminarDocumento;
		this.vtnSistema = vtnSistema;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			String codigo = txtCodigo.getText();
			String titulo = txtTitulo.getText();
			
			validarFormEliminarUsuario(codigo, titulo);
			
			BaseDatos.eliminarDocumento(codigo);
			vtnSistema.getTablaDocumento().cargarTabla();
			ventanaEliminarDocumento.dispose();
		} catch (Exception error) {
			JOptionPane.showMessageDialog(null, error.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void validarFormEliminarUsuario(String codigo, String titulo) {
		if(titulo.isEmpty() && codigo.isEmpty()) {
			throw new RuntimeException("Debe ingresar el titulo y codigo del documento a eliminar.");
		} else if(titulo.isEmpty()) {
			throw new RuntimeException("Debe ingresar el titulo del documento a eliminar");
		} else if(codigo.isEmpty()) {
			throw new RuntimeException("Debe ingresar el codigo del documento a eliminar");
		}
		
		if(BaseDatos.buscarDocumentoPorID(codigo) == null) {
			throw new RuntimeException("El documento a eliminar no existe, porfavor ingrese un codigo de documento ya registrado.");
		}
		
		if(BaseDatos.buscarDocumentoPorID(codigo).getTitulo().equals(titulo)) {
			throw new RuntimeException("El documento a eliminar no existe, porfavor ingrese un titulo de documento ya registrado.");
		}
	}
}
