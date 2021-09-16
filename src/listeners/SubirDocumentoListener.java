/**
 * Clase SubirDocumentoListener
 * 
 * Creado el 5 de septiembre, 2021, 15:00
 * 
 * @Author James Mendoza, Derian Paez
 * 
 * @Version POO SOF-S-NO-2-5 - 2021
 * 
 */

package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

public class SubirDocumentoListener implements ActionListener {
	private File archivo;
	private String rutaArchivo;
	private String extensionArchivo;
	private JTextField txtUbicacionArchivo;
	
	/**
	 * Constructor por defecto
	 */
	public SubirDocumentoListener() {}

	/**
	 * Constructor del escuchador de subir documento
	 * @param txtUbicacionArchivo
	 */
	public SubirDocumentoListener(JTextField txtUbicacionArchivo) {
		this.txtUbicacionArchivo = txtUbicacionArchivo;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			JFileChooser vtnSeleccionarArchivo = new JFileChooser();
			vtnSeleccionarArchivo.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			FileNameExtensionFilter imgFilter = new FileNameExtensionFilter("PDF & JPG Images", "pdf", "jpg");
			vtnSeleccionarArchivo.setFileFilter(imgFilter);
			int result = vtnSeleccionarArchivo.showOpenDialog(null);
			archivo = vtnSeleccionarArchivo.getSelectedFile();
			

		    if (result != JFileChooser.CANCEL_OPTION) {
		        if ((archivo == null) || (archivo.getName().equals(""))) {
		        	txtUbicacionArchivo.setText("");
		        } else {
		        	rutaArchivo = archivo.getPath();
		        	extensionArchivo = obtenerExtensionArchivo(rutaArchivo);
		        	validarArchivo();
		        	txtUbicacionArchivo.setText(rutaArchivo);
		        }
		    }
		    
		} catch (RuntimeException error) {
			JOptionPane.showMessageDialog(null, error.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		} catch (Exception errorRaro) {
			JOptionPane.showMessageDialog(null, errorRaro.getStackTrace(), "Error", JOptionPane.ERROR_MESSAGE);
		} 
	}
	
	/**
	 * Obtiene la extension del archivo
	 * @param ruta recibe ruta
	 * @return extension
	 */
	private String obtenerExtensionArchivo(String ruta) {
		String extension = "";
		int i = ruta.lastIndexOf('.');
		int p = Math.max(ruta.lastIndexOf('/'), ruta.lastIndexOf('\\'));
		if (i > p) {
		    extension = ruta.substring(i+1);
		}
		return extension;
	}
	
	/**
	 * valida el archivo
	 */
	private void validarArchivo() {
		String extension = extensionArchivo.toLowerCase();
		if(!extension.equals("pdf") && !extension.equals("jpg")) {
			throw new RuntimeException("Debe seleccionar archivos con extension .jpg o .pdf");
		}
	}
}
