package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import listeners.DocumentoFormListener;

public class VtnCrearDocumento extends JDialog {
    private JPanel contentPane;
    private VtnSistema vtnSistema;
    private JPanel pnlCenter;
    private JPanel pnlFormCenter;
    private JPanel pnlFormSouth;
    private JLabel lblPalabrasClaves;
    private JLabel lblTitulo;
    private JLabel lblDescripcion;
    private JLabel lblReceptor;
    private JLabel lblFechaCaducidad;
    private JLabel lblTipoDocumento;
    private JTextField txtPalabrasClaves;
    private JTextField txtTitulo;
    private JTextField txtReceptor;
    private JDateChooser fechaCaducidad;
    private JTextArea txtAreaDescripcion;
    private JComboBox<String> comboTipoDocumento;
    private JButton btnAdjuntarDocumento;
    private JButton btnGuardarDocumento;
    
    public VtnCrearDocumento() {
        initComponents();
        addListeners();
    }
    
    public VtnCrearDocumento(VtnSistema vtnSistema) {
    	this.vtnSistema = vtnSistema;
        initComponents();
        addListeners();
    }

    private void addListeners() {
    	btnGuardarDocumento.addActionListener(new DocumentoFormListener(txtTitulo, txtAreaDescripcion, txtReceptor, fechaCaducidad, txtPalabrasClaves, comboTipoDocumento, this, vtnSistema));
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
    	pnlFormCenter = new JPanel(new GridLayout(6, 2, 40, 0));
        
        lblPalabrasClaves = new JLabel("Palabras claves (Palabras separadas por coma)");
        lblTitulo = new JLabel("Titulo");
        lblDescripcion = new JLabel("Descripcion");
        lblReceptor = new JLabel("Receptor");
        lblFechaCaducidad = new JLabel("Fecha de caducidad");
        lblTipoDocumento = new JLabel("Tipo de documento");
        
        txtPalabrasClaves = new JTextField(20);
        txtTitulo = new JTextField(20);
        txtReceptor = new JTextField(20);
        
        fechaCaducidad = new JDateChooser();
        fechaCaducidad.setDateFormatString("dd/MM/yyyy");
        
        txtAreaDescripcion = new JTextArea();
        
        comboTipoDocumento = new JComboBox<String>();
		comboTipoDocumento.setModel(new DefaultComboBoxModel<>(new String[]{"Oficio", "Informativo"}));
		
		pnlFormCenter.add(lblPalabrasClaves);
		pnlFormCenter.add(lblTitulo);
		pnlFormCenter.add(txtPalabrasClaves);
		pnlFormCenter.add(txtTitulo);
		pnlFormCenter.add(lblDescripcion);
		pnlFormCenter.add(lblReceptor);
		pnlFormCenter.add(txtAreaDescripcion);
		pnlFormCenter.add(txtReceptor);
		pnlFormCenter.add(lblFechaCaducidad);
		pnlFormCenter.add(lblTipoDocumento);
		pnlFormCenter.add(fechaCaducidad);
		pnlFormCenter.add(comboTipoDocumento);
		
		Border border = BorderFactory.createLineBorder(new Color(135, 140, 150));
	    txtAreaDescripcion.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		
		pnlFormCenter.setBorder(new EmptyBorder(10, 20, 20, 20));
        pnlCenter.add(pnlFormCenter, BorderLayout.CENTER);
        
    }
    
    public void initPnlFormSouth() {
    	pnlFormSouth = new JPanel();
		
		btnGuardarDocumento = new JButton("Guardar Documento");
		btnGuardarDocumento.setBackground(Color.WHITE);
		
		btnAdjuntarDocumento = new JButton("Adjuntar Documento");
		btnAdjuntarDocumento.setBackground(Color.WHITE);
		
		pnlFormSouth.add(btnGuardarDocumento);
		pnlFormSouth.add(btnAdjuntarDocumento);
		pnlFormSouth.setBorder(new EmptyBorder(0, 0, 10, 0));
		
		pnlCenter.add(pnlFormSouth, BorderLayout.SOUTH);
    }
}