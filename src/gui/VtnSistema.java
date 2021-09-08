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
		setSize(1000, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		dispose();
	}
}
