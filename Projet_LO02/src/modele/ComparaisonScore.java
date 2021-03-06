package modele;
import java.util.*;

import modele.joueurs.Joueur;
/**
 * Classe permettant de comparer les score de deux joueurs
 */
public class ComparaisonScore implements Comparator<Joueur>{
	/**
	 * m�thode qui compare le score de deux joueurs
	 * @param j1 le premier joueur compar�
	 * @param j2 le deuxi�me joueur compar�
	 * @return 0 si les scores sont identiques, 1 si le premier est sup�rieur et -1 sinon
	 */
	public int compare(Joueur j1, Joueur j2){
		
		if (j1.getScore() == j2.getScore()){return 0;}
		else if (j1.getScore() > j2.getScore()){return 1;}
		else { return -1;}
	}
}
