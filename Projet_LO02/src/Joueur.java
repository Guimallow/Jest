import java.util.*;

public class Joueur {
	private String pseudo;
	private Jest jest;
	private Offre main;

	public Joueur() {
		pseudo = null;
		this.jest = new Jest();
		this.main = new Offre();
	}
	
	public void piocherDansTas(Tas a) {
		Carte c=a.retirerCarteDuHaut();
		this.main.getOffre().add(c);
	}
	

	public void consulterMain() {
		this.main.afficherOffre();

	}

	public void consulterJest() {
		this.jest.afficherJest();

	}

	public static void main(String[] args) {
		Tas t= new Tas();
		t.getTas().add(new Carte(Valeur.AS, Couleur.COEUR));
		t.getTas().add(new Carte(Valeur.AS, Couleur.CARREAU));
		Joueur a = new Joueur();
		Offre main = new Offre();
		main.getOffre().add(new Carte(Valeur.TROIS, Couleur.COEUR));	
		a.main = main;
		a.piocherDansTas(t);
		a.consulterMain();

	}
}
