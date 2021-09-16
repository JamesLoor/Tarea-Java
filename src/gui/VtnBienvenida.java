/**
 * Clase VtnBienvenida
 * 
 * Creado el 2 de septiembre, 2021, 14:38
 * 
 * @Author James Mendoza, Derian Paez
 * 
 * @Version POO SOF-S-NO-2-5 - 2021
 * 
 */

package gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.Font;
import listeners.LoginFormListener;

public class VtnBienvenida extends JFrame{
	private JPanel contentPane;
	private FondoBienvenida pnlIzquierda;
	private JPanel pnlDerecha;
	private JPanel pnlForm;
	private JPanel pnlFormNorth;
	private JPanel pnlFormCenter;
	private JPanel pnlFormSouth;
	private JLabel lblNorthForm;
	private JLabel lblNombreUsuario;
	private JLabel lblContraseña;
	private JTextField txtNombreUsuario;
	private JPasswordField pwContrasena;
	private JButton btnIniciarSesion;
	
	/**
	 * Constructor de la ventana de bienvenida
	 */
	public VtnBienvenida() {
		super("UG Mail");
		initComponents();
		addListeners();
	}
	
	/**
	 * Evento escuchador
	 */
	private void addListeners() {
		btnIniciarSesion.addActionListener(new LoginFormListener(txtNombreUsuario, pwContrasena, this));
	}
	
	/**
	 * Inicializa la ventana de bienvenida
	 */
	private void initComponents() {
		contentPane = new JPanel(new GridLayout());
		setContentPane(contentPane);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		
		initPnlIzquierda();
		initPnlDerecha();
	}
	
	/**
	 * Inicializa el panel de la izquierda
	 */
	private void initPnlIzquierda() {
		pnlIzquierda = new FondoBienvenida();
		contentPane.add(pnlIzquierda);
	}
	
	/**
	 * Inicializa el panel de la derecha
	 */
	private void initPnlDerecha() {
		pnlDerecha = new JPanel(new BorderLayout());
		pnlDerecha.setBackground(new Color(255, 255, 255));
		
		pnlDerecha.setBorder(new EmptyBorder(130, 85, 130, 85));
		
		initPnlForm();
		contentPane.add(pnlDerecha);
	}
	
	/**
	 * Inicializa el panel del formulario
	 */
	private void initPnlForm() {
		pnlForm = new JPanel(new BorderLayout(0, 25));
		pnlForm.setBackground(new Color(255, 255, 255));
		pnlForm.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(230, 230, 230), new Color(150, 150, 150)));
		
		initPnlFormNorth();
		initPnlFormCenter();
		initPnlFormSouth();
		
		pnlDerecha.add(pnlForm, BorderLayout.CENTER);
	}
	
	/**
	 * Inicializa el panel norte del formulario
	 */
	private void initPnlFormNorth() {
		pnlFormNorth = new JPanel();
		lblNorthForm = new JLabel("Iniciar Sesión");
		lblNorthForm.setFont(new Font("", Font.PLAIN, 25));
		pnlFormNorth.add(lblNorthForm);
		pnlForm.add(pnlFormNorth, BorderLayout.NORTH);
		
		pnlFormNorth.setBorder(new EmptyBorder(20, 0, 0, 0));
		pnlFormNorth.setBackground(Color.WHITE);
	}
	
	/**
	 * Inicializa el panel centro del formulario
	 */
	private void initPnlFormCenter() {
		pnlFormCenter = new JPanel();
		pnlFormCenter.setLayout(new GridLayout(4, 0, 0, 0));
		
		lblNombreUsuario = new JLabel("Nombre de usuario");
		lblContraseña = new JLabel("Contraseña");
		
		txtNombreUsuario = new JTextField(10);
		pwContrasena = new JPasswordField(10);
		
		pnlFormCenter.add(lblNombreUsuario);
		pnlFormCenter.add(txtNombreUsuario);
		pnlFormCenter.add(lblContraseña);
		pnlFormCenter.add(pwContrasena);
		
		pnlFormCenter.setBorder(new EmptyBorder(0, 20, 0, 20));
		pnlFormCenter.setBackground(Color.WHITE);
		
		pnlForm.add(pnlFormCenter, BorderLayout.CENTER);
	}
	
	/**
	 * Inicializa el panel sur del formulario
	 */
	private void initPnlFormSouth() {
		pnlFormSouth = new JPanel();
		btnIniciarSesion = new JButton("Iniciar Sesión");
		btnIniciarSesion.setBackground(new Color(255, 255, 255));
		pnlFormSouth.add(btnIniciarSesion);
		pnlForm.add(pnlFormSouth, BorderLayout.SOUTH);
		
		pnlFormSouth.setBorder(new EmptyBorder(0, 20, 20, 20));
		pnlFormSouth.setBackground(Color.WHITE);
	}
	
	public JButton getBtnIniciarSesion() {
		return btnIniciarSesion;
	}

	public void setBtnIniciarSesion(JButton btnIniciarSesion) {
		this.btnIniciarSesion = btnIniciarSesion;
	}
}
