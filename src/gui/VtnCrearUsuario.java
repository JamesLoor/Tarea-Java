package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VtnCrearUsuario extends JFrame {
	private JPanel contentPane;
	private JPanel pnlCenter;
	private JPanel pnlForm;
	private JLabel lblNombreUsario;
	private JLabel lblContrasena;
	private JLabel lblComprobarContrasena;
	private JLabel lblRol;
	private JTextField txtNombreUsuario;
	private JTextField txtContrasena;
	private JTextField txtComprobarContrasena;
	private JTextField txtRol;
	private JButton btnGuardar;
	
	
	public VtnCrearUsuario() {
		super("Crear Usuario");
		initComponents();
	}
	
	private void initComponents() {
		contentPane = new JPanel(new BorderLayout());
		setContentPane(contentPane);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		
		initPnlCenter();
	}
	
	private void initPnlCenter() {
		JPanel pnlCenter = new JPanel();
		contentPane.add(pnlCenter, BorderLayout.CENTER);
		
		initPnlForm();
	}
	
	private void initPnlForm() {
		JPanel pnlForm = new JPanel();
		pnlCenter.add(pnlForm);
		
		JLabel lblNombreUsuario = new JLabel("Nombre de usuario");
		JLabel lblContrasena = new JLabel("Contraseña");
		JLabel lblComprobarContrasena = new JLabel("Contraseña");
		JLabel lblRol = new JLabel("Rol");
		JTextField txtNombreUsuario = new JTextField(10);
		JTextField txtContrasena = new JTextField(10);
		JTextField txtComprobarContrasena = new JTextField(10);
		JTextField txtRol = new JTextField(10);
		
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
