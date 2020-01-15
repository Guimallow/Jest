package controleur.strategie;

import java.util.*;

import modele.joueurs.Joueur;

/**
 * classe qui implémente l'interface Strategie et qui définit la stratégie d'un
 * joueur virtuel
 *
 */
public class StrategieA implements Strategie {

	public StrategieA() {

	}

	/**
	 * méthode qui permet au joueur virtuel de faire une offre en rendant visible la carte
	 * avec la plus petite valeur
	 * @param a le joueur virtuel
	 */
	public void faireOffre(Joueur a) {
		if (a.getMain().getOffre().get(0).getValeur().ordinal() < a.getMain().getOffre().get(1).getValeur().ordinal()) {
			a.getMain().getOffre().get(0).setVisibilite(true);
		} else {
			a.getMain().getOffre().get(1).setVisibilite(true);
		}

	}
	/**
	 * méthode qui permet au joueur virtuel de piocher une carte dans l'offre d'un joueur
	 * @param piocheur le joueur virtuel (qui pioche)
	 * @param pioche le joueur qui est pioché
	 */
	public void piocherOffre(Joueur piocheur, Joueur pioche) {
		if (pioche.getMain().getPiochabilite() == true) {
			if (pioche.getMain().getOffre().get(0).getVisibilite() == false) {
				piocheur.getJest().getCartes().add(pioche.getMain().getOffre().get(0));
				pioche.getMain().getOffre().remove(0);
			} else {
				piocheur.getJest().getCartes().add(pioche.getMain().getOffre().get(1));
				pioche.getMain().getOffre().remove(1);
			}
			pioche.getMain().setPiochabilite(false);
		}
		piocheur.setJouabilite(false);
	}
	/**
	 * méthode qui permet au joueur virtuel de chosir le joueur à piocher
	 * @param liste la liste des joueurs du jeu
	 * @param soiMeme le joueur virtuel
	 * @return le joueur à piocher
	 */
	public Joueur choisirJoueurAPiocher(ArrayList<Joueur> liste, Joueur soiMeme) {
		Joueur joueurAPiocher = soiMeme;
		for (Joueur j : liste) {
			if (j != soiMeme && j.getMain().getPiochabilite() == true) {
				joueurAPiocher = j;
			}
		}
		return joueurAPiocher;

	}

}
