package Mod�le;
import java.util.*;

public class Main {

	public static void main(String[] args) {
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

}
