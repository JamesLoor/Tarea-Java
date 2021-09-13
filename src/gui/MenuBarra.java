package gui;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import listeners.MenuListener;
import modelo.BaseDatos;

public class MenuBarra extends JMenuBar {
	private static final long serialVersionUID = 1L;
	private VtnSistema vtnSistema;
	private String rolLogeado;
	private JMenu menuUsuario;
	private JMenu menuVer;
	private JMenu menuCrear;
	private JMenu menuEliminar;
	private JMenuItem menuUsuarioCerrarSesion;
	private JMenuItem menuVerListaUsuario;
	private JMenuItem menuVerListaDocumentoRecibido;
	private JMenuItem menuCrearUsuario;
	private JMenuItem menuCrearDocumento;
	private JMenuItem menuEliminarUsuario;
	private JMenuItem menuEliminarDocumento;
	
	public MenuBarra(VtnSistema vtnSistema) {
		this.vtnSistema = vtnSistema;
		this.rolLogeado = BaseDatos.getUsuarioLogeado().getClass().getSimpleName();
		initComponents();
	}

	private void initComponents() {
		switch (rolLogeado) {
			case "Administrador":
				addMenuUsuario();
				addMenuVer();
				addMenuVerListaUsuario();
				addMenuVerListaDocumentoRecibido();
				addMenuCrear();
				addMenuCrearUsuario();
				addMenuCrearDocumento();
				addMenuEliminar();
				addMenuEliminarUsuario();
				addMenuEliminarDocumento();
				
				addListenerAdministrador();
				break;
			case "Jefe":
				addMenuUsuario();
				addMenuVer();
				addMenuVerListaDocumentoRecibido();
				addMenuCrear();
				addMenuCrearDocumento();
				addMenuEliminar();
				addMenuEliminarDocumento();
				
				addlListenerJefe();
				break;
			case "Empleado":
				addMenuUsuario();
				addMenuVer();
				addMenuVerListaDocumentoRecibido();
				addMenuCrear();
				addMenuCrearDocumento();
				addMenuEliminar();
				addMenuEliminarDocumento();
				
				addListenerEmpleado();
				break;
			default:
				break;
		}
	}
	
	private void addListenerAdministrador() {
		menuUsuarioCerrarSesion.addActionListener(new MenuListener(vtnSistema, this));
		menuVerListaUsuario.addActionListener(new MenuListener(vtnSistema, this));
		menuVerListaDocumentoRecibido.addActionListener(new MenuListener(vtnSistema, this));
		menuCrearUsuario.addActionListener(new MenuListener(vtnSistema, this));
		menuCrearDocumento.addActionListener(new MenuListener(vtnSistema, this));
		menuEliminarUsuario.addActionListener(new MenuListener(vtnSistema, this));
		menuEliminarDocumento.addActionListener(new MenuListener(vtnSistema, this));
		
	}
	
	private void addlListenerJefe() {
		menuUsuarioCerrarSesion.addActionListener(new MenuListener(vtnSistema, this));
		menuVerListaDocumentoRecibido.addActionListener(new MenuListener(vtnSistema, this));
		menuCrearDocumento.addActionListener(new MenuListener(vtnSistema, this));
		menuEliminarDocumento.addActionListener(new MenuListener(vtnSistema, this));
	}
	
	private void addListenerEmpleado() {
		menuUsuarioCerrarSesion.addActionListener(new MenuListener(vtnSistema, this));
		menuVerListaDocumentoRecibido.addActionListener(new MenuListener(vtnSistema, this));
		menuCrearDocumento.addActionListener(new MenuListener(vtnSistema, this));
		menuEliminarDocumento.addActionListener(new MenuListener(vtnSistema, this));
	}
	
	private void addMenuUsuario() {
		menuUsuario = new JMenu("Usuario");
		menuUsuarioCerrarSesion = new JMenuItem("Cerrar Sesion");
		menuUsuario.add(menuUsuarioCerrarSesion);
		
		this.add(menuUsuario);
	}
	
	private void addMenuVer() {
		menuVer = new JMenu("Ver");
		this.add(menuVer);
	}
	
	private void addMenuVerListaUsuario() {
		menuVerListaUsuario = new JMenuItem("Lista de usuarios");
		menuVer.add(menuVerListaUsuario);
	}
	
	private void addMenuVerListaDocumentoRecibido() {
		menuVerListaDocumentoRecibido = new JMenuItem("Lista de documentos recibidos");
		menuVer.add(menuVerListaDocumentoRecibido);
	}
	
	private void addMenuCrear() {
		menuCrear = new JMenu("Crear");
		this.add(menuCrear);
	}
	
	private void addMenuCrearUsuario() {
		menuCrearUsuario = new JMenuItem("Crear Usuario");
		menuCrear.add(menuCrearUsuario);
	}
	
	private void addMenuCrearDocumento() {
		menuCrearDocumento = new JMenuItem("Crear Documento");
		menuCrear.add(menuCrearDocumento);
	}
	
	private void addMenuEliminar() {
		menuEliminar = new JMenu("Eliminar");
		this.add(menuEliminar);
	}
	
	private void addMenuEliminarUsuario() {
		menuEliminarUsuario = new JMenuItem("Eliminar Usuario");
		menuEliminar.add(menuEliminarUsuario);
	}
	
	private void addMenuEliminarDocumento() {
		menuEliminarDocumento = new JMenuItem("Eliminar Documento");
		menuEliminar.add(menuEliminarDocumento);
	}
	
	
	

	public JMenuItem getMenuVerListaUsuario() {
		return menuVerListaUsuario;
	}

	public void setMenuVerListaUsuario(JMenuItem menuVerListaUsuario) {
		this.menuVerListaUsuario = menuVerListaUsuario;
	}

	public JMenuItem getMenuVerListaDocumentoRecibido() {
		return menuVerListaDocumentoRecibido;
	}

	public void setMenuVerListaDocumentoRecibido(JMenuItem menuVerListaDocumentoRecibido) {
		this.menuVerListaDocumentoRecibido = menuVerListaDocumentoRecibido;
	}

	public VtnSistema getVtnSistema() {
		return vtnSistema;
	}


	public void setVtnSistema(VtnSistema vtnSistema) {
		this.vtnSistema = vtnSistema;
	}


	public JMenuItem getMenuUsuarioCerrarSesion() {
		return menuUsuarioCerrarSesion;
	}


	public void setMenuUsuarioCerrarSesion(JMenuItem menuUsuarioCerrarSesion) {
		this.menuUsuarioCerrarSesion = menuUsuarioCerrarSesion;
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
