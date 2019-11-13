import java.util.*;

public class Offre {
	private HashSet<Carte> offre;
	private boolean estPiochable;

	public Offre() {
		this.estPiochable = true;
		this.offre = new HashSet<Carte>(2);
	}

	public HashSet<Carte> getOffre() {
		return offre;
	}
	

	public void afficherOffre() {// affiche l'offre
		Iterator<Carte> it = this.offre.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

	public static void main(String[] args) {
		Offre main = new Offre();
		main.offre.add(new Carte(Valeur.DEUX, Couleur.COEUR));
		main.offre.add(new Carte(Valeur.TROIS, Couleur.COEUR));
		main.afficherOffre();
		
	}

}
