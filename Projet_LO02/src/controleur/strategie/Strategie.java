package controleur.strategie;
import java.util.*;

import modele.joueurs.Joueur;
/**
 * interface qui d�finit toutes les m�thodes que doit contenir une strat�gie
 *
 */
public interface Strategie {
	/**
	 * m�thode qui doit impl�menter la capacit� pour un joueur virtuel de faire une offre
	 * @param a le joueur virtuel
	 */
	public void faireOffre(Joueur a);
	/**
	 * m�thode qui doit impl�menter la capacit� pour un joueur virtuel de piocher dans une offre
	 * @param a le joueur qui pioche
	 * @param b le joueur qui est pioch�
	 */
	public void piocherOffre(Joueur a, Joueur b);
	/**
	 * m�thode qui doit impl�menter la capacit� pour un joueur virtuel de choisir un joueur � piocher
	 * @param liste la liste des joueurs de la partie
	 * @param j le joueur virtuel
	 * @return le joueur � piocher
	 */
	public Joueur choisirJoueurAPiocher(ArrayList<Joueur> liste, Joueur j);

}
