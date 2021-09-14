package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import listeners.EliminarUsuarioFormListener;

public class VtnEliminarDocumento extends JDialog {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel pnlCenter;
	private JPanel pnlFormCenter;
	private JPanel pnlFormSouth;
	private JLabel lblCodigo;
	private JLabel lblTitulo;
	private JTextField txtCodigo;
	private JTextField txtTitulo;
	private JButton btnEliminar;
	
	public VtnEliminarDocumento() {
		initComponents();
		addListeners();
	}
	
	private void addListeners() {
//		btnEliminar.addActionListener(new EliminarUsuarioFormListener(txtCodigo, txtNombreUsuario, this, vtnSistema));
	}
	
	private void initComponents() {
		contentPane = new JPanel(new BorderLayout());
		setContentPane(contentPane);
		setSize(300, 300);
		setModal(true);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Eliminar Documento");
		
		initPnlCenter();
	}
	
	private void initPnlCenter() {
		pnlCenter = new JPanel(new BorderLayout());
		
		initPnlFormCenter();
		initPnlFormSouth();
		
		contentPane.add(pnlCenter, BorderLayout.CENTER);
	}
	
	private void initPnlFormCenter() {
		pnlFormCenter = new JPanel(new GridLayout(4, 1));
		
		lblCodigo = new JLabel("Codigo");
		lblTitulo = new JLabel("Titulo");
		
		txtCodigo = new JTextField(25);
		txtTitulo = new JTextField(25);
		
		pnlFormCenter.add(lblCodigo);
		pnlFormCenter.add(txtCodigo);
		pnlFormCenter.add(lblTitulo);
		pnlFormCenter.add(txtTitulo);
		
		pnlFormCenter.setBorder(new EmptyBorder(10, 20, 20, 20));
		pnlCenter.add(pnlFormCenter, BorderLayout.CENTER);
	}
	
	private void initPnlFormSouth() {
		pnlFormSouth = new JPanel();
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBackground(Color.WHITE);
		
		pnlFormSouth.add(btnEliminar);
		pnlFormSouth.setBorder(new EmptyBorder(0, 0, 10, 0));
		
		pnlCenter.add(pnlFormSouth, BorderLayout.SOUTH);
	}
	
	
}
