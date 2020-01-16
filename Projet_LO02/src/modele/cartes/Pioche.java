package modele.cartes;

import java.util.*;

import controleur.Partie;

/**
 * Classe qui repr�sente la pioche initiale du jeu
 */
public class Pioche {
	/**
	 * attribut priv� de type bool�en qui d�termine lorsque la pioche n'a plus de
	 * carte
	 */
	private boolean a0Carte;
	/**
	 * attribut priv� de type LinkedList repr�sentant les cartes pr�sentes dans la
	 * pioche
	 */
	private LinkedList<Carte> pioche;

	/**
	 * constructeur de la carte pioche il remplit �galement la pioche avec toutes
	 * les cartes du jeu
	 */
	public Pioche() {

		this.pioche = new LinkedList<Carte>();
		this.a0Carte = false;
		for (Couleur c : Couleur.values()) {
			for (Valeur v : Valeur.values()) {
				if (v != Valeur.JOKER && c != Couleur.JOKER && v != Valeur.CINQ) {

					this.pioche.add(new Carte(v, c));
				}
			}
		}
		this.pioche.add(new Carte(Valeur.JOKER, Couleur.JOKER));

	}

	/**
	 * m�thode qui fait appelle � la bonne m�thode pour l'ajout de l'extension en
	 * fonction du nombre de joueurs
	 * 
	 * @param partie la partie en cours
	 */
	public void ajoutExtension(Partie partie) {
		if (partie.getJoueurs().size() == 3) {
			this.ajoutExtension3Joueurs();
		} else if (partie.getJoueurs().size() == 4) {
			this.ajoutExtension4Joueurs();
		}
	}

	/**
	 * m�thode qui ajoute l'extension avec le bon nombre de carte pour 4 joueurs
	 */
	private void ajoutExtension4Joueurs() {
		for (Couleur c : Couleur.values()) {
			if (c != Couleur.JOKER && c != Couleur.PIC) {
				this.pioche.add(new Carte(Valeur.CINQ, c));
			}
		}

	}

	/**
	 * m�thode qui ajoute l'extension avec le bon nombre de carte pour 3 joueurs
	 */
	private void ajoutExtension3Joueurs() {
		for (Couleur c : Couleur.values()) {
			if (c != Couleur.JOKER) {
				this.pioche.add(new Carte(Valeur.CINQ, c));
			}
		}

	}
	/**
	 * m�thode qui retire la carte en haut de la pioche
	 * @return la carte retir�e
	 */
	public Carte retirerCarteDuHaut() {
		Carte c;
		c = this.pioche.removeLast();
		if (this.pioche.size() == 0) {
			a0Carte = true;
		}
		return c;

	}
	/**
	 * m�thode qui m�lange la pioche
	 */
	public void melanger() {
		Collections.shuffle(this.pioche);
	}
	/**
	 * getter qui retourne si la pioche est vide ou non
	 * @param partie la partie en cours
	 * @return le bool�en qui d�finit si la pioche est vide
	 */
	public boolean getA0Carte(Partie partie) {
		this.setA0Carte(partie);
		return this.a0Carte;
	}
	/**
	 * setter qui permet de modifier la valeur du bool�en a0Carte
	 * @param partie la partie en cours
	 */
	public void setA0Carte(Partie partie) {
		if (this.pioche.size() < partie.getJoueurs().size()) {
			this.a0Carte = true;
		}
	}
	/**
	 * getter qui retourne les cartes de la pioche
	 * @return la liste des cartes de la pioche
	 */
	public LinkedList<Carte> getPioche() {
		return this.pioche;
	}

	
}
