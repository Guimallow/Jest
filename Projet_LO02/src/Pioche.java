import java.util.*;

public class Pioche {
	private boolean a0Carte;
	private LinkedList<Carte> pioche; //PriorityQueue

	public Pioche() {
		
		this.pioche = new LinkedList<Carte>();
		this.a0Carte = false;
		for (Couleur c : Couleur.values()) {
			for (Valeur v : Valeur.values()) {
				if (v != Valeur.JOKER && c!=Couleur.JOKER) {
					
					this.pioche.add(new Carte(v, c));
				}
			}
		}
		
		this.pioche.add(new Carte(Valeur.JOKER, Couleur.JOKER));
		
	}
	
	public void ajoutExtension(){
		
	}
		
	
	public Carte retirerCarteDuHaut() {
		Carte c;
		c=this.pioche.removeLast();
		if (this.pioche.size() == 0){
			a0Carte = true;
		}
		return c;
		
	}
	

	public void melanger() {// m�lange la pioche
		Collections.shuffle(this.pioche);
	}

	public boolean getA0Carte() {
		return this.a0Carte;
	}
	
	public void setA0Carte(){
		if (this.pioche.size() == 0){
			this.a0Carte = true;
		}
	}
	
	public LinkedList<Carte> getPioche(){
		return this.pioche;
	}
	public static void main (String args[]) {
		System.out.println(Couleur.values()) ;
	}
}
