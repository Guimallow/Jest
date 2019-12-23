package Vue;

import javax.swing.JFrame;

public class Fenetre extends JFrame{
	/**
	 * Je n'ai aucune id�e de pourquoi eclipse m'a fait rajouter cet UID
	 */
	private static final long serialVersionUID = 1L;

	public Fenetre(){
		this.setBounds(100, 100, 450, 300);
		 //D�finit un titre pour notre fen�tre
	    this.setTitle("Jest");
	    //Positionnement au centre de la page
	    this.setLocationRelativeTo(null);
	    //Termine le processus lorsqu'on clique sur la croix rouge
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    //Et enfin, la rendre visible        
	    this.setVisible(true);
	    
	    this.setContentPane(new Panneau());
	}
}
