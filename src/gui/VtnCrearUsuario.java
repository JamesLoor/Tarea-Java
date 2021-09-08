package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class VtnCrearUsuario extends JFrame {
	private JPanel contentPane;
	private JPanel pnlCenter;
	
	public VtnCrearUsuario() {
		super("Crear Usuario");
		initComponents();
	}
	
	private void initComponents() {
		contentPane = new JPanel(new BorderLayout());
		setContentPane(contentPane);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		
		initPnlCenter();
	}
	
	private void initPnlCenter() {
		JPanel pnlCenter = new JPanel();
		contentPane.add(pnlCenter, BorderLayout.CENTER);
	}
	
}
