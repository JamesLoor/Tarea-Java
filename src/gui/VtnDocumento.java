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

import listeners.DocumentoListener;
import modelo.DocumentoInformativo;
import modelo.DocumentoOficio;

import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;

public class VtnDocumento extends JDialog {
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
	
	private DocumentoOficio documentoOficio;
	private DocumentoInformativo documentoInformativo;
	private String documentoPresentar;
	
	public VtnDocumento() {
		initComponents();
		addListeners();
	}
	
	public VtnDocumento(DocumentoOficio documentoOficio) {
		this.documentoOficio = documentoOficio;
		this.documentoPresentar = "DocumentoOficio";
		initComponents();
		addListeners();
	}
	
	public VtnDocumento(DocumentoInformativo documentoInformativo) {
		this.documentoInformativo = documentoInformativo;
		this.documentoPresentar = "DocumentoInformativo";
		initComponents();
		addListeners();
	}
	
	private void addListeners() {
		if(documentoPresentar.equals("DocumentoOficio")) {
			
		} else if (documentoPresentar.equals("DocumentoInformativo")) {
			
		}
		btnVolver.addActionListener(new DocumentoListener(this));
	}
	
	private void initComponents() {
		contentPane = new JPanel(new BorderLayout());
		setContentPane(contentPane);
		setSize(600, 500);
		setModal(true);
		setLocationRelativeTo(null);
		setResizable(false);
		
		initPnlCenter();
		
		if(documentoPresentar.equals("DocumentoOficio")) {
			initPnlSouthOficio();			
		} else if (documentoPresentar.equals("DocumentoInformativo")) {
			initPnlSouthInformativo();
		}
	}
	
	private void initPnlCenter() {
		pnlCenter = new JPanel(new BorderLayout());
		initPnlInfoNorth();
		initPnlInfoCenter();
		initPnlInfoSouth();			
		
		pnlCenter.setBorder(new EmptyBorder(30, 10, 0, 10));
		contentPane.add(pnlCenter, BorderLayout.CENTER);
	}
	
	private void initPnlInfoNorth() {
		pnlInfoNorth = new JPanel(new GridLayout(1, 2));
		
		lblTitulo = new JLabel((documentoPresentar.equals("DocumentoOficio")) ? documentoOficio.getTitulo() : documentoInformativo.getTitulo(), SwingConstants.CENTER);
		lblFecha = new JLabel((documentoPresentar.equals("DocumentoOficio")) ? documentoOficio.getFechaCreacion() : documentoInformativo.getFechaCreacion(), SwingConstants.CENTER);
		
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
		txtAreaDescripcion.setText((documentoPresentar.equals("DocumentoOficio")) ? documentoOficio.getDescripcion() : documentoInformativo.getDescripcion());
		
		Border border = BorderFactory.createLineBorder(new Color(135, 140, 150));
		txtAreaDescripcion.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		
		pnlInfoCenter.add(scrollTextArea, BorderLayout.CENTER);
		
		pnlCenter.add(pnlInfoCenter, BorderLayout.CENTER);
	}
	
	private void initPnlInfoSouth() {
		pnlInfoSouth = new JPanel(new GridLayout(6, 1));
		
		lblEmisor = new JLabel("De: " + ((documentoPresentar.equals("DocumentoOficio")) ? documentoOficio.getEmisor().getNombreUsuario() : documentoInformativo.getEmisor().getNombreUsuario()));
		lblReceptor = new JLabel("Para: " + (documentoPresentar.equals("DocumentoOficio") ? documentoOficio.getReceptor().getNombreUsuario() : "Todos los empleados"));
		lblFechaCaducidad = new JLabel("Enviado: " + ((documentoPresentar.equals("DocumentoOficio")) ? documentoOficio.getFechaCreacion() : documentoInformativo.getFechaCreacion()));
		lblPalabrasClaves = new JLabel("Palabras Claves: " + ((documentoPresentar.equals("DocumentoOficio")) ? Arrays.toString(documentoOficio.getPalabrasClaves()) : Arrays.toString(documentoInformativo.getPalabrasClaves())));
		if(documentoPresentar.equals("DocumentoOficio")) {
			lblEstado = new JLabel("Estado: " + documentoOficio.getEstado());
			pnlInfoSouth.add(lblEstado);
		}
		lblTipoDocumento = new JLabel("Tipo de documento: " + ((documentoPresentar.equals("DocumentoOficio")) ? documentoOficio.getTipo().name() : documentoInformativo.getTipo().name()));
		
		pnlInfoSouth.add(lblEmisor);
		pnlInfoSouth.add(lblReceptor);
		pnlInfoSouth.add(lblFechaCaducidad);
		pnlInfoSouth.add(lblPalabrasClaves);
		pnlInfoSouth.add(lblTipoDocumento);
		
		pnlCenter.add(pnlInfoSouth, BorderLayout.SOUTH);
	}
	
	private void initPnlSouthOficio() {
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
	
	private void initPnlSouthInformativo() {
		pnlSouth = new JPanel(new GridLayout(1, 1));
		pnlSouthWest = new JPanel();
		
		btnVolver = new JButton("Volver");
		btnVolver.setBackground(new Color(255, 255, 255));
		
		pnlSouthWest.add(btnVolver);
		
		pnlSouth.add(pnlSouthWest, BorderLayout.WEST);
		pnlSouth.setBorder(new EmptyBorder(30, 0, 30, 0));
		contentPane.add(pnlSouth, BorderLayout.SOUTH);
	}
}
