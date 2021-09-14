package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import gui.VtnCrearDocumento;
import gui.VtnSistema;

public class DocumentoFormListener implements ActionListener {
	private VtnCrearDocumento ventanaCrearDocumento;
	private VtnSistema vtnSistema;
	
	public DocumentoFormListener() {}
	
	public DocumentoFormListener(VtnCrearDocumento ventanaCrearDocumento, VtnSistema vtnSistema) {
		this.ventanaCrearDocumento = ventanaCrearDocumento;
		this.vtnSistema = vtnSistema;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
//			String nombreDeUsuario = txtNombreUsuario.getText();
//			String contrasena = txtContrasena.getText();
//			String comprobarContrasena = txtComprobarContrasena.getText();
//			String rol = (String) ComboRol.getSelectedItem();
			System.out.println("Vas a crear un nuevo documento");
			validarFormDocumento();
			
//			BaseDatos.crearUsuario(rol, nombreDeUsuario, contrasena);
//			vtnSistema.getTablaUsuario().cargarTabla();
//			vtnSistema.getTablaDocumento().cargarTabla();
//			ventanaCrearUsuario.dispose();
		} catch (Exception error) {
			JOptionPane.showMessageDialog(null, error.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void validarFormDocumento() {
//		if(nombreDeUsuario.isEmpty() && contrasena.isEmpty() && comprobarContrasena.isEmpty()) {
//			throw new RuntimeException("Debe ingresar nombre de usuario, contrasena y contrasena de comprobacion.");
//		} else if(nombreDeUsuario.isEmpty()) {
//			throw new RuntimeException("Debe ingresar nombre de usuario");
//		} else if(contrasena.isEmpty()) {
//			throw new RuntimeException("Debe ingresar contrasena");
//		} else if(comprobarContrasena.isEmpty()) {
//			throw new RuntimeException("Debe ingresar contraseña de comprobacion");
//		}
//		
//		if(!contrasena.equals(comprobarContrasena)) {
//			throw new RuntimeException("Las contrasenas ingresadas no son iguales");
//		}
//		
//		if(BaseDatos.buscarUsuarioPorNombre(nombreDeUsuario) != null) {
//			throw new RuntimeException("El nombre de usuario ya ah sido escogido, intente con otro nombre");
//		}
	}
}
