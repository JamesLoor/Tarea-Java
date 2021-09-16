package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import com.toedter.calendar.JDateChooser;
import listeners.DocumentoFormListener;
import listeners.SubirDocumentoListener;
import modelo.BaseDatos;

public class VtnCrearDocumento extends JDialog {
    private JPanel contentPane;
    private JPanel pnlCenter;
    private JPanel pnlFormCenter;
    private JPanel pnlFormSouth;
    private String rolLogeado;
    private VtnSistema vtnSistema;
    
    private JLabel lblTitulo;
    private JLabel lblDescripcion;
    private JLabel lblPalabrasClaves;
    private JLabel lblReceptor;
    private JLabel lblFechaCaducidad;
    private JLabel lblTipoDocumento;
    private JLabel lblRutaArchivo;
    private JLabel lblSubirDocumento;
    
    private JTextField txtTitulo;
    private JTextArea txtAreaDescripcion;
    private JTextField txtPalabrasClaves;
    private JTextField txtReceptor;
    private JDateChooser fechaCaducidad;
    private JTextField txtTipoDocumento;
    private JTextField txtRutaArchivo;
    
    private JButton btnAdjuntarDocumento;
    private JButton btnGuardarDocumento;
    
    public VtnCrearDocumento() {
    	this.rolLogeado = BaseDatos.getUsuarioLogeado().getClass().getSimpleName();
        initComponents();
        addListeners();
    }
   
    public VtnCrearDocumento(VtnSistema vtnSistema) {
    	this.vtnSistema = vtnSistema;
    	this.rolLogeado = BaseDatos.getUsuarioLogeado().getClass().getSimpleName();
        initComponents();
        addListeners();
    }

    private void addListeners() {
    	btnGuardarDocumento.addActionListener(new DocumentoFormListener(txtTitulo, txtAreaDescripcion, txtPalabrasClaves, fechaCaducidad, txtReceptor, txtTipoDocumento, txtRutaArchivo, this, vtnSistema));
    	btnAdjuntarDocumento.addActionListener(new SubirDocumentoListener(txtRutaArchivo));
    }
    
    private void initComponents() {
        contentPane = new JPanel(new GridLayout());
        setContentPane(contentPane);
        setModal(true);
        setSize(800, 400);
        setLocationRelativeTo(null);
        setResizable(false);
        
        initPnlCenter();
    }
    
    public void initPnlCenter() {
    	pnlCenter = new JPanel(new BorderLayout());
    	
    	initPnlFormCenter();
		initPnlFormSouth();
    	
    	contentPane.add(pnlCenter, BorderLayout.CENTER);
    }
    
    public void initPnlFormCenter() {
    	pnlFormCenter = new JPanel(new GridLayout(8, 2, 40, 0));
        
        lblPalabrasClaves = new JLabel("Palabras claves (Palabras separadas por coma y sin espacios)");
        lblTitulo = new JLabel("Titulo");
        lblDescripcion = new JLabel("Descripcion");
        lblReceptor = new JLabel((rolLogeado.equals("Empleado") ? "Receptor" : "Rol Receptor"));
        lblFechaCaducidad = new JLabel("Fecha de caducidad");
        lblTipoDocumento = new JLabel("Tipo de documento");
        lblRutaArchivo = new JLabel("Ruta del documento");
        lblSubirDocumento = new JLabel("Subir documento");
        
        txtRutaArchivo = new JTextField(20);
        txtRutaArchivo.setEditable(false);
        
        txtPalabrasClaves = new JTextField(20);
        txtTitulo = new JTextField(20);
        
        txtReceptor = new JTextField(20);
        if(rolLogeado.equals("Jefe")) {
        	txtReceptor.setEditable(false);
        	txtReceptor.setText("Empleado");
        }
        
        fechaCaducidad = new JDateChooser();
        fechaCaducidad.setDateFormatString("dd/MM/yyyy");
        
        txtAreaDescripcion = new JTextArea();
        txtAreaDescripcion.setLineWrap(true);
        txtAreaDescripcion.setWrapStyleWord(true);
        JScrollPane scrollTextArea = new JScrollPane(txtAreaDescripcion);
        
        txtTipoDocumento = new JTextField(20);
        txtTipoDocumento.setText((rolLogeado.equals("Empleado")) ? "Oficio" : "Informativo");
        txtTipoDocumento.setEditable(false);
		
		btnAdjuntarDocumento = new JButton("Adjuntar Documento");
		btnAdjuntarDocumento.setBackground(Color.WHITE);
		
		pnlFormCenter.add(lblPalabrasClaves);
		pnlFormCenter.add(lblTitulo);
		pnlFormCenter.add(txtPalabrasClaves);
		pnlFormCenter.add(txtTitulo);
		pnlFormCenter.add(lblDescripcion);
		pnlFormCenter.add(lblReceptor);
		pnlFormCenter.add(scrollTextArea);
		pnlFormCenter.add(txtReceptor);
		pnlFormCenter.add(lblFechaCaducidad);
		pnlFormCenter.add(lblTipoDocumento);
		pnlFormCenter.add(fechaCaducidad);
		pnlFormCenter.add(txtTipoDocumento);
		pnlFormCenter.add(lblRutaArchivo);
		pnlFormCenter.add(lblSubirDocumento);
		pnlFormCenter.add(txtRutaArchivo);
		pnlFormCenter.add(btnAdjuntarDocumento);
		
		Border border = BorderFactory.createLineBorder(new Color(135, 140, 150));
	    txtAreaDescripcion.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		
		pnlFormCenter.setBorder(new EmptyBorder(10, 20, 20, 20));
        pnlCenter.add(pnlFormCenter, BorderLayout.CENTER);
    }
    
    public void initPnlFormSouth() {
    	pnlFormSouth = new JPanel();
		
		btnGuardarDocumento = new JButton("Guardar Documento");
		btnGuardarDocumento.setBackground(Color.WHITE);
		
		pnlFormSouth.add(btnGuardarDocumento);
		pnlFormSouth.setBorder(new EmptyBorder(0, 0, 10, 0));
		
		pnlCenter.add(pnlFormSouth, BorderLayout.SOUTH);
    }
}