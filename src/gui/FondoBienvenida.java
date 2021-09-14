package gui;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class FondoBienvenida extends JPanel{
	private static final long serialVersionUID = 1L;

	public FondoBienvenida() {}
		 
	@Override
	public void paint(Graphics grafico) {
		Dimension tamanoFondo = getSize();
		ImageIcon Img = new ImageIcon(getClass().getResource("/imagenes/FondoTesting2.jpg")); 
		grafico.drawImage(Img.getImage(), 0, 0, tamanoFondo.width, tamanoFondo.height, this);
		setOpaque(false);
		super.paintComponent(grafico);
	}
}
