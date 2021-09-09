package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import listeners.LoginFormListener;
import listeners.UsuarioFormListener;

import java.awt.*;

import javax.swing.JButton;
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
	
	public VtnCrearUsuario() {
		initComponents();
		addListeners();
	}
	
	private void addListeners() {
		btnGuardar.addActionListener(new UsuarioFormListener(txtNombreUsuario, txtContrasena, txtComprobarContrasena, ComboRol, this));
	}
	
	private void initComponents() {
		contentPane = new JPanel(new BorderLayout());
		setContentPane(contentPane);
		setSize(300, 400);
		setModal(true);
		setLocationRelativeTo(null);
		setResizable(false);
		
		initPnlCenter();
	}
	
	private void initPnlCenter() {
		pnlCenter = new JPanel(new BorderLayout());
		
		initPnlFormCenter();
		initPnlFormSouth();
		
		contentPane.add(pnlCenter, BorderLayout.CENTER);
	}
	
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
		ComboRol.setModel(new DefaultComboBoxModel<>(new String[]{"Administrador", "Jefe", "Subordinado"}));
		
		
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
	
	private void initPnlFormSouth(){
		pnlFormSouth = new JPanel();
		
		btnGuardar = new JButton("Guardar");
		
		btnGuardar.setBackground(Color.WHITE);
		
		pnlFormSouth.add(btnGuardar);
		
		pnlFormSouth.setBorder(new EmptyBorder(0, 0, 10, 0));
		
		pnlCenter.add(pnlFormSouth, BorderLayout.SOUTH);

	}
}
