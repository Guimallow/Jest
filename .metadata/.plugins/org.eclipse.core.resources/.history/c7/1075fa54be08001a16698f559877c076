import java.util.*;

public class Pioche {
	private int nbDeCartes;
	private boolean a0Carte;

	private LinkedList<Carte> pioche;

	public Pioche() {
		this.nbDeCartes = 0;
		this.a0Carte = true;
		this.pioche = new LinkedList<Carte>();
	}

	public void remplir() {// créer la pioche et la remplit entièrement

		this.a0Carte = false;
		for (Couleur c : Couleur.values()) {
			for (Valeur v : Valeur.values()) {
				if (v != Valeur.JOKER) {
					this.nbDeCartes++;
					this.pioche.add(new Carte(v, c));
				}
			}
		}
		this.nbDeCartes++;
		this.pioche.add(new Carte(Valeur.JOKER, Couleur.COEUR));

	}

	public void mélanger() {// mélange la pioche
		Collections.shuffle(this.pioche);
	}

	public int getnbDeCartes() {
		return this.nbDeCartes;
	}

	public boolean geta0Carte() {
		return this.a0Carte;
	}

	public static void main(String[] args) {
		Pioche p = new Pioche();
		p.remplir();
		Carte elementPioche = p.pioche.get(1);
		System.out.println(elementPioche);
		p.mélanger();
		elementPioche = p.pioche.get(1);
		System.out.println(elementPioche);
		System.out.println(p.getnbDeCartes());
		System.out.println(p.geta0Carte());
	}

}
