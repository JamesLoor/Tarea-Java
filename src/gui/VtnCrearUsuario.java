/**
 * Clase VtnCrearUsuario
 * 
 * Creado el 2 de septiembre, 2021, 15:00
 * 
 * @Author James Mendoza, Derian Paez
 * 
 * @Version POO SOF-S-NO-2-5 - 2021
 * 
 */

package gui;

import javax.swing.border.EmptyBorder;
import listeners.UsuarioFormListener;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VtnCrearUsuario extends JDialog {
	private JPanel contentPane;
	private JPanel pnlCenter;
	private JPanel pnlFormCenter;
	private JPanel pnlFormSouth;
	private JLabel lblNombreUsuario;
	private JLabel lblContrasena;
	private JLabel lblComprobarContrasena;
	private JLabel lblRol;
	private JTextField txtNombreUsuario;
	private JTextField txtContrasena;
	private JTextField txtComprobarContrasena;
	private JComboBox<String> ComboRol;
	private JButton btnGuardar;
	private VtnSistema vtnSistema;
	
	/**
	 * Constructor por defecto
	 */
	public VtnCrearUsuario() {}
	
	/**
	 * Constructor de la ventana de crear ususario que recibe vtnSistema
	 * @param vtnSistema
	 */
	public VtnCrearUsuario(VtnSistema vtnSistema) {
		this.vtnSistema = vtnSistema;
		initComponents();
		addListeners();
	}
	
	/**
	 * Evento escuchador
	 */
	private void addListeners() {
		btnGuardar.addActionListener(new UsuarioFormListener(txtNombreUsuario, txtContrasena, txtComprobarContrasena, ComboRol, this, vtnSistema));
	}
	
	/**
	 * Inicializa la ventana de crear usuario
	 */
	private void initComponents() {
		contentPane = new JPanel(new BorderLayout());
		setContentPane(contentPane);
		setSize(300, 400);
		setModal(true);
		setLocationRelativeTo(null);
		setResizable(false);
		
		initPnlCenter();
	}
	
	/**
	 * Inicializa el panel del centro
	 */
	private void initPnlCenter() {
		pnlCenter = new JPanel(new BorderLayout());
		
		initPnlFormCenter();
		initPnlFormSouth();
		
		contentPane.add(pnlCenter, BorderLayout.CENTER);
	}
	
	/**
	 * Inicializa el panel centro del formulario
	 */
	private void initPnlFormCenter() {
		pnlFormCenter = new JPanel(new GridLayout(8, 0));
		
		lblNombreUsuario = new JLabel("Nombre de usuario");
		lblContrasena = new JLabel("Contraseña");
		lblComprobarContrasena = new JLabel("Contraseña");
		lblRol = new JLabel("Rol");
		
		txtNombreUsuario = new JTextField(25);
		txtContrasena = new JTextField(25);
		txtComprobarContrasena = new JTextField(25);
		
		ComboRol = new JComboBox<String>();
		ComboRol.setModel(new DefaultComboBoxModel<>(new String[]{"Administrador", "Jefe", "Empleado"}));
		
		pnlFormCenter.add(lblNombreUsuario);
		pnlFormCenter.add(txtNombreUsuario);
		pnlFormCenter.add(lblContrasena);
		pnlFormCenter.add(txtContrasena);
		pnlFormCenter.add(lblComprobarContrasena);
		pnlFormCenter.add(txtComprobarContrasena);
		pnlFormCenter.add(lblRol);
		pnlFormCenter.add(ComboRol);
		
		pnlFormCenter.setBorder(new EmptyBorder(10, 20, 20, 20));
		
		pnlCenter.add(pnlFormCenter, BorderLayout.CENTER);
	}
	
	/**
	 * Incializa el panel sur del formulario
	 */
	private void initPnlFormSouth(){
		pnlFormSouth = new JPanel();
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBackground(Color.WHITE);
		
		pnlFormSouth.add(btnGuardar);
		pnlFormSouth.setBorder(new EmptyBorder(0, 0, 10, 0));
		
		pnlCenter.add(pnlFormSouth, BorderLayout.SOUTH);

	}
}
