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
	private JTextField txtUbicacionArchivo;
	private JTextField txtTipoDocumento;
	private EstadoDocumento estado;
	private TipoDocumento tipo; 
	private VtnSistema vtnSistema;
	private String rolLogeado;
	
	public DocumentoFormListener() {}
	
	public DocumentoFormListener(JTextField txtTitulo, JTextArea txtAreaDescripcion, 
			JTextField txtReceptor, JDateChooser fechaCaducidad, JTextField txtPalabrasClaves, 
			JTextField txtTipoDocumento, JTextField txtUbicacionArchivo, VtnCrearDocumento ventanaCrearDocumento, 
			VtnSistema vtnSistema) {
		this.txtTitulo = txtTitulo;
		this.txtAreaDescripcion = txtAreaDescripcion;
		this.txtReceptor = txtReceptor;
		this.fechaCaducidad = fechaCaducidad;
		this.txtPalabrasClaves = txtPalabrasClaves; 
		this.txtTipoDocumento = txtTipoDocumento;
		this.txtUbicacionArchivo = txtUbicacionArchivo;
		this.ventanaCrearDocumento = ventanaCrearDocumento;
		this.vtnSistema = vtnSistema;
		this.rolLogeado = BaseDatos.getUsuarioLogeado().getClass().getSimpleName();
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
			
			String rutaArchivo = txtUbicacionArchivo.getText();
			String tipoDocumentoString = txtTipoDocumento.getText();
			if(tipoDocumentoString.equals("Oficio")) {
				tipo = TipoDocumento.OFICIO;
			} else if(tipoDocumentoString.equals("Informativo")) {
				tipo = TipoDocumento.INFORMATIVO;
			}
			
			switch (rolLogeado) {
			case "Empleado":
				validarFormDocumentoOficio(titulo, descripcion, receptor, fechaCreacionString, fechaCaducidadString, palabrasClaves, rutaArchivo, tipo);
				// BaseDatos.crearDocumentoOficio();
				break;
			case "Jefe":
//				validarFormDocumentoInformativo();Emple
				// BaseDatos.crearDocumentoInformativo();
				break;
			default:
				break;
			}
			
			vtnSistema.getTablaDocumento().cargarTabla();
			ventanaCrearDocumento.dispose();
		} catch (Exception error) {
			JOptionPane.showMessageDialog(null, error.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void validarFormDocumentoOficio(String titulo, String descripcion, String receptor, String fechaCreacion, String fechaCaducidad, String palabrasClaves, String rutaArchivo, TipoDocumento tipo) throws ParseException{
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
		
		
        if(palabrasClaves.substring(palabrasClaves.length() - 1).equals(",")) {
        	throw new RuntimeException("Las palabras claves deben estar separadas por una coma sin espacios(,) Ejemplo: Palabra1,Palabra2,Palabra3  o Palabra1");
        }
		
		if(palabrasClaves.contains(" ")) {
			throw new RuntimeException("Las palabras claves deben estar separadas por una coma sin espacios(,) Ejemplo: Palabra1,Palabra2,Palabra3  o Palabra1");
		}
		
		if(palabrasClaves.contains(",")) {
			String palabrasClavesArray[] = palabrasClaves.split(",");
			for(int i = 0; i < palabrasClavesArray.length; i++) {
				if(palabrasClavesArray[i].isBlank()) {
					throw new RuntimeException("Debe escribir las palabras despues de cada coma (,) Ejemeplo: Palabra1,Palabra2,Palabra3");
				}
			}
		}
		
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		
		Date fechaCreacionDate = formato.parse(fechaCreacion);
		Date fechaCaducidadDate = formato.parse(fechaCaducidad);
		
		if(fechaCreacionDate.after(fechaCaducidadDate)){
			throw new RuntimeException("Fecha de caducidad es menor a la fecha de creacion, ingrese de nuevo la fecha.");
        } 
		
		String archivo = obtenerExtensionArchivo(rutaArchivo);
		String extension = archivo.toLowerCase();
		if(!extension.equals("pdf") && !extension.equals("jpg")) {
			throw new RuntimeException("Debe seleccionar archivos con extension .jpg o .pdf");
		}
		
		if(emisor.equals(receptor)) {
			throw new RuntimeException("No se puede enviar un documento a usted mismo, ingrese otro receptor");
		}
		
		if(BaseDatos.buscarUsuarioPorNombre(receptor) == null) {
			throw new RuntimeException("El usuario a receptar el documento no existe, ingrese de nuevo el receptor.");
		}
		
		if(!(BaseDatos.buscarUsuarioPorNombre(receptor).getClass().getSimpleName().equals("Jefe"))) {
			throw new RuntimeException("El usuario a receptar el documento debe ser Jefe, ingrese de nuevo el receptor.");
		}
	}
	
	private String obtenerExtensionArchivo(String ruta) {
		String extension = "";
		int i = ruta.lastIndexOf('.');
		int p = Math.max(ruta.lastIndexOf('/'), ruta.lastIndexOf('\\'));
		if (i > p) {
		    extension = ruta.substring(i+1);
		}
		return extension;
	}
	
    public int contarCaracteres(String cadena, char caracter) {
        int posicion;
        int contador = 0;
        
        posicion = cadena.indexOf(caracter);
        while (posicion != -1) {
            contador++;
            posicion = cadena.indexOf(caracter, posicion + 1);
        }
        return contador;
    }
}
