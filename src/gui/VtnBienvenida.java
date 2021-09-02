package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class VtnBienvenida extends JFrame{
	private JPanel contentPane;
	
	public VtnBienvenida() {
		super("Sistema UG");
		initComponents();
//		addListeners();
	}
	
	private void initComponents() {
		contentPane = new JPanel();
		setContentPane(contentPane);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,500);
		setLocationRelativeTo(null);
	}
}
