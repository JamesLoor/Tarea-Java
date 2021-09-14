package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;

public class VtnDocumento extends JFrame{
	private JPanel contentPane;
	private JPanel pnlCenter;
	private JPanel pnlInfoNorth;
	private JPanel pnlInfoCenter;
	private JPanel pnlSouth;
	private JPanel pnlSouthWest;
	private JPanel pnlSouthEast;
	private JLabel lblTitulo;
	private JLabel lblFecha;
	private JLabel lblDescripcion;
	private JLabel lblEmisor;
	private JLabel lblFechaCaducidad;
	private JLabel lblReceptor;
	private JLabel lblPalabrasClaves;
	private JLabel lblEstado;
	private JLabel lblTipoDocumento;
	private JButton btnVolver;
	private JButton btnAceptar;
	private JButton btnRechazar;
	
	public VtnDocumento() {
		initComponents();
	}
	
	private void initComponents() {
		contentPane = new JPanel(new BorderLayout());
		setContentPane(contentPane);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		dispose();
		
		initPnlCenter();
		initPnlSouth();
	}
	
	private void initPnlCenter() {
		pnlCenter = new JPanel(new BorderLayout());
		
		initPnlInfoNorth();
		initPnlInfoCenter();
		
		contentPane.add(pnlCenter, BorderLayout.CENTER);
		
	}
	
	private void initPnlInfoNorth() {
		pnlInfoNorth = new JPanel(new GridLayout(1, 2));
		
		lblTitulo = new JLabel("Titulo del mensaje");
		lblFecha = new JLabel("14/09/2021");
		
		pnlInfoNorth.add(lblTitulo);
		pnlInfoNorth.add(lblFecha);
		
		pnlCenter.add(pnlInfoNorth, BorderLayout.NORTH);
	}
	
	private void initPnlInfoCenter() {
		pnlInfoCenter = new JPanel(new GridLayout(7, 1));
		
		lblEmisor = new JLabel("De: John Doe");
		lblFechaCaducidad = new JLabel("Enviado: 20/09/2021");
		lblReceptor = new JLabel("Para: Administrador");
		lblPalabrasClaves = new JLabel("Palabras Claves: hola, pepas, agua");
		lblEstado = new JLabel("Estado: Pendiente");
		lblTipoDocumento = new JLabel("Tipo de documento: Oficio");
		lblDescripcion = new JLabel("Descripcion: Descripcion del mensaje");
		
		pnlInfoCenter.add(lblEmisor);
		pnlInfoCenter.add(lblFechaCaducidad);
		pnlInfoCenter.add(lblReceptor);
		pnlInfoCenter.add(lblPalabrasClaves);
		pnlInfoCenter.add(lblEstado);
		pnlInfoCenter.add(lblTipoDocumento);
		pnlInfoCenter.add(lblDescripcion);
		
		pnlCenter.add(pnlInfoCenter, BorderLayout.CENTER);
	}
	
	private void initPnlSouth() {
		pnlSouth = new JPanel(new GridLayout(1, 2));
		pnlSouthWest = new JPanel();
		pnlSouthEast = new JPanel();
		
		btnVolver = new JButton("Volver");
		btnAceptar = new JButton("Aceptar");
		btnRechazar = new JButton("Rechazar");
		
		pnlSouthWest.add(btnVolver);
		pnlSouthEast.add(btnAceptar);
		pnlSouthEast.add(btnRechazar);
		
		pnlSouth.add(pnlSouthWest, BorderLayout.WEST);
		pnlSouth.add(pnlSouthEast, BorderLayout.EAST);
		
		contentPane.add(pnlSouth, BorderLayout.SOUTH);
	}
}
