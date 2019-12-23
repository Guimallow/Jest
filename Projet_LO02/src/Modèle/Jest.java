package Mod�le;
import java.util.*;

public class Jest implements ObjetVisite{
	private ArrayList<Carte> cartes;
	private Joueur joueur; //Permet de faire le lien avec le joueur poss�dant le Jest

	public Jest(Joueur player) {
		this.cartes = new ArrayList<Carte>();
		this.joueur = player;
	}
	public ArrayList<Carte> getCartes(){
		return this.cartes;
	}
	
	public void setCartes(ArrayList<Carte> nouvellesCartes){
		this.cartes = nouvellesCartes;
	}
	
	public void accept(Visiteur v){
		v.visit(this);
	}

	public void afficherJest() {// affiche le jest
		for (Carte carte : this.cartes){
			System.out.println(carte);
		}
	}
	
	public Joueur getJoueur(){
		return this.joueur;
	}
	
	public void ajouterCarte(Carte c){
		this.cartes.add(c);
	}

}
