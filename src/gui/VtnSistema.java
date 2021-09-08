package gui;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import modelo.Usuario;

public class VtnSistema extends JFrame {
	private JPanel contentPane;
	private JMenuBar menuBarra;
	private JMenu menuCrear;
	private JMenuItem menuCrearUsuario;
	
	public VtnSistema() {}
	
	public VtnSistema(Usuario usuarioLogeado) {
		super("Sistema");
		initComponents();
	}
	
	private void initComponents() {
		contentPane = new JPanel();
		setContentPane(contentPane);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		dispose();
		
		addMenu();
	}
	
	private void addMenu() {
		menuBarra = new JMenuBar();
		
		menuCrear = new JMenu("Crear");
		menuCrearUsuario = new JMenuItem("Crear Usuario");
		
		menuCrear.add(menuCrearUsuario);
		menuBarra.add(menuCrear);
		
		setJMenuBar(menuBarra);
	}
}
