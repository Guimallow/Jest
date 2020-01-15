package modele.cartes;

import java.util.*;

import modele.ObjetVisite;
import modele.Visiteur;
import modele.joueurs.Joueur;

/**
 * Classe représentant le jest d'un joueur
 *
 */
public class Jest implements ObjetVisite {
	/**
	 * attribut privé de type ArrayList représentant les cartes du jest
	 */
	private ArrayList<Carte> cartes;
	/**
	 * attribut privé de type Joueur représentant le joueur possédant le jest
	 */
	private Joueur joueur;

	/**
	 * constructeur du jest
	 * 
	 * @param joueur le joueur à qui on créer le jest
	 */
	public Jest(Joueur joueur) {
		this.cartes = new ArrayList<Carte>();
		this.joueur = joueur;
	}

	/**
	 * getter qui retourne les cartes du jest
	 * 
	 * @return les cartes composant le jest
	 */
	public ArrayList<Carte> getCartes() {
		return this.cartes;
	}

	/**
	 * setter qui permet de modifier les cartes du jest
	 * 
	 * @param nouvellesCartes nouvelles cartes du jest
	 */
	public void setCartes(ArrayList<Carte> nouvellesCartes) {
		this.cartes = nouvellesCartes;
	}

	/**
	 * méthode qui accepte le visiteur
	 * 
	 * @param v le visiteur du Jest
	 */
	public void accept(Visiteur v) {
		v.visit(this);
	}

	/**
	 * méthode qui affiche le jest
	 */
	public void afficherJest() {
		Iterator<Carte> it = this.cartes.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

	/**
	 * getter qui retourne le joueur possédant le jest
	 * 
	 * @return le joueur qui possède le jest
	 */
	public Joueur getJoueur() {
		return this.joueur;
	}
	/**
	 * méthode qui permet d'ajouter une carte au jest
	 * @param c la carte à ajouter
	 */
	public void ajouterCarte(Carte c) {
		this.cartes.add(c);
	}

}
