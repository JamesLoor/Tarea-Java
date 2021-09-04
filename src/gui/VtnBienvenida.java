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
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
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
		contentPane = new JPanel(new GridLayout());
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
		contentPane.add(pnlCenter);
	}
	
	private void initPnlEast() {
		pnlEast = new JPanel(new BorderLayout());
		pnlEast.setBackground(new Color(255, 255, 255));
		
		//Padding para centrar el cuadro de inicio de sesion
		pnlEast.setBorder(new EmptyBorder(130, 85, 130, 85));
		
		initPnlForm();
		contentPane.add(pnlEast, BorderLayout.EAST);
	}
	
	private void initPnlForm() {
		pnlForm = new JPanel(new BorderLayout(0, 25));
		pnlForm.setBackground(new Color(255, 255, 255));
		pnlForm.setBorder(new BevelBorder(BevelBorder.RAISED));
//		pnlForm.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(230, 230, 230), new Color(150, 150, 150)));
		
		//Panel Norte
		pnlFormNorth = new JPanel();
		lblNorthForm = new JLabel("Iniciar Sesion");
		pnlFormNorth.add(lblNorthForm);
		pnlForm.add(pnlFormNorth, BorderLayout.NORTH);
		
		//Panel Centro
		pnlFormCenter = new JPanel();
		pnlFormCenter.setLayout(new GridLayout(4, 0, 0, 0));
		lblNombreUsuario = new JLabel("Nombre de usuario");
		txtNombreUsuario = new JTextField(10);
		lblContraseña = new JLabel("Contraseña");
		pwContraseña = new JPasswordField(10);
		pnlFormCenter.add(lblNombreUsuario);
		pnlFormCenter.add(txtNombreUsuario);
		pnlFormCenter.add(lblContraseña);
		pnlFormCenter.add(pwContraseña);
		pnlForm.add(pnlFormCenter, BorderLayout.CENTER);
		
		//Panel Sur
		pnlFormSouth = new JPanel();
		btnIniciarSesion = new JButton("Iniciar Sesion");
		pnlFormSouth.add(btnIniciarSesion);
		pnlForm.add(pnlFormSouth, BorderLayout.SOUTH);
		
		//padding interno al cuadro de inicio de sesion
		pnlFormNorth.setBorder(new EmptyBorder(20, 0, 0, 0));
		pnlFormCenter.setBorder(new EmptyBorder(0, 20, 0, 20));
		pnlFormSouth.setBorder(new EmptyBorder(0, 0, 20, 0));
		
		//color de fondo del cuadro de inicio de sesion
		pnlFormNorth.setBackground(Color.WHITE);
		pnlFormCenter.setBackground(Color.WHITE);
		pnlFormSouth.setBackground(Color.WHITE);
		
		pnlEast.add(pnlForm, BorderLayout.CENTER);
	}
	
	
}
