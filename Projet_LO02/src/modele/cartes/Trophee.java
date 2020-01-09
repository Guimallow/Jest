package modele.cartes;

import modele.ConditionTrophee;
import modele.ObjetVisite;
import modele.Visiteur;

public class Trophee implements ObjetVisite{

	private Carte carte;
	private ConditionTrophee condition;
	private Couleur couleurCondition;
	private Valeur valeurCondition;
	
	public Trophee(Carte c){
		this.carte = c;
		this.condition = null;
		this.couleurCondition = null;
		this.valeurCondition = null;
	}
	
	
	public void setCarte(Carte carte){
		this.carte = carte;
	}
	
	public Carte getCarte(){
		return this.carte;
	}
	
	public ConditionTrophee getCondition() {
		return this.condition;
	}

	public void setConditionTrophee(ConditionTrophee condition) {
		this.condition = condition;
	}
	
	public Couleur getCouleurCondition() {
		return this.couleurCondition;
	}

	public void setCouleurCondition(Couleur couleur) {
		this.couleurCondition = couleur;
	}
	
	public Valeur getValeurCondition() {
		return this.valeurCondition;
	}

	public void setValeurCondition(Valeur valeur) {
		this.valeurCondition = valeur;
	}
	
	public void accept(Visiteur v){
		v.visit(this);
	}
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
			if (this.carte.getValeur() != Valeur.JOKER) {
				sb.append(this.carte.getValeur());
				sb.append(" de ");
				sb.append(this.carte.getCouleur());
			} 
			else {
				sb.append(this.carte.getValeur());
			}
			sb.append(" , Condition: ");
			sb.append(this.getCondition());
			if (this.valeurCondition != null){
				sb.append(" sur valeur " + this.getValeurCondition());
			}
			else if (this.couleurCondition != null){
				sb.append(" sur couleur " + this.getCouleurCondition());
			}
		
		
		return sb.toString();
	}
	public void conditionTrophee(){ //fonction pour attribuer les conditions aux troph�es en fonction de sa valeur et de sa couleur
		//Cette fontion est beaucoup trop compliqu�e pour ce que c'est
		if (this.carte.getCouleur() == Couleur.COEUR){
			this.setConditionTrophee(ConditionTrophee.Joker);
		}
		
		else if (this.carte.getCouleur() == Couleur.CARREAU && this.carte.getValeur() == Valeur.QUATRE){
			this.setConditionTrophee(ConditionTrophee.BestJestNoJoke);
		}
		
		else if (this.carte.getCouleur() == Couleur.JOKER && this.carte.getValeur() == Valeur.JOKER){
			this.setConditionTrophee(ConditionTrophee.BestJest);
		}
		
		else if ((this.carte.getCouleur() == Couleur.TR�FLE && this.carte.getValeur() == Valeur.QUATRE)
				|| (this.carte.getCouleur() == Couleur.PIC && this.carte.getValeur() == Valeur.QUATRE)
				|| (this.carte.getCouleur() == Couleur.TR�FLE && this.carte.getValeur() == Valeur.DEUX)
				|| (this.carte.getCouleur() == Couleur.CARREAU && this.carte.getValeur() == Valeur.TROIS)){
			this.setConditionTrophee(ConditionTrophee.Lowest);
			
			if (this.carte.getCouleur() == Couleur.TR�FLE && this.carte.getValeur() == Valeur.QUATRE){
				this.setCouleurCondition(Couleur.PIC);
			}
			else if (this.carte.getCouleur() == Couleur.PIC && this.carte.getValeur() == Valeur.QUATRE){
				this.setCouleurCondition(Couleur.TR�FLE); 
				}
			else if (this.carte.getCouleur() == Couleur.TR�FLE && this.carte.getValeur() == Valeur.DEUX){
				this.setCouleurCondition(Couleur.COEUR);
			}
			else {this.setCouleurCondition(Couleur.CARREAU);}
		}
		
		else if ((this.carte.getCouleur() == Couleur.TR�FLE && this.carte.getValeur() == Valeur.AS)
				|| (this.carte.getCouleur() == Couleur.PIC && this.carte.getValeur() == Valeur.AS)
				|| (this.carte.getCouleur() == Couleur.TR�FLE && this.carte.getValeur() == Valeur.TROIS)
				|| (this.carte.getCouleur() == Couleur.CARREAU && this.carte.getValeur() == Valeur.DEUX)){
			this.setConditionTrophee(ConditionTrophee.Highest);
			
			if (this.carte.getCouleur() == Couleur.TR�FLE && this.carte.getValeur() == Valeur.AS){
				this.setCouleurCondition(Couleur.PIC);
			}
			else if (this.carte.getCouleur() == Couleur.PIC && this.carte.getValeur() == Valeur.AS){
				this.setCouleurCondition(Couleur.TR�FLE); 
				}
			else if (this.carte.getCouleur() == Couleur.TR�FLE && this.carte.getValeur() == Valeur.TROIS){
				this.setCouleurCondition(Couleur.COEUR);
			}
			else {this.setCouleurCondition(Couleur.CARREAU);}
		}
		else if (this.carte.getValeur() == Valeur.CINQ){
			this.setConditionTrophee(ConditionTrophee.Random);
		}
		else {
			this.setConditionTrophee(ConditionTrophee.Majority);
			if (this.carte.getValeur() == Valeur.AS){
				this.setValeurCondition(Valeur.QUATRE);
			}
			if (this.carte.getValeur() == Valeur.DEUX){
				this.setValeurCondition(Valeur.TROIS);
			}
			else {this.setValeurCondition(Valeur.DEUX);
		}
	}
	}
}


