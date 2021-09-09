package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VtnCrearUsuario extends JDialog {
	private JPanel contentPane;
	private JPanel pnlCenter;
	private JPanel pnlForm;
	private JLabel lblNombreUsuario;
	private JLabel lblContrasena;
	private JLabel lblComprobarContrasena;
	private JLabel lblRol;
	private JTextField txtNombreUsuario;
	private JTextField txtContrasena;
	private JTextField txtComprobarContrasena;
	private JTextField txtRol;
	private JButton btnGuardar;
	
	public VtnCrearUsuario() {
		initComponents();
	}
	
	private void initComponents() {
		contentPane = new JPanel(new BorderLayout());
		setContentPane(contentPane);
		setModal(true);
		setSize(1000, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		
		initPnlCenter();
	}
	
	private void initPnlCenter() {
		pnlCenter = new JPanel();
		contentPane.add(pnlCenter, BorderLayout.CENTER);
		
		initPnlForm();
	}
	
	private void initPnlForm() {
		pnlForm = new JPanel();
		pnlCenter.add(pnlForm);
		
		lblNombreUsuario = new JLabel("Nombre de usuario");
		lblContrasena = new JLabel("Contraseña");
		lblComprobarContrasena = new JLabel("Contraseña");
		lblRol = new JLabel("Rol");
		txtNombreUsuario = new JTextField(10);
		txtContrasena = new JTextField(10);
		txtComprobarContrasena = new JTextField(10);
		txtRol = new JTextField(10);
		
		pnlForm.add(lblNombreUsuario);
		pnlForm.add(txtNombreUsuario);
		pnlForm.add(lblContrasena);
		pnlForm.add(txtContrasena);
		pnlForm.add(lblComprobarContrasena);
		pnlForm.add(txtComprobarContrasena);
		pnlForm.add(lblRol);
		pnlForm.add(txtRol);
	}
}
