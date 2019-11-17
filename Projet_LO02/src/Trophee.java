
public class Trophee implements ObjetVisite{
	private boolean estAttribue;
	private Carte carte;
	
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
	
}
