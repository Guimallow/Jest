import java.util.*;

public class Partie {
	private static Partie partie = null;
	private ArrayList<Joueur> joueurs;
	private int nbJoueur;
	private int nbJoueurVirtuel;
	private Pioche pioche;
	private Tas tas;
	private Trophee trophee1 = null;
	private Trophee trophee2 = null;

	private Partie() {
		this.joueurs = new ArrayList<Joueur>();
		this.nbJoueur = 3;
		this.nbJoueurVirtuel = 1;
		this.pioche = new Pioche();
		this.tas = new Tas();

	}

	public static Partie getInstance() {
		if (partie == null) {
			partie = new Partie();
		}
		return partie;
	}

	public void addJoueur(Joueur joueur) {
		this.joueurs.add(joueur);
	}

	public ArrayList<Joueur> getJoueurs() {
		return this.joueurs;
	}

	public void configurerNbJoueur(Scanner sc) {
		System.out.println("\n Combien de joueurs souhaitez vous (entre 3 et 4)?\n ");

		String choix = "0";
		boolean valide = false;
		while (valide == false) {

			choix = sc.nextLine();

			switch (choix) {
			case "3":
				this.nbJoueur = 3;
				valide = true;
				break;
			case "4":
				this.nbJoueur = 4;
				valide = true;

				break;
			default:
				System.out.println("Vous avez tap� un mauvais nombre, veuillez recommencer");

			}
		}

	}

	public void configurerNbJoueurVirtuel(Scanner sc) {
		System.out.println("\n Combien de joueurs virtuels souhaitez vous (inf�rieur � " + this.nbJoueur + ")?");

		String choix = "0";
		boolean valide = false;
		while (valide == false) {

			choix = sc.nextLine();

			switch (choix) {
			case "0":
				this.nbJoueurVirtuel = 0;
				valide = true;
				break;
			case "1":
				this.nbJoueurVirtuel = 1;
				valide = true;
				break;
			case "2":
				this.nbJoueurVirtuel = 2;
				valide = true;
				break;
			case "3":
				if (this.nbJoueur == 4) {
					this.nbJoueurVirtuel = 3;
					valide = true;
					break;
				} else {
					System.out.println("Vous avez tap� un mauvais nombre, veuillez recommencer");

				}
			default:
				System.out.println("Vous avez tap� un mauvais nombre, veuillez recommencer");

			}
		}

		
	}

	public void configurerPartie(Scanner sc) {
		System.out.println("------Jeu De Jest------ \n");
		System.out.println("Que souhaitez vous faire? \n 1. Lancer une partie \n 2. G�rer les param�tres \n");
		String choix1 = "0";
		boolean valide = false;
		while (valide == false) {

			choix1 = sc.nextLine();

			switch (choix1) {
			case "1":
				valide = true;
				break;
			case "2":
				partie.configurerNbJoueur(sc);
				partie.configurerNbJoueurVirtuel(sc);
				valide = true;

				break;
			default:
				System.out.println("Vous avez tap� un mauvais nombre, veuillez recommencer");

			}
		}

	}

	public void initialisationPartie(Scanner sc) {// creer les joueurs avec leur pseudo, choisi les trophees de la partie
		int i;
		String pseudo = "0";
		for (i = 0; i < (nbJoueur - nbJoueurVirtuel); i++) {
			System.out.println("Choisir un pseudo pour le joueur" + (i + 1));
			pseudo = sc.nextLine();
			new JoueurReel(pseudo, this);
		}
		while (i < nbJoueur) {
			new JoueurVirtuel(this);
			i++;
		}
		this.pioche.m�langer();
		this.trophee1 = new Trophee(this.pioche.retirerCarteDuHaut());
		if (nbJoueur == 3) {
			this.trophee2 = new Trophee(this.pioche.retirerCarteDuHaut());
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Partie.getInstance();
		partie.configurerPartie(sc);
		partie.initialisationPartie(sc);
		Iterator<Joueur> it = partie.joueurs.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());

		}
		System.out.println("Trophee1:"+partie.trophee1);
		System.out.println("Trophee2:"+partie.trophee2);
		sc.close();

	}

}
