package modele.joueurs;
import java.util.ArrayList;

import controleur.Partie;
import controleur.strategie.Strategie;
import controleur.strategie.StrategieA;
/**
 * Classe repr�sentant un joueur virtuel (h�rite de joueur) {@link Joueur}
 */
public class JoueurVirtuel extends Joueur {
	/**
	 * constructeur de la classe
	 * @param partie la partie en cours
	 */
	public JoueurVirtuel(Partie partie) {
		super(partie);
		this.setPseudo(genererPseudo());

	}

	/**
	 * m�thode qui g�n�re un pseudo en prenant cinq lettres al�atoirement
	 * @return le pseudo sous forme d'une chaine de caract�res
	 */
	public static String genererPseudo() {
		String caracteresPossibles = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuffer pass = new StringBuffer();

		for (int x = 0; x < 5; x++) {
			int i = (int) Math.floor(Math.random() * (caracteresPossibles.length() - 1));
			pass.append(caracteresPossibles.charAt(i));
		}
		return pass.toString();
	}
	
	/**
	 * m�thode permettant de faire une offre automatiquement pour un joueur virtuel
	 * 
	 * @param methode la strat�gie utilis�e {@link StrategieA}
	 */
	public void faireOffre(Strategie methode) {
		methode.faireOffre(this);
	}

	/**
	 * m�thode permettant de piocher automatiquement dans l'offre d'un joueur
	 * pour un joueur virtuel
	 * @param methode la strat�gie utilis�e {@link StrategieA}
	 * @param joueurPioche le joueur qui est pioch�
	 */
	public void piocherOffre(Strategie methode, Joueur joueurPioche) {
		methode.piocherOffre(this, joueurPioche);
	}
	/**
	 * m�thode qui permet de choisir automatiquement le joueur � piocher pour un joueur virtuel
	 * @param methode la strat�gie utilis�e {@link StrategieA}
	 * @param joueurs la liste des joueurs du jeu
	 * @return le joueur devant �tre pioch�
	 */
	public Joueur choisirJoueurAPiocher(Strategie methode, ArrayList<Joueur> joueurs) {
		return methode.choisirJoueurAPiocher(joueurs, this);
	}
	
}
