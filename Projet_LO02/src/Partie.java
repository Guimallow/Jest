import java.util.*;

public class Partie {
	private static Partie partie = null;
	private ArrayList<Joueur> joueurs;
	private int nbJoueur;
	private int nbJoueurVirtuel;
	//private Tas tas;
	//Private Pioche pioche;

	private Partie() {
		this.joueurs = new ArrayList<Joueur>();
		this.nbJoueur = 3;
		this.nbJoueurVirtuel = 1;
		//this.tas = new Tas();
		//this.pioche = new Pioche();
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
		/*this.pioche.melanger();
		this.trophee1 = new Trophee(this.pioche.retirerCarteDuHaut());
		if (nbJoueur == 3) {
			this.trophee2 = new Trophee(this.pioche.retirerCarteDuHaut());
		}*/
	}

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Partie.getInstance();
		partie.configurerPartie(sc);
		partie.initialisationPartie(sc);
		//Iterator<Joueur> it = partie.joueurs.iterator();
		
		sc.close();
		
		Pioche pioche;
		Tas tas;
		Arbitre arbitre;
		Trophee trophee1;
		Trophee trophee2;
		ArrayList<Joueur> joueurs;
		LinkedList<Joueur> classementFinal;
		StrategieA strategieA;
		
		
		joueurs = partie.getJoueurs();
		arbitre = new Arbitre();
		pioche = new Pioche();
		tas = new Tas();
		pioche.melanger();
		trophee1 = new Trophee(pioche.retirerCarteDuHaut());
		if (joueurs.size() == 4){
			trophee2 = new Trophee(pioche.retirerCarteDuHaut());
		}
		else {
			trophee2 = null;
		}
		strategieA = new StrategieA();
		
		
		/*Plan d'un tour de jeu: 
		 * Tant que pioche non vide(et que tout le monde peut piocher)
		 	* � Chaque joueur: Pioche 2 cartes dans le tas + fait offre (dans l'ordre de meilleur jest)
		 	* Chaque joueur: Pioche dans offre d'un autre joueur si piochable + ajoute � son Jest
		 	* 	--> Joueur dont on vient de piocher la carte
		 	* 	--> Si dernier joueur: peut piocher dans sa propre offre
		 	* On remet les cartes restantes dans le tas � distribuer + on y ajoute autant de cartes de la ioche qu'il y a de joueurs
		 	* On distribue deux cartes du tas ainsi obtenu
		 * Quand pioche vide:
		 * � Joueurs piochent carte restante dans leur Jest
		 * � Attribution troph�es
		 * � D�signation du vainqueur
		 */
		
		//Premier tour de jeu diff�rent des autres puisqu'on part uniquement de la pioche donc on va l'initialiser en dehors du while
		//On distribue donc deux cartes de la pioche aux joueurs
		for (Joueur j : joueurs){
			j.jest.ajouterCarte(pioche.retirerCarteDuHaut());
			j.jest.ajouterCarte(pioche.retirerCarteDuHaut());
		}
		//La fonction etablirClassement n'�tant pas au point, on ne va pas encore faire la r�gle comme quoi le joueur avec le plus grand jest commence � piocher
		while (pioche.geta0Carte() == false){
			//On set le a0Carte en d�but de boucle parce que, quand la pioche sera vide, on aura les derni�re cartes � distribuer dans le tas
			pioche.seta0Carte();
			
			//Chacun fait son offre, dans l'ordre d'inscription des joueurs
			for (Joueur j : joueurs){
				if (j instanceof JoueurReel){
					boolean carteGauche = false;
					String carteVisible;
					System.out.println("Quelle carte souhaitez-vous rendre visible ? Gauche : 1 Droite: 2   ");
					Scanner carteV = new Scanner(System.in);
					carteVisible = carteV.nextLine();
					if (carteVisible  == "1"){
						carteGauche = true;
					}
					j.faireOffre(carteGauche);
					carteV.close();
				}
				else if (j instanceof JoueurVirtuel){
					j.faireOffre(strategieA);
				}
			}
			//On pioche ensuite dans les offres des autres
			int nbJoueurs = joueurs.size();
			int compte = 0;
			int index = 0;
			
			while (compte < nbJoueurs){
				
				System.out.println("C'est au tour de : " + joueurs.get(index).getPseudo());
				
				boolean carteVisible = false;
				
				if (joueurs.get(index) instanceof JoueurReel){
					//Consultation des jests adverses
					String reponseString = "O";
					while (reponseString == "O"){
						System.out.println("Voulez-vous consulter une offre ? Oui : O, Non: N ");
						Scanner reponse = new Scanner(System.in);
						reponseString = reponse.nextLine();
						if (reponseString == "O"){
							System.out.println("De quel joueur voulez-vous consulter l'offre ? (Indiquez l'index)  ");
							Scanner reponseJoueur = new Scanner(System.in);
							String reponseStringJoueur = reponseJoueur.nextLine();
							joueurs.get(index).consulterOffre(joueurs.get(Integer.parseInt(reponseStringJoueur)));
							reponseJoueur.close();
						}
						reponse.close();
						
					//Choix de la carte qu'on veut prendre et ajouter � son jest
					System.out.println("Il est temps de choisir ! Chez quel joueur voulez-vous prendre une carte ? (Indiquez l'index)  ");
					Scanner jreponse = new Scanner(System.in);
					String joueurAVoler = jreponse.nextLine();
					
					//On v�rifie qu'on peut bien piocher dans l'offre de ce joueur
					while (joueurs.get(Integer.parseInt(joueurAVoler)).getMain().getPiochabilite() == false){
						System.out.println("Malheureusement, ce joueur n'a plus qu'une carte dans son offre, veuillez en choisir un autre :   ");
						jreponse = new Scanner(System.in);
						joueurAVoler = jreponse.nextLine();
					}
					
					System.out.println("Et quelle carte souhaitez-vous prendre ? Visible: V, Cach�e: C   ");
					Scanner creponse = new Scanner(System.in);
					String carteAPiocher = creponse.nextLine();
					if (carteAPiocher == "V"){
						carteVisible = true;
					}
					joueurs.get(index).piocherOffre(joueurs.get(Integer.parseInt(joueurAVoler)), carteVisible);
					tas.nouveauTas(pioche, joueurs);
					compte ++;
					index = Integer.parseInt(joueurAVoler);
					jreponse.close();
					creponse.close();
					}
				}
				
				else if (joueurs.get(index) instanceof JoueurVirtuel){
					
				}
			}
			//On met ensuite les cartes de la pioche (autant qu'il y a de joueurs) dans le tas et les cartes non pioch�e
			tas.nouveauTas(pioche, joueurs);
			
		}//fin du while a0Carte
		
		//Quand pioche vide
		System.out.println("La pioche est vide, vous r�cup�rer votre derni�re carte.");
			//On ajoute la carte restante � l'offre de chaque joueur dans son propre jest
		for (Joueur j : joueurs){
			if (j.getMain().getOffre().get("carte gauche") != null){
				j.getJest().getJest().add(j.getMain().getOffre().get("carte gauche"));
			}
			else if (j.getMain().getOffre().get("carte droite") != null){
				j.getJest().getJest().add(j.getMain().getOffre().get("carte droite"));
			}
		}
		
		//D�but de la d�finition des vainqueurs:
		arbitre.attribuerTrophee(joueurs, trophee1, trophee2);
		classementFinal = arbitre.etablirClassement(joueurs);
		
		System.out.println("Le gagnant est : " + classementFinal.get(1) + "\n F�licitations !");
		
	}

}
