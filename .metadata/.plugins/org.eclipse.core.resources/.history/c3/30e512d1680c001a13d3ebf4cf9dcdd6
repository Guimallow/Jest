import java.util.*;
public class Partie {
	private static Partie partie=null;
	private ArrayList<Joueur> joueurs;
	
	
	private Partie() {
		joueurs=new ArrayList<Joueur>();
			
	}
	public static Partie getInstance() {
		if(partie==null) {
			partie=new Partie();
		}
		return partie;
	}
	
	public void addJoueur(Joueur joueur){
		joueurs.add(joueur);
	}

}
