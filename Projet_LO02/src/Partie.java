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
		System.out.println("Que souhaitez vous faire? \n 1. Lancer une partie \n 2. G�rer les param�tres \n");
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
				System.out.println("G�rer partie");
				break;
			default:
				System.out.println("Vous avez tap� un mauvais nombre, veuillez recommencer");
				
			}
		}
		System.out.println("Etape r�ussie");
		sc.close();
			
	}
	
	public static void main(String[] args) {
		
		
				
	}

}
