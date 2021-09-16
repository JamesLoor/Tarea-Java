/**
 * Clase FondoBienvenida
 * 
 * Creado el 2 de septiembre, 2021, 14:38
 * 
 * @Author James Mendoza, Derian Paez
 * 
 * @Version POO SOF-S-NO-2-5 - 2021
 * 
 */

package gui;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class FondoBienvenida extends JPanel{

	public FondoBienvenida() {}
		 
	@Override
	public void paint(Graphics grafico) {
		Dimension tamanoFondo = getSize();
		ImageIcon Img = new ImageIcon(getClass().getResource("/imagenes/Background.jpg")); 
		grafico.drawImage(Img.getImage(), 0, 0, tamanoFondo.width, tamanoFondo.height, this);
		setOpaque(false);
		super.paintComponent(grafico);
	}
}
