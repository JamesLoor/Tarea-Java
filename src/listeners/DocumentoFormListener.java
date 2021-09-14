package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import gui.VtnCrearDocumento;
import gui.VtnSistema;
import modelo.BaseDatos;
import modelo.EstadoDocumento;
import modelo.TipoDocumento;

public class DocumentoFormListener implements ActionListener {
	private VtnCrearDocumento ventanaCrearDocumento;
	private JTextField txtTitulo;
	private JTextArea txtAreaDescripcion;
	private String emisor;
	private JTextField txtReceptor;
	private JDateChooser fechaCaducidad;
	private JTextField txtPalabrasClaves;
	private String fechaCaducidadString;
	private JComboBox<String> comboTipoDocumento;
	private EstadoDocumento estado;
	private TipoDocumento tipo; 
	private VtnSistema vtnSistema;
	
	public DocumentoFormListener() {}
	
	public DocumentoFormListener(JTextField txtTitulo, JTextArea txtAreaDescripcion, 
			JTextField txtReceptor, JDateChooser fechaCaducidad, JTextField txtPalabrasClaves, 
			JComboBox<String> comboTipoDocumento, VtnCrearDocumento ventanaCrearDocumento, 
			VtnSistema vtnSistema) {
		this.txtTitulo = txtTitulo;
		this.txtAreaDescripcion = txtAreaDescripcion;
		this.txtReceptor = txtReceptor;
		this.fechaCaducidad = fechaCaducidad;
		this.txtPalabrasClaves = txtPalabrasClaves; 
		this.comboTipoDocumento = comboTipoDocumento;
		this.ventanaCrearDocumento = ventanaCrearDocumento;
		this.vtnSistema = vtnSistema;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			String titulo = txtTitulo.getText();
			String descripcion = txtAreaDescripcion.getText();
			emisor =  BaseDatos.getUsuarioLogeado().getNombreUsuario();
			String receptor = txtReceptor.getText();
			
			DateTimeFormatter fechaFormato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			String fechaCreacionString = fechaFormato.format(LocalDateTime.now());
			
			if(fechaCaducidad.getDate() != null) {
				Date fecha = fechaCaducidad.getDate();
				SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
				fechaCaducidadString = formato.format(fecha);
			} else {
				fechaCaducidadString = "";
			}
			
			String palabrasClaves = txtPalabrasClaves.getText();
			estado = EstadoDocumento.ENVIADO;
			
			String tipoDocumentoString = (String) comboTipoDocumento.getSelectedItem();
			
			if(tipoDocumentoString.equals("Oficio")) {
				tipo = TipoDocumento.OFICIO;
			} else if(tipoDocumentoString.equals("Informativo")) {
				tipo = TipoDocumento.INFORMATIVO;
			}
			
			validarFormDocumento(titulo, descripcion, receptor, fechaCreacionString, fechaCaducidadString, palabrasClaves, tipo);
			
//			BaseDatos.crearUsuario(rol, nombreDeUuario, contrasena);
//			vtnSistema.getTablaUsuario().cargarTabla();
//			vtnSistema.getTablaDocumento().cargarTabla();
			ventanaCrearDocumento.dispose();
		} catch (Exception error) {
			JOptionPane.showMessageDialog(null, error.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void validarFormDocumento(String titulo, String descripcion, String receptor, String fechaCreacion, String fechaCaducidad, String palabrasClaves, TipoDocumento tipo) throws ParseException{
		if(titulo.isEmpty() && descripcion.isEmpty() && receptor.isEmpty() && fechaCaducidad.isEmpty() && palabrasClaves.isEmpty()) {
			throw new RuntimeException("Debe ingresar la informacion del documento a registrar.");
		} else if(titulo.isEmpty() && descripcion.isEmpty() && receptor.isEmpty() && fechaCaducidad.isEmpty()) {
			throw new RuntimeException("Debe ingresar titulo, descripcion, receptor y fecha de caducidad del documento");
		} else if(titulo.isEmpty() && descripcion.isEmpty() && receptor.isEmpty()) {
			throw new RuntimeException("Debe ingresar titulo, descripcion y receptor del documento");
		} else if(titulo.isEmpty() && descripcion.isEmpty()) {
			throw new RuntimeException("Debe ingresar titulo y descripcion");
		} else if(titulo.isEmpty()) {
			throw new RuntimeException("Debe ingresar titulo del documento");
		} else if(descripcion.isEmpty()) {
			throw new RuntimeException("Debe ingresar descripcion del documento");
		} else if(receptor.isEmpty()) {
			throw new RuntimeException("Debe ingresar receptor del documento");
		} else if(fechaCaducidad.isEmpty()) {
			throw new RuntimeException("Debe ingresar fecha de caducidad del documento");
		} else if(palabrasClaves.isEmpty()) {
			throw new RuntimeException("Debe ingresar palabras claves del documento");
		}
		
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		
		Date fechaCreacionDate = formato.parse(fechaCreacion);
		Date fechaCaducidadDate = formato.parse(fechaCaducidad);
		
		if(fechaCreacionDate.after(fechaCaducidadDate)){
			throw new RuntimeException("Fecha de caducidad es menor a la fecha de creacion, ingrese de nuevo la fecha.");
        } 
		
		if(emisor.equals(receptor)) {
			throw new RuntimeException("No se puede enviar un documento a usted mismo, ingrese otro receptor");
		}
		
		if(BaseDatos.buscarUsuarioPorNombre(receptor) == null) {
			throw new RuntimeException("El usuario a receptar el documento no existe, ingrese de nuevo el receptor.");
		}
	}
}
