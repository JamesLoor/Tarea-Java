/**
 * Clase VtnSistema
 * 
 * Creado el 3 de septiembre, 2021, 15:00
 * 
 * @Author James Mendoza, Derian Paez
 * 
 * @Version POO SOF-S-NO-2-5 - 2021
 * 
 */
package gui;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import modelo.BaseDatos;

public class VtnSistema extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel pnlNorth;
	private JLabel lblTablaUsuarios;
	private JLabel lblTablaDocumentos;
	private JPanel pnlCenter;
	private MenuBarra menuBarra;
	private TablaUsuario tablaUsuario;
	private TablaDocumento tablaDocumento;
	private String rolLogeado;
	
	public VtnSistema() {
		super("Sistema -" + BaseDatos.getUsuarioLogeado().getNombreUsuario());
		this.rolLogeado = BaseDatos.getUsuarioLogeado().getClass().getSimpleName();
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
		
		menuBarra = new MenuBarra(this);
		setJMenuBar(menuBarra);
		
		switch (rolLogeado) {
			case "Administrador":
				initTablaDocumento();
				initTablaUsuario();
				break;
			case "Jefe":
				initTablaDocumento();
				break;
			case "Empleado":
				initTablaDocumento();
				break;
			default:
				break;
		}
	}
	
	private void initTablaDocumento() {
		pnlNorth = new JPanel(new BorderLayout());
		lblTablaDocumentos = new JLabel("Bandeja de entrada");
		lblTablaDocumentos.setFont(new Font("Arial", Font.BOLD, 24));
		pnlNorth.setBorder(new EmptyBorder(20, 25, 0, 0));
		pnlNorth.add(lblTablaDocumentos, BorderLayout.WEST);
		
		pnlCenter = new JPanel(new BorderLayout());
		
		tablaDocumento = new TablaDocumento();
		JScrollPane scroll = new JScrollPane(tablaDocumento);
		pnlCenter.setBorder(new EmptyBorder(10, 25, 25, 25));
		pnlCenter.add(scroll);
		contentPane.add(pnlNorth, BorderLayout.NORTH);
		contentPane.add(pnlCenter, BorderLayout.CENTER);
	}
	
	private void initTablaUsuario() {
		pnlNorth = new JPanel(new BorderLayout());
		lblTablaUsuarios = new JLabel("Lista de usuarios");
		lblTablaUsuarios.setFont(new Font("Arial", Font.BOLD, 24));
		pnlNorth.setBorder(new EmptyBorder(20, 25, 0, 0));
		pnlNorth.add(lblTablaUsuarios, BorderLayout.WEST);
		
		pnlCenter = new JPanel(new BorderLayout());
		
		tablaUsuario = new TablaUsuario();
		JScrollPane scroll = new JScrollPane(tablaUsuario);
		pnlCenter.setBorder(new EmptyBorder(10, 25, 25, 25));
		pnlCenter.add(scroll);
		contentPane.add(pnlNorth, BorderLayout.NORTH);
		contentPane.add(pnlCenter, BorderLayout.CENTER);
	}
	
	public void cleanPnlNorth() {
		pnlNorth.removeAll();
		pnlNorth.revalidate();
		pnlNorth.validate();
	}
	
	public void cleanPnlCenter() {
		pnlCenter.removeAll();
		pnlCenter.revalidate();
		pnlCenter.validate();
	}
	
	
	public JLabel getLblTablaUsuarios() {
		return lblTablaUsuarios;
	}

	public void setLblTablaUsuarios(JLabel lblTablaUsuarios) {
		this.lblTablaUsuarios = lblTablaUsuarios;
	}

	public JLabel getLblTablaDocumentos() {
		return lblTablaDocumentos;
	}

	public void setLblTablaDocumentos(JLabel lblTablaDocumentos) {
		this.lblTablaDocumentos = lblTablaDocumentos;
	}

	public JPanel getPnlNorth() {
		return pnlNorth;
	}

	public void setPnlNorth(JPanel pnlNorth) {
		this.pnlNorth = pnlNorth;
	}

	public JPanel getPnlCenter() {
		return pnlCenter;
	}

	public void setPnlCenter(JPanel pnlCenter) {
		this.pnlCenter = pnlCenter;
	}
	
	public TablaDocumento getTablaDocumento() {
		return tablaDocumento;
	}

	public void setTablaDocumento(TablaDocumento tablaDocumento) {
		this.tablaDocumento = tablaDocumento;
	}

	public TablaUsuario getTablaUsuario() {
		return tablaUsuario;
	}

	public void setTablaUsuario(TablaUsuario tablaUsuario) {
		this.tablaUsuario = tablaUsuario;
	}
}
