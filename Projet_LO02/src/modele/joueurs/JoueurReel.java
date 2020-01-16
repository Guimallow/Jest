package modele.joueurs;
import controleur.Partie;
/**
 * Classe repr�sentant un joueur r�el (h�rite de joueur) {@link Joueur}
 */
public class JoueurReel extends Joueur {
	/**
	 * constructeur de la classe 
	 * @param nom le pseudo du joueur
	 * @param partie la partie en cours
	 */
	public JoueurReel(String nom, Partie partie){
		super(partie);
		this.setPseudo(nom);
		
	}
	
}

