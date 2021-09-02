package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class VtnLogin extends JFrame{
	private JPanel contentPane;
	
	public VtnLogin() {
		super("Login");
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
