package gui;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class VtnCrearDocumento extends JFrame {
	private JPanel contentPane;
	
	public VtnCrearDocumento() {
		super("Crear documento");
		initComponents();
		addListeners();
	}

	private void addListeners() {
		
	}
	
	private void initComponents() {
		contentPane = new JPanel(new GridLayout());
		setContentPane(contentPane);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 600);
		setLocationRelativeTo(null);
		setResizable(false);
	}

	
}
