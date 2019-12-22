package Modèle;
import java.util.*;

public class Offre {
	private ArrayList<Carte> offre;
	private boolean estPiochable;

	public Offre() {
		this.estPiochable = true;
		this.offre = new ArrayList<Carte>();
	}

	public ArrayList<Carte> getOffre() {
		return offre;
	}
	

	public void afficherOffre() {
		for(Carte c:offre) {
			if(c.getVisibilite()==true) {
				System.out.println(c);				
			}else {System.out.println("Carte face cachée");}
		}
		
	}
	public boolean getPiochabilite() {
		return this.estPiochable;
	}
	public void setPiochabilite(boolean b) {
		this.estPiochable=b;
	}

	

}
