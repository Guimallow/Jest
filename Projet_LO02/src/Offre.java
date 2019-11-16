import java.util.*;

public class Offre {
	private HashMap<String,Carte> offre;
	private boolean estPiochable;

	public Offre() {
		this.estPiochable = true;
		this.offre = new HashMap<String,Carte>();
	}

	public HashMap<String,Carte> getOffre() {
		return offre;
	}
	

	public void afficherOffre() {
		Iterator<Map.Entry<String, Carte>> itMap=offre.entrySet().iterator();
		while(itMap.hasNext()) {
			Map.Entry<String, Carte> entry=itMap.next();
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
	}
	public boolean getPiochabilite() {
		return this.estPiochable;
	}
	public void setPiochabilite(boolean b) {
		this.estPiochable=b;
	}

	public static void main(String[] args) {
		Offre main = new Offre();
		main.offre.put("carte gauche",new Carte(Valeur.DEUX, Couleur.COEUR));
		main.offre.put("carte droite",new Carte(Valeur.TROIS, Couleur.COEUR));
		main.afficherOffre();
		
	}

}
