package modele.cartes;

import java.util.*;

import controleur.Partie;
import modele.joueurs.Joueur;

/**
 * Classe repr�sentant le tas dans lequel chaque joueur pioche apr�s le tour 1
 */
public class Tas {
	/**
	 * attribut priv� de type LinkedList repr�sentant les cartes du tas
	 */
	private LinkedList<Carte> tas;

	/**
	 * constructeur du tas
	 */
	public Tas() {
		tas = new LinkedList<Carte>();
	}

	/**
	 * m�thode qui retire la carte du haut du tas
	 * 
	 * @return la carte retir�e
	 */
	public Carte retirerCarteDuHaut() {
		Carte c;
		c = this.tas.getLast();
		this.tas.removeLast();
		return c;

	}

	/**
	 * m�thode qui cr�e le tas � partir de la pioche et des cartes restantes dans
	 * les offres des joueurs
	 * 
	 * @param partie la partie en cours
	 */
	public void nouveauTas(Partie partie) {
		int joueur = Joueur.getNbJoueurs();
		int i;
		Carte c;
		for (i = 0; i < joueur; i++) {
			c = partie.getPioche().retirerCarteDuHaut();
			this.tas.add(c);
		}
		if (partie.getPioche().getA0Carte(partie) == false) {
			for (Joueur j : partie.getJoueurs()) {
				if (j.getMain().getOffre().get(0) != null) {
					j.getMain().getOffre().get(0).setVisibilite(false);
					this.tas.add(j.getMain().getOffre().get(0));
					j.getMain().getOffre().remove(0);
				} else {
					j.getMain().getOffre().get(1).setVisibilite(false);
					this.tas.add(j.getMain().getOffre().get(1));
					j.getMain().getOffre().remove(1);
				}

			}
		}

		Collections.shuffle(this.tas);
	}

	/**
	 * getter qui retourne les cartes du tas
	 * 
	 * @return la liste de cartes du tas
	 */
	public LinkedList<Carte> getTas() {
		return this.tas;
	}
}
