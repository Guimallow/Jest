package controleur.strategie;
import java.util.*;

import modele.joueurs.Joueur;
/**
 * interface qui définit toutes les méthodes que doit contenir une stratégie
 *
 */
public interface Strategie {
	/**
	 * méthode qui doit implémenter la capacité pour un joueur virtuel de faire une offre
	 * @param a le joueur virtuel
	 */
	public void faireOffre(Joueur a);
	/**
	 * méthode qui doit implémenter la capacité pour un joueur virtuel de piocher dans une offre
	 * @param a le joueur qui pioche
	 * @param b le joueur qui est pioché
	 */
	public void piocherOffre(Joueur a, Joueur b);
	/**
	 * méthode qui doit implémenter la capacité pour un joueur virtuel de choisir un joueur à piocher
	 * @param liste la liste des joueurs de la partie
	 * @param j le joueur virtuel
	 * @return le joueur à piocher
	 */
	public Joueur choisirJoueurAPiocher(ArrayList<Joueur> liste, Joueur j);

}
