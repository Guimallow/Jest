package modele.cartes;
import java.util.*;

/**
 * Classe repr�sentant l'offre d'un joueur
 */
public class Offre {
	/**
	 * attribut priv� de type ArrayList qui correspond aux deux cartes de l'offre
	 */
	private ArrayList<Carte> offre;
	/**
	 * attribut priv� de type bool�en qui d�finit si l'on peut piocher ou non dans l'offre
	 */
	private boolean estPiochable;
	
	/**
	 * constructeur de la classe Offre qui cr�e la liste de carte (avec 0 carte tant que le joueur n'a pas pioch�)
	 * et qui initialise sa piochabilit� � vrai
	 */
	public Offre() {
		this.estPiochable = true;
		this.offre = new ArrayList<Carte>();
	}
	
	/**
	 * getter qui renvoie l'offre du joueur
	 * @return l'offre
	 */
	public ArrayList<Carte> getOffre() {
		return offre;
	}
	
	/**
	 * m�thode qui affiche aux autres joueurs l'offre du joueur courant
	 * si la carte n'est pas visible, n'affiche pas la carte mais un message alternatif
	 */
	public void afficherOffre() {
		for(Carte c:offre) {
			if(c.getVisibilite()==true) {
				System.out.println(c);				
			}else {System.out.println("Carte face cach�e");}
		}
		
	}
	
	/**
	 * getter qui renvoie si l'offre est piochable ou non
	 * @return le bool�en correspondant � la piochabilit� de l'offre
	 */
	public boolean getPiochabilite() {
		return this.estPiochable;
	}
	
	/**
	 * setter qui modifie le bool�en de piochabilit� de l'offre
	 * @param b la valeur du bool�en qui modifie la piochabilit� de l'offre
	 */
	public void setPiochabilite(boolean b) {
		this.estPiochable=b;
	}

	

}
