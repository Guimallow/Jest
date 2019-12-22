package Mod�le;

public class Carte {

	private Couleur couleur;
	private Valeur valeur;
	private boolean estVisible;
	//Joker a une valeur JOKER et une couleur JOKER

	public Carte(Valeur valeur, Couleur couleur) {
		this.setCouleur(couleur);
		this.setValeur(valeur);
		this.estVisible = false;
	}
	
	public boolean cartePlusHaute(Carte c) {//compare la carte courante � la carte en param�tre
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

	public Couleur getCouleur() {
		return this.couleur;
	}

	public void setCouleur(Couleur couleur) {
		this.couleur = couleur;
	}

	public Valeur getValeur() {
		return this.valeur;
	}

	public void setValeur(Valeur valeur) {
		this.valeur = valeur;
	}

	public boolean getVisibilite() {
		return this.estVisible;
	}

	public void setVisibilite(boolean b) {
		this.estVisible = b;
	}
	


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

	public boolean equals(Carte c) {
		if (this.couleur == c.couleur && this.valeur == c.valeur) {
			return true;
		} else {
			return false;
		}
	}

}
