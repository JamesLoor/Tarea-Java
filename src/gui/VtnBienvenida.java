package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import gui.FondoBienvenida;

public class VtnBienvenida extends JFrame{
	private JPanel contentPane;
	private FondoBienvenida pnlCenter;
	private JPanel pnlEast;
	private JPanel pnlForm;
	private JPanel pnlFormNorth;
	private JPanel pnlFormCenter;
	private JPanel pnlFormSouth;
	private JLabel lblCenter;
	private JLabel lblNorthForm;
	private JLabel lblNombreUsuario;
	private JLabel lblContraseña;
	private JTextField txtNombreUsuario;
	private JPasswordField pwContraseña;
	private JButton btnIniciarSesion;
	
	public VtnBienvenida() {
		super("Sistema UG");
		initComponents();
//		addListeners();
	}
	
	private void initComponents() {
		contentPane = new JPanel(new BorderLayout());
		setContentPane(contentPane);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 600);
		setLocationRelativeTo(null);
		setMinimumSize(new Dimension(1000, 600));
		
		initPnlCenter();
		initPnlEast();
	}
	
	private void initPnlCenter() {
		pnlCenter = new FondoBienvenida();
		contentPane.add(pnlCenter, BorderLayout.CENTER);
	}
	
	private void initPnlEast() {
		pnlEast = new JPanel(new BorderLayout());
		pnlEast.setBackground(new Color(255, 255, 255));
		pnlEast.setBorder(new EmptyBorder(200, 0, 200, 0));
		
		initPnlForm();
		contentPane.add(pnlEast, BorderLayout.EAST);
	}
	
	private void initPnlForm() {
		pnlForm = new JPanel(new BorderLayout());
		pnlFormNorth = new JPanel();
		pnlFormCenter = new JPanel();
		pnlFormSouth = new JPanel();
		
		lblNorthForm = new JLabel("Iniciar Sesion");
		
		lblNombreUsuario = new JLabel("Nombre de usuario");
		lblContraseña = new JLabel("Contraseña");
		txtNombreUsuario = new JTextField(10);
		pwContraseña = new JPasswordField(10);
		
		btnIniciarSesion = new JButton("Iniciar Sesion");
		
		pnlForm.setBackground(new Color(203, 235, 235));
		pnlForm.add(pnlFormNorth, BorderLayout.NORTH);
		pnlForm.add(pnlFormCenter, BorderLayout.CENTER);
		pnlForm.add(pnlFormSouth, BorderLayout.SOUTH);
		
		pnlFormNorth.add(lblNorthForm);
		
		pnlFormCenter.setLayout(new GridLayout(4, 0, 0, 0));
		pnlFormCenter.add(lblNombreUsuario);
		pnlFormCenter.add(txtNombreUsuario);
		pnlFormCenter.add(lblContraseña);
		pnlFormCenter.add(pwContraseña);
		
		pnlFormSouth.add(btnIniciarSesion);
		
		pnlEast.add(pnlForm, BorderLayout.CENTER);
	}
	
	
}
