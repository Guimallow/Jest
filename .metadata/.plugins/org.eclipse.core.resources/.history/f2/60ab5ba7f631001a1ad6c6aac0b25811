/**
 * Classe représentant une carte du jeu
 */
public class Carte {
	/**
	 * attribut privé de type Couleur représentant la couleur de la carte {@link Couleur}
	 */
	private Couleur couleur;
	/**
	 * attribut privé de type Valeur représentant la valeur de la carte {@link Valeur}
	 */
	private Valeur valeur;
	/**
	 * attribut privé de type booléen qui définit la visibilité de la carte
	 */
	private boolean estVisible;

	/**
	 * constructeur de la classe Carte avec comme paramètres sa valeur et sa couleur
	 * et qui initialise la visibilité de la carte à false
	 * 
	 * @param valeur  valeur de la carte (de type Valeur) 
	 * @param couleur couleur de la carte (de type Couleur)
	 */
	public Carte(Valeur valeur, Couleur couleur) {
		this.setCouleur(couleur);
		this.setValeur(valeur);
		this.estVisible = false;
	}
	
	/**
	 * méthode qui compare la carte courante à la carte en paramètre
	 * 
	 * @param c la carte à comparer avec la carte courante
	 * @return un booléen qui prend la valeur vraie si la carte courante est
	 *         supérieure à c et faux sinon
	 */
	public boolean cartePlusHaute(Carte c) {//compare la carte courante à la carte en paramètre
		if(this.valeur.ordinal()>c.valeur.ordinal()) {
			return true;
		}
		if(this.valeur.ordinal()<c.valeur.ordinal()) {
			return false;
		}
		else {
			if(this.couleur.ordinal()>c.couleur.ordinal()) {
				return true;
			}
			else {
				return false;
			}
		}
	}

	/**
	 * getter qui renvoie la couleur de la carte
	 * @return la couleur de la carte
	 */
	public Couleur getCouleur() {
		return this.couleur;
	}
	
	/**
	 * setter qui modifie la couleur de la carte
	 * @param couleur la couleur à attribuer à la carte
	 */
	public void setCouleur(Couleur couleur) {
		this.couleur = couleur;
	}
	
	/**
	 * getter qui renvoie la valeur de la carte
	 * @return la valeur de la carte
	 */
	public Valeur getValeur() {
		return this.valeur;
	}
	
	/**
	 * setter qui modifie la valeur de la carte
	 * @param valeur la valeur à attribuer à la carte
	 */
	public void setValeur(Valeur valeur) {
		this.valeur = valeur;
	}

	/**
	 * getter qui renvoie si la carte est visible ou non
	 * @return le booléen correspondant à la visibilité de la carte
	 */
	public boolean getVisibilite() {
		return this.estVisible;
	}
	
	/**
	 * setter qui modifie la visibilité de la carte
	 * @param b la valeur du booléen qui modifie la visibilité de la carte
	 */
	public void setVisibilite(boolean b) {
		this.estVisible = b;
	}
	

	/**
	 * méthode permettant d'afficher la carte avec sa valeur puis sa couleur
	 * @return la chaîne de caractères correspondant à la carte
	 */
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
			if (this.valeur != Valeur.JOKER) {
				sb.append(this.valeur);
				sb.append(" de ");
				sb.append(this.couleur);
			} 
			else {
				sb.append(this.valeur);
			}
		
		
		return sb.toString();
	}

	/**
	 * méthode qui vérifie si la carte courante est égale à la carte en paramètre
	 * @param c carte à comparer avec la carte courante
	 * @return un booléen qui prend la valeur vraie si les deux cartes sont égales et faux sinon
	 */
	public boolean equals(Carte c) {
		if (this.couleur == c.couleur && this.valeur == c.valeur) {
			return true;
		} else {
			return false;
		}
	}

}
