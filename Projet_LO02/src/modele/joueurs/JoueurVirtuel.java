package modele.joueurs;
import controleur.Partie;
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

	
	
	

	
}
