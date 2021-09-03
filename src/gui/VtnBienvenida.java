package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import gui.FondoBienvenida;

public class VtnBienvenida extends JFrame{
	private JPanel contentPane;
	private FondoBienvenida pnlCenter;
	private JPanel pnlEast;
	private JLabel lblCenter;
	private JLabel lblEast;
	
	public VtnBienvenida() {
		super("Sistema UG");
		initComponents();
//		addListeners();
	}
	
	private void initComponents() {
		contentPane = new JPanel(new BorderLayout());
		setContentPane(contentPane);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000,600);
		setLocationRelativeTo(null);
		
		initPnlCenter();
		initPnlEast();
	}
	
	private void initPnlCenter() {
		pnlCenter = new FondoBienvenida();
		contentPane.add(pnlCenter, BorderLayout.CENTER);
	}
	
	private void initPnlEast() {
		pnlEast = new JPanel();
		lblEast = new JLabel("Formulario");
		pnlEast.add(lblEast);

		
		contentPane.add(pnlEast, BorderLayout.EAST);
	}
}
