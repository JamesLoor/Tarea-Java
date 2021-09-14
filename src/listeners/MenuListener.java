package listeners;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import gui.MenuBarra;
import gui.TablaDocumento;
import gui.TablaUsuario;
import gui.VtnBienvenida;
import gui.VtnCrearDocumento;
import gui.VtnCrearUsuario;
import gui.VtnEliminarDocumento;
import gui.VtnEliminarUsuario;
import gui.VtnSistema;

public class MenuListener implements ActionListener {
	private VtnSistema vtnSistema;
	private MenuBarra menuBarra;
	
	public MenuListener() {}
	
	public MenuListener(VtnSistema vtn, MenuBarra menuBarra) {
		this.vtnSistema = vtn;
		this.menuBarra = menuBarra;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj == menuBarra.getMenuCrearDocumento()) {
			VtnCrearDocumento ventana = new VtnCrearDocumento();
			ventana.setVisible(true);
		}
		
		if(obj == menuBarra.getMenuCrearUsuario()) {
			VtnCrearUsuario ventana = new VtnCrearUsuario(vtnSistema);
			ventana.setVisible(true);
		}
		
		if(obj == menuBarra.getMenuUsuarioCerrarSesion()) {
			vtnSistema.dispose();
			new VtnBienvenida().setVisible(true);
		}
		
		if(obj == menuBarra.getMenuEliminarUsuario()) {
			VtnEliminarUsuario ventana = new VtnEliminarUsuario(vtnSistema);
			ventana.setVisible(true);
		}
		
		if(obj == menuBarra.getMenuEliminarDocumento()) {
			VtnEliminarDocumento ventana = new VtnEliminarDocumento(vtnSistema);
			ventana.setVisible(true);
		}
		
		if(obj == menuBarra.getMenuVerListaUsuario()) {
			vtnSistema.cleanPnlCenter();
			vtnSistema.cleanPnlNorth();
			
			JLabel lblTablaUsuarios = new JLabel("Lista de usuarios");
			lblTablaUsuarios.setFont(new Font("Arial", Font.BOLD, 24));
			vtnSistema.getPnlNorth().add(lblTablaUsuarios);
			
			TablaUsuario tablaUsuario = new TablaUsuario();
			JScrollPane scroll = new JScrollPane(tablaUsuario);
			
			vtnSistema.setTablaUsuario(tablaUsuario);
			vtnSistema.setLblTablaUsuarios(lblTablaUsuarios);
			vtnSistema.getPnlCenter().add(scroll);
		}
		
		if(obj == menuBarra.getMenuVerListaDocumentoRecibido()) {
			vtnSistema.cleanPnlCenter();
			vtnSistema.cleanPnlNorth();
			
			JLabel lblTablaDocumentos = new JLabel("Lista de documentos");
			lblTablaDocumentos.setFont(new Font("Arial", Font.BOLD, 24));
			vtnSistema.getPnlNorth().add(lblTablaDocumentos);
			
			TablaDocumento tablaDocumento = new TablaDocumento();
			JScrollPane scroll = new JScrollPane(tablaDocumento);
			
			vtnSistema.setTablaDocumento(tablaDocumento);
			vtnSistema.setLblTablaDocumentos(lblTablaDocumentos);
			vtnSistema.getPnlCenter().add(scroll);
		}
	}
}
