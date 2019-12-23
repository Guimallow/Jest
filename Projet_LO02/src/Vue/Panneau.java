package Vue;

import java.awt.Graphics;
import javax.swing.JPanel;

public class Panneau extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Panneau(){
		
	}
	
	public void paintComponent(Graphics g){
		/*
		 * Font font = new Font("Courier", Font.BOLD, 20);
		 * g.setFont(font);
		 *  g.setColor(Color.red);
		 */
		
	    g.drawString("Texte écrit", 10, 20);
	  }   
}
