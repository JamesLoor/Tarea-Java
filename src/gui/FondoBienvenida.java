package gui;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class FondoBienvenida extends JPanel{
	public FondoBienvenida() {}
		 
	public void paint(Graphics grafico) {
		Dimension height = getSize();
		ImageIcon Img = new ImageIcon(getClass().getResource("/imagenes/Background.jpg")); 
		grafico.drawImage(Img.getImage(), 0, 0, height.width, height.height, null);
		setOpaque(false);
		super.paintComponent(grafico);
	}
}
