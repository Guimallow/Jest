package modele.joueurs;
import controleur.Partie;
import modele.cartes.Carte;
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

	/**
	 * m�thode qui rend une des deux cartes du joueur visible
	 * 
	 * @param premiereCarte bool�en qui permet de d�terminer quelle carte est rendue
	 *                      visible
	 */
	public void faireOffre(boolean premiereCarte) {
		if (premiereCarte == true) {
			this.main.getOffre().get(0).setVisibilite(true);
		} else {
			this.main.getOffre().get(1).setVisibilite(true);
		}
	}

	/**
	 * m�thode qui permet � un joueur de piocher dans l'offre d'un autre joueur
	 * 
	 * @param a            le joueur qui est pioch�
	 * @param carteVisible bool�en qui d�termine si le joueur pioche la carte
	 *                     visible ou face cach�e
	 * @return la carte correspondant � la carte pioch�e
	 */
	public Carte piocherOffre(Joueur a, boolean carteVisible) {

		Carte cartePiochee = null;
		if (a.main.getPiochabilite() == true) {
			if ((carteVisible == true && a.main.getOffre().get(0).getVisibilite() == true)
					|| (carteVisible == false && a.main.getOffre().get(0).getVisibilite() == false)) {
				this.jest.getCartes().add(a.main.getOffre().get(0));
				cartePiochee = a.getMain().getOffre().get(0);
				a.main.getOffre().remove(0);
			} else {
				this.jest.getCartes().add(a.main.getOffre().get(1));
				cartePiochee = a.getMain().getOffre().get(1);
				a.main.getOffre().remove(1);
			}
			a.main.setPiochabilite(false);
		}
		this.estJouable = false;
		return cartePiochee;
	}
	
}

