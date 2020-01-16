package modele.joueurs;
import java.util.ArrayList;

import controleur.Partie;
import controleur.strategie.Strategie;
import controleur.strategie.StrategieA;
/**
 * Classe représentant un joueur virtuel (hérite de joueur) {@link Joueur}
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
	 * méthode qui génère un pseudo en prenant cinq lettres aléatoirement
	 * @return le pseudo sous forme d'une chaine de caractères
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
	 * méthode permettant de faire une offre automatiquement pour un joueur virtuel
	 * 
	 * @param methode la stratégie utilisée {@link StrategieA}
	 */
	public void faireOffre(Strategie methode) {
		methode.faireOffre(this);
	}

	/**
	 * méthode permettant de piocher automatiquement dans l'offre d'un joueur
	 * pour un joueur virtuel
	 * @param methode la stratégie utilisée {@link StrategieA}
	 * @param joueurPioche le joueur qui est pioché
	 */
	public void piocherOffre(Strategie methode, Joueur joueurPioche) {
		methode.piocherOffre(this, joueurPioche);
	}
	/**
	 * méthode qui permet de choisir automatiquement le joueur à piocher pour un joueur virtuel
	 * @param methode la stratégie utilisée {@link StrategieA}
	 * @param joueurs la liste des joueurs du jeu
	 * @return le joueur devant être pioché
	 */
	public Joueur choisirJoueurAPiocher(Strategie methode, ArrayList<Joueur> joueurs) {
		return methode.choisirJoueurAPiocher(joueurs, this);
	}
	
}
