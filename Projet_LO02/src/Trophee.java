
public class Trophee implements ObjetVisite{
	private boolean estAttribue;
	private Carte carte;
	
	public Trophee(Carte c){
		this.estAttribue = false;
		this.carte = c;
	}
	
	public void setAttribution(boolean b){
		this.estAttribue = b;
	}
	
	public boolean getAttribution(){
		return this.estAttribue;
	}
	
	public void setCarte(Carte carte){
		this.carte = carte;
	}
	
	public Carte getCarte(){
		return this.carte;
	}
	
	public void accept(Visiteur v){
		v.visit(this);
	}
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
			if (this.carte.valeur != Valeur.JOKER) {
				sb.append(this.carte.valeur);
				sb.append(" de ");
				sb.append(this.carte.couleur);
			} 
			else {
				sb.append(this.carte.valeur);
			}
		
		
		return sb.toString();
	}
	
}
