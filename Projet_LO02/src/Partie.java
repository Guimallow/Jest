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
		this.joueurs.add(joueur);
	}
	
	public ArrayList<Joueur> getJoueurs(){
		return this.joueurs;
	}
	
	public void configurerPartie(){
		System.out.println("------Jeu De Jest------ \n");
		System.out.println("Que souhaitez vous faire? \n 1. Lancer une partie \n 2. Gérer les paramètres \n");
		Scanner sc = new Scanner(System.in);
		String choix = "0";
		boolean valide=false;
		while (valide==false) {
			
			choix = sc.nextLine();

			switch (choix) {
			case "1":
				valide=true;
				System.out.println("Lancement partie");
				
				break;
			case "2":
				valide=true;
				System.out.println("Gérer partie");
				break;
			default:
				System.out.println("Vous avez tapé un mauvais nombre, veuillez recommencer");
				
			}
		}
		System.out.println("Etape réussie");
		sc.close();
			
	}
	
	public static void main(String[] args) {
		
		
				
	}

}
