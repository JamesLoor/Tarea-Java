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
	private JTextField txtUbicacionArchivo;
	
	public SubirDocumentoListener() {}

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
			
			archivo = vtnSeleccionarArchivo.getSelectedFile();
			System.out.println("Hellouda");
//			rutaArchivo = archivo.getAbsolutePath();

//			System.out.println(rutaArchivo);
//			int result = vtnSeleccionarArchivo.showOpenDialog(this);
//		    if (result != JFileChooser.CANCEL_OPTION) {
//		        if ((fileName == null) || (fileName.getName().equals(""))) {
//		            txt.setText("...");
//		        } else {
//		            txt.setText(fileName.getAbsolutePath());
//		        }
//		    }
		    
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, e2.getStackTrace(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
