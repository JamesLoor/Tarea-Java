package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class VtnSistema extends JFrame{
	private JPanel contentPane;
	
	public VtnSistema() {
		super("Sistema");
		initComponents();
//		addListeners();
	}
	
	private void initComponents() {
		contentPane = new JPanel();
		setContentPane(contentPane);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(238,171);
		setLocationRelativeTo(null);
	}
}
