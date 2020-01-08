package modele.joueurs;
import controleur.Partie;

public class JoueurReel extends Joueur {
	
	public JoueurReel(String nom, Partie partie){
		super(partie);
		this.setPseudo(nom);
		
	}
	
}

