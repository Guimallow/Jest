public class Carte {

	private Couleur couleur;
	private Valeur valeur;
	private boolean estVisible;

	public Carte(Valeur valeur, Couleur couleur) {
		this.setCouleur(couleur);
		this.setValeur(valeur);
		this.estVisible=false;
	}
	

	public Couleur getCouleur() {
		return couleur;
	}

	public void setCouleur(Couleur couleur) {
		this.couleur = couleur;
	}

	public Valeur getValeur() {
		return valeur;
	}

	public void setValeur(Valeur valeur) {
		this.valeur = valeur;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		if(this.valeur!=Valeur.JOKER) {
		sb.append(this.valeur);
		sb.append(" de ");
		sb.append(this.couleur);}
		else {
			sb.append(this.valeur);
		}

		return sb.toString();
	}
	public boolean equals(Carte c){
		if (this.couleur == c.couleur && this.valeur == c.valeur){
			return true;
		} else {
			return false;
		}
	}
	
}
