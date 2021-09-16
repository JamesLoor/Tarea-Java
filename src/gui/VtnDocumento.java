/**
 * Clase VtnDocumento
 * 
 * Creado el 3 de septiembre, 2021, 15:00
 * 
 * @Author James Mendoza, Derian Paez
 * 
 * @Version POO SOF-S-NO-2-5 - 2021
 * 
 */

package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class VtnDocumento extends JFrame{
	private JPanel contentPane;
	private JPanel pnlCenter;
	private JPanel pnlInfoNorth;
	private JPanel pnlInfoCenter;
	private JPanel pnlInfoSouth;
	
	private JPanel pnlSouth;
	private JPanel pnlSouthWest;
	private JPanel pnlSouthEast;
	
	private JLabel lblTitulo;
	private JLabel lblFecha;
	private JTextArea txtAreaDescripcion;
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
		initPnlInfoSouth();
		
		pnlCenter.setBorder(new EmptyBorder(30, 100, 0, 100));

		contentPane.add(pnlCenter, BorderLayout.CENTER);
		
	}
	
	private void initPnlInfoNorth() {
		pnlInfoNorth = new JPanel(new GridLayout(1, 2));
		
		lblTitulo = new JLabel("Titulo del mensaje", SwingConstants.CENTER);
		lblFecha = new JLabel("14/09/2021", SwingConstants.CENTER);
		
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 30));
		lblFecha.setFont(new Font("Arial", Font.BOLD, 23));
		
		pnlInfoNorth.add(lblTitulo);
		pnlInfoNorth.add(lblFecha);
		
		pnlCenter.add(pnlInfoNorth, BorderLayout.NORTH);
	}
	
	private void initPnlInfoCenter() {
		pnlInfoCenter = new JPanel(new BorderLayout());
		pnlInfoCenter.setBorder(new EmptyBorder(30, 0, 10, 0));
		
		txtAreaDescripcion = new JTextArea();

		txtAreaDescripcion.setLineWrap(true);
		txtAreaDescripcion.setWrapStyleWord(true);
		JScrollPane scrollTextArea = new JScrollPane(txtAreaDescripcion);
		txtAreaDescripcion.setEditable(false);
		txtAreaDescripcion.setText("Descripcion: Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
		
		Border border = BorderFactory.createLineBorder(new Color(135, 140, 150));
		txtAreaDescripcion.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		
		pnlInfoCenter.add(scrollTextArea, BorderLayout.CENTER);
		
		pnlCenter.add(pnlInfoCenter, BorderLayout.CENTER);
	}
	
	private void initPnlInfoSouth() {
		pnlInfoSouth = new JPanel(new GridLayout(6, 1));
		
		lblEmisor = new JLabel("De: John Doe");
		lblFechaCaducidad = new JLabel("Enviado: 20/09/2021");
		lblReceptor = new JLabel("Para: Administrador");
		lblPalabrasClaves = new JLabel("Palabras Claves: hola, pepas, agua");
		lblEstado = new JLabel("Estado: Pendiente");
		lblTipoDocumento = new JLabel("Tipo de documento: Oficio");
		
		pnlInfoSouth.add(lblEmisor);
		pnlInfoSouth.add(lblFechaCaducidad);
		pnlInfoSouth.add(lblReceptor);
		pnlInfoSouth.add(lblPalabrasClaves);
		pnlInfoSouth.add(lblEstado);
		pnlInfoSouth.add(lblTipoDocumento);
		
		pnlCenter.add(pnlInfoSouth, BorderLayout.SOUTH);
	}
	
	private void initPnlSouth() {
		pnlSouth = new JPanel(new GridLayout(1, 2));
		pnlSouthWest = new JPanel();
		pnlSouthEast = new JPanel();
		
		btnVolver = new JButton("Volver");
		btnAceptar = new JButton("Aceptar");
		btnRechazar = new JButton("Rechazar");
		
		btnVolver.setBackground(new Color(255, 255, 255));
		btnAceptar.setBackground(new Color(255, 255, 255));
		btnRechazar.setBackground(new Color(255, 255, 255));
		
		pnlSouthWest.add(btnVolver);
		pnlSouthEast.add(btnAceptar);
		pnlSouthEast.add(btnRechazar);
		
		pnlSouth.add(pnlSouthWest, BorderLayout.WEST);
		pnlSouth.add(pnlSouthEast, BorderLayout.EAST);
		
		pnlSouth.setBorder(new EmptyBorder(30, 0, 30, 0));
		
		contentPane.add(pnlSouth, BorderLayout.SOUTH);
	}
}
