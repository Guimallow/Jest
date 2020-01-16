package modele.cartes;

import modele.ConditionTrophee;
import modele.ObjetVisite;
import modele.Visiteur;

/**
 * Classe repr�sentant les troph�es du jeu
 *
 */
public class Trophee implements ObjetVisite {
	/**
	 * attribut priv� de type Carte repr�sentant la carte �tant choisie comme
	 * troph�e
	 */
	private Carte carte;
	/**
	 * attribut priv� de type ConditionTrophee qui d�finit la condition pour gagner
	 * le troph�e
	 */
	private ConditionTrophee condition;
	/**
	 * attribut priv� de type Couleur repr�sentant la couleur concern�e par la
	 * condition
	 */
	private Couleur couleurCondition;
	/**
	 * attribut priv� de type Valeur repr�sentant la valeur concern�e par la
	 * condition
	 */
	private Valeur valeurCondition;

	/**
	 * constructeur du troph�e
	 * 
	 * @param c la carte d�sign�e comme troph�e
	 */
	public Trophee(Carte c) {
		this.carte = c;
		this.condition = null;
		this.couleurCondition = null;
		this.valeurCondition = null;
	}

	/**
	 * setter qui permet de modifier la carte du troph�e
	 * 
	 * @param carte la nouvelle carte du troph�e
	 */
	public void setCarte(Carte carte) {
		this.carte = carte;
	}

	/**
	 * getter qui retourne la carte du troph�e
	 * 
	 * @return la carte du troph�e
	 */
	public Carte getCarte() {
		return this.carte;
	}

	/**
	 * getter qui retourne la condition du troph�e
	 * 
	 * @return la condition du troph�e
	 */
	public ConditionTrophee getCondition() {
		return this.condition;
	}

	/**
	 * setter qui permet de modifier la condition du troph�e
	 * 
	 * @param condition la nouvelle condition du troph�e
	 */
	public void setConditionTrophee(ConditionTrophee condition) {
		this.condition = condition;
	}

	/**
	 * getter qui retourne la couleur � laquelle s'applique la condition
	 * 
	 * @return la couleur � laquelle s'applique la condition
	 */
	public Couleur getCouleurCondition() {
		return this.couleurCondition;
	}

	/**
	 * setter qui permet de modifier la couleur � laquelle s'applique la condition
	 * 
	 * @param couleur nouvelle couleur concern�e par la condition
	 */
	public void setCouleurCondition(Couleur couleur) {
		this.couleurCondition = couleur;
	}

	/**
	 * getter qui retourne la valeur � laquelle s'applique la condition
	 * 
	 * @return la valeur � laquelle s'applique la condition
	 */
	public Valeur getValeurCondition() {
		return this.valeurCondition;
	}

	/**
	 * setter qui permet de modifier la valeur � laquelle s'applique la condition
	 * 
	 * @param valeur nouvelle valeur concern�e par la condition
	 */
	public void setValeurCondition(Valeur valeur) {
		this.valeurCondition = valeur;
	}

	/**
	 * m�thode qui accepte la visite par un visteur
	 * 
	 * @param v le visiteur du troph�e
	 */
	public void accept(Visiteur v) {
		v.visit(this);
	}

	/**
	 * m�thode qui permet d'afficher le troph�e avec sa condition
	 * 
	 * @return la troph�e et sa condition sous forme d'une chaine de caract�res
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
	 * m�thode qui attribue les conditions au troph�e en fonction de sa valeur
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

		else if ((this.carte.getCouleur() == Couleur.TR�FLE && this.carte.getValeur() == Valeur.QUATRE)
				|| (this.carte.getCouleur() == Couleur.PIC && this.carte.getValeur() == Valeur.QUATRE)
				|| (this.carte.getCouleur() == Couleur.TR�FLE && this.carte.getValeur() == Valeur.DEUX)
				|| (this.carte.getCouleur() == Couleur.CARREAU && this.carte.getValeur() == Valeur.TROIS)) {
			this.setConditionTrophee(ConditionTrophee.Lowest);

			if (this.carte.getCouleur() == Couleur.TR�FLE && this.carte.getValeur() == Valeur.QUATRE) {
				this.setCouleurCondition(Couleur.PIC);
			} else if (this.carte.getCouleur() == Couleur.PIC && this.carte.getValeur() == Valeur.QUATRE) {
				this.setCouleurCondition(Couleur.TR�FLE);
			} else if (this.carte.getCouleur() == Couleur.TR�FLE && this.carte.getValeur() == Valeur.DEUX) {
				this.setCouleurCondition(Couleur.COEUR);
			} else {
				this.setCouleurCondition(Couleur.CARREAU);
			}
		}

		else if ((this.carte.getCouleur() == Couleur.TR�FLE && this.carte.getValeur() == Valeur.AS)
				|| (this.carte.getCouleur() == Couleur.PIC && this.carte.getValeur() == Valeur.AS)
				|| (this.carte.getCouleur() == Couleur.TR�FLE && this.carte.getValeur() == Valeur.TROIS)
				|| (this.carte.getCouleur() == Couleur.CARREAU && this.carte.getValeur() == Valeur.DEUX)) {
			this.setConditionTrophee(ConditionTrophee.Highest);

			if (this.carte.getCouleur() == Couleur.TR�FLE && this.carte.getValeur() == Valeur.AS) {
				this.setCouleurCondition(Couleur.PIC);
			} else if (this.carte.getCouleur() == Couleur.PIC && this.carte.getValeur() == Valeur.AS) {
				this.setCouleurCondition(Couleur.TR�FLE);
			} else if (this.carte.getCouleur() == Couleur.TR�FLE && this.carte.getValeur() == Valeur.TROIS) {
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
