package modele.cartes;

import modele.ConditionTrophee;
import modele.ObjetVisite;
import modele.Visiteur;

/**
 * Classe représentant les trophées du jeu
 *
 */
public class Trophee implements ObjetVisite {
	/**
	 * attribut privé de type Carte représentant la carte étant choisie comme
	 * trophée
	 */
	private Carte carte;
	/**
	 * attribut privé de type ConditionTrophee qui définit la condition pour gagner
	 * le trophée
	 */
	private ConditionTrophee condition;
	/**
	 * attribut privé de type Couleur représentant la couleur concernée par la
	 * condition
	 */
	private Couleur couleurCondition;
	/**
	 * attribut privé de type Valeur représentant la valeur concernée par la
	 * condition
	 */
	private Valeur valeurCondition;

	/**
	 * constructeur du trophée
	 * 
	 * @param c la carte désignée comme trophée
	 */
	public Trophee(Carte c) {
		this.carte = c;
		this.condition = null;
		this.couleurCondition = null;
		this.valeurCondition = null;
	}

	/**
	 * setter qui permet de modifier la carte du trophée
	 * 
	 * @param carte la nouvelle carte du trophée
	 */
	public void setCarte(Carte carte) {
		this.carte = carte;
	}

	/**
	 * getter qui retourne la carte du trophée
	 * 
	 * @return la carte du trophée
	 */
	public Carte getCarte() {
		return this.carte;
	}

	/**
	 * getter qui retourne la condition du trophée
	 * 
	 * @return la condition du trophée
	 */
	public ConditionTrophee getCondition() {
		return this.condition;
	}

	/**
	 * setter qui permet de modifier la condition du trophée
	 * 
	 * @param condition la nouvelle condition du trophée
	 */
	public void setConditionTrophee(ConditionTrophee condition) {
		this.condition = condition;
	}

	/**
	 * getter qui retourne la couleur à laquelle s'applique la condition
	 * 
	 * @return la couleur à laquelle s'applique la condition
	 */
	public Couleur getCouleurCondition() {
		return this.couleurCondition;
	}

	/**
	 * setter qui permet de modifier la couleur à laquelle s'applique la condition
	 * 
	 * @param couleur nouvelle couleur concernée par la condition
	 */
	public void setCouleurCondition(Couleur couleur) {
		this.couleurCondition = couleur;
	}

	/**
	 * getter qui retourne la valeur à laquelle s'applique la condition
	 * 
	 * @return la valeur à laquelle s'applique la condition
	 */
	public Valeur getValeurCondition() {
		return this.valeurCondition;
	}

	/**
	 * setter qui permet de modifier la valeur à laquelle s'applique la condition
	 * 
	 * @param valeur nouvelle valeur concernée par la condition
	 */
	public void setValeurCondition(Valeur valeur) {
		this.valeurCondition = valeur;
	}

	/**
	 * méthode qui accepte la visite par un visteur
	 * 
	 * @param v le visiteur du trophée
	 */
	public void accept(Visiteur v) {
		v.visit(this);
	}

	/**
	 * méthode qui permet d'afficher le trophée avec sa condition
	 * 
	 * @return la trophée et sa condition sous forme d'une chaine de caractères
	 */
	public String toString() {
		StringBuffer sb = new StringBuffer();

		if (this.carte.getValeur() != Valeur.JOKER) {
			sb.append(this.carte.getValeur());
			sb.append(" de ");
			sb.append(this.carte.getCouleur());
		} else {
			sb.append(this.carte.getValeur());
		}
		sb.append(" , Condition: ");
		sb.append(this.getCondition());
		if (this.valeurCondition != null) {
			sb.append(" sur valeur " + this.getValeurCondition());
		} else if (this.couleurCondition != null) {
			sb.append(" sur couleur " + this.getCouleurCondition());
		}

		return sb.toString();
	}

	/**
	 * méthode qui attribue les conditions au trophée en fonction de sa valeur
	 */
	public void conditionTrophee() {

		if (this.carte.getCouleur() == Couleur.COEUR) {
			this.setConditionTrophee(ConditionTrophee.Joker);
		}

		else if (this.carte.getCouleur() == Couleur.CARREAU && this.carte.getValeur() == Valeur.QUATRE) {
			this.setConditionTrophee(ConditionTrophee.BestJestNoJoke);
		}

		else if (this.carte.getCouleur() == Couleur.JOKER && this.carte.getValeur() == Valeur.JOKER) {
			this.setConditionTrophee(ConditionTrophee.BestJest);
		}

		else if ((this.carte.getCouleur() == Couleur.TRÊFLE && this.carte.getValeur() == Valeur.QUATRE)
				|| (this.carte.getCouleur() == Couleur.PIC && this.carte.getValeur() == Valeur.QUATRE)
				|| (this.carte.getCouleur() == Couleur.TRÊFLE && this.carte.getValeur() == Valeur.DEUX)
				|| (this.carte.getCouleur() == Couleur.CARREAU && this.carte.getValeur() == Valeur.TROIS)) {
			this.setConditionTrophee(ConditionTrophee.Lowest);

			if (this.carte.getCouleur() == Couleur.TRÊFLE && this.carte.getValeur() == Valeur.QUATRE) {
				this.setCouleurCondition(Couleur.PIC);
			} else if (this.carte.getCouleur() == Couleur.PIC && this.carte.getValeur() == Valeur.QUATRE) {
				this.setCouleurCondition(Couleur.TRÊFLE);
			} else if (this.carte.getCouleur() == Couleur.TRÊFLE && this.carte.getValeur() == Valeur.DEUX) {
				this.setCouleurCondition(Couleur.COEUR);
			} else {
				this.setCouleurCondition(Couleur.CARREAU);
			}
		}

		else if ((this.carte.getCouleur() == Couleur.TRÊFLE && this.carte.getValeur() == Valeur.AS)
				|| (this.carte.getCouleur() == Couleur.PIC && this.carte.getValeur() == Valeur.AS)
				|| (this.carte.getCouleur() == Couleur.TRÊFLE && this.carte.getValeur() == Valeur.TROIS)
				|| (this.carte.getCouleur() == Couleur.CARREAU && this.carte.getValeur() == Valeur.DEUX)) {
			this.setConditionTrophee(ConditionTrophee.Highest);

			if (this.carte.getCouleur() == Couleur.TRÊFLE && this.carte.getValeur() == Valeur.AS) {
				this.setCouleurCondition(Couleur.PIC);
			} else if (this.carte.getCouleur() == Couleur.PIC && this.carte.getValeur() == Valeur.AS) {
				this.setCouleurCondition(Couleur.TRÊFLE);
			} else if (this.carte.getCouleur() == Couleur.TRÊFLE && this.carte.getValeur() == Valeur.TROIS) {
				this.setCouleurCondition(Couleur.COEUR);
			} else {
				this.setCouleurCondition(Couleur.CARREAU);
			}
		} else if (this.carte.getValeur() == Valeur.CINQ) {
			this.setConditionTrophee(ConditionTrophee.Random);
		} else {
			this.setConditionTrophee(ConditionTrophee.Majority);
			if (this.carte.getValeur() == Valeur.AS) {
				this.setValeurCondition(Valeur.QUATRE);
			}
			if (this.carte.getValeur() == Valeur.DEUX) {
				this.setValeurCondition(Valeur.TROIS);
			} else {
				this.setValeurCondition(Valeur.DEUX);
			}
		}
	}
}
