package gui;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;

public class VtnEliminarDocumento extends JDialog {
	private JPanel contentPane;
	
	public VtnEliminarDocumento() {
		initComponents();
		addListeners();
	}
	
	private void addListeners() {
		
	}
	
	private void initComponents() {
		contentPane = new JPanel(new BorderLayout());
		setContentPane(contentPane);
		setSize(300, 400);
		setModal(true);
		setLocationRelativeTo(null);
		setResizable(false);
	}
	
	
}
