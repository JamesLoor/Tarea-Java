package gui;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import listeners.MenuListener;
import modelo.BaseDatos;

public class VtnSistema extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel pnlNorth;
	private JLabel lblTablaUsuarios;
	private JPanel pnlCenter;
	private JMenuBar menuBarra;
	private JMenu menuUsuario;
	private JMenu menuCrear;
	private JMenu menuEliminar;
	private JMenuItem menuUsuarioCerrarSesion;
	private JMenuItem menuCrearUsuario;
	private JMenuItem menuCrearDocumento;
	private JMenuItem menuEliminarUsuario;
	private JMenuItem menuEliminarDocumento;
	private String rolLogeado;
	private TablaUsuario tablaUsuario;
	
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
		
		switch (rolLogeado) {
			case "Administrador":
				addMenuAdministrador();
				addListenersAdministrador();
				initTablaUsuario();
				break;
			case "Jefe":
				addMenuJefe();
				addListenersJefe();
				break;
			case "Empleado":
				addMenuEmpleado();
				addListenersEmpleado();
				break;
			default:
				break;
			}
	}
	
	private void addListenersAdministrador() {
		menuUsuarioCerrarSesion.addActionListener(new MenuListener(this));
		menuCrearUsuario.addActionListener(new MenuListener(this));
		menuCrearDocumento.addActionListener(new MenuListener(this));
		menuEliminarUsuario.addActionListener(new MenuListener(this));
		menuEliminarDocumento.addActionListener(new MenuListener(this));
	}
	
	private void addMenuAdministrador() {
		menuBarra = new JMenuBar();
		
		menuUsuario = new JMenu("Usuario");
		menuUsuarioCerrarSesion = new JMenuItem("Cerrar Sesion");
		menuUsuario.add(menuUsuarioCerrarSesion);
		
		menuCrear = new JMenu("Crear");
		menuCrearUsuario = new JMenuItem("Crear Usuario");
		menuCrearDocumento = new JMenuItem("Crear Documento");
		menuCrear.add(menuCrearUsuario);
		menuCrear.add(menuCrearDocumento);
		
		menuEliminar = new JMenu("Eliminar");
		menuEliminarUsuario = new JMenuItem("Eliminar Usuario");
		menuEliminarDocumento = new JMenuItem("Eliminar Documento");
		menuEliminar.add(menuEliminarUsuario);
		menuEliminar.add(menuEliminarDocumento);

		menuBarra.add(menuUsuario);
		menuBarra.add(menuCrear);
		menuBarra.add(menuEliminar);
		
		setJMenuBar(menuBarra);
	}
	
	private void addListenersJefe() {
		menuUsuarioCerrarSesion.addActionListener(new MenuListener(this));
		menuCrearDocumento.addActionListener(new MenuListener(this));
	}
	
	private void addMenuJefe() {
		menuBarra = new JMenuBar();
		
		menuUsuario = new JMenu("Usuario");
		menuUsuarioCerrarSesion = new JMenuItem("Cerrar Sesion");
		menuUsuario.add(menuUsuarioCerrarSesion);
		
		menuCrear = new JMenu("Crear");
		menuCrearDocumento = new JMenuItem("Crear Documento");
		menuCrear.add(menuCrearDocumento);

		menuBarra.add(menuUsuario);
		menuBarra.add(menuCrear);
		
		
		setJMenuBar(menuBarra);
	}
	
	private void addListenersEmpleado() {
		menuUsuarioCerrarSesion.addActionListener(new MenuListener(this));
		menuCrearDocumento.addActionListener(new MenuListener(this));
	}
	
	private void addMenuEmpleado() {
		menuBarra = new JMenuBar();
		
		menuUsuario = new JMenu("Usuario");
		menuUsuarioCerrarSesion = new JMenuItem("Cerrar Sesion");
		menuUsuario.add(menuUsuarioCerrarSesion);
		
		menuCrear = new JMenu("Crear");
		menuCrearDocumento = new JMenuItem("Crear Documento");
		menuCrear.add(menuCrearDocumento);

		menuBarra.add(menuUsuario);
		menuBarra.add(menuCrear);
		
		setJMenuBar(menuBarra);
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
	
	
	public TablaUsuario getTablaUsuario() {
		return tablaUsuario;
	}

	public void setTablaUsuario(TablaUsuario tablaUsuario) {
		this.tablaUsuario = tablaUsuario;
	}

	public JMenuItem getMenuCrearUsuario() {
		return menuCrearUsuario;
	}

	public void setMenuCrearUsuario(JMenuItem menuCrearUsuario) {
		this.menuCrearUsuario = menuCrearUsuario;
	}

	public JMenuItem getMenuCrearDocumento() {
		return menuCrearDocumento;
	}

	public void setMenuCrearDocumento(JMenuItem menuCrearDocumento) {
		this.menuCrearDocumento = menuCrearDocumento;
	}

	public JMenuItem getMenuUsuarioCerrarSesion() {
		return menuUsuarioCerrarSesion;
	}

	public void setMenuUsuarioCerrarSesion(JMenuItem menuUsuarioCerrarSesion) {
		this.menuUsuarioCerrarSesion = menuUsuarioCerrarSesion;
	}

	public JMenuItem getMenuEliminarUsuario() {
		return menuEliminarUsuario;
	}

	public void setMenuEliminarUsuario(JMenuItem menuEliminarUsuario) {
		this.menuEliminarUsuario = menuEliminarUsuario;
	}

	public JMenuItem getMenuEliminarDocumento() {
		return menuEliminarDocumento;
	}

	public void setMenuEliminarDocumento(JMenuItem menuEliminarDocumento) {
		this.menuEliminarDocumento = menuEliminarDocumento;
	}
}
