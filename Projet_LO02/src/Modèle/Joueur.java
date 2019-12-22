package Modèle;
import java.util.*;

public class Joueur {

	private String pseudo;
	private Jest jest;
	private Offre main;
	private boolean estJouable;
	private static int nbJoueurs = 0;// va être utile pour pouvoir creer le tas à partir de la pioche
	private int score;

	public Joueur(Partie partie) {
		pseudo = null;
		this.jest = new Jest(this);
		this.main = new Offre();
		this.estJouable = true;
		partie.addJoueur(this);
		Joueur.nbJoueurs++;
		this.score = 0;
	}

	public Joueur() {
		pseudo = null;
		this.jest = new Jest(this);
		this.main = new Offre();
		this.score = 0;
	}

	public void piocherDansTas(Tas a) {// prend carte du haut du tas, attribue à la carte sa place dans la main
		Carte c = a.retirerCarteDuHaut();
		this.main.getOffre().add(c);
	}

	public void piocherDansPioche(Pioche p) {// prend carte du haut de la pioche, attribue à la carte sa place dans la
												// main
		Carte c = p.retirerCarteDuHaut();
		this.main.getOffre().add(c);
	}

	public void faireOffre(boolean premiereCarte) {// rend une des cartes visible aux autres joueurs
		if (premiereCarte == true) {
			this.main.getOffre().get(0).setVisibilite(true);
		} else {
			this.main.getOffre().get(1).setVisibilite(true);
		}
	}

	public void piocherOffre(Joueur a, boolean carteVisible) {// enlève la carte choisie de la main et la met dans le
																// jest
		if (a.main.getPiochabilite() == true) {
			if ((carteVisible == true && a.main.getOffre().get(0).getVisibilite() == true)
					|| (carteVisible == false && a.main.getOffre().get(0).getVisibilite() == false)) {
				this.jest.getCartes().add(a.main.getOffre().get(0));
				a.main.getOffre().remove(0);
			} else {
				this.jest.getCartes().add(a.main.getOffre().get(1));
				a.main.getOffre().remove(1);
			}
			a.main.setPiochabilite(false);
		}
		this.estJouable = false;
	}

	public void consulterOffre(Joueur a) {// affiche l'offre d'un joueur, les cartes non visibles sont affichés face
											// cachée
		for(Carte c : a.main.getOffre()) {
			if(c.getVisibilite()==true) {
				System.out.println(c);
			}
			else {System.out.println("Carte face cachée");}
			
		}
	}
	
	public void faireOffre(StrategieA methode) {
		methode.faireOffre(this);
	}
	
	public void piocherOffre(StrategieA methode, Joueur joueurPioche) {
		methode.piocherOffre(this, joueurPioche);
	}
	
	public Joueur choisirJoueurAPiocher(StrategieA methode, ArrayList<Joueur> joueurs) {
		return methode.choisirJoueurAPiocher(joueurs,this); 
	}

	public void consulterMain() {
		this.main.afficherOffre();

	}

	public void consulterJest() {
		this.jest.afficherJest();

	}

	public static int getNbJoueurs() {
		return Joueur.nbJoueurs;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(this.pseudo);
		return sb.toString();

	}

	/*
	 * public static void main(String[] args) { Partie partie; partie =
	 * Partie.getInstance(); Tas t = new Tas(); t.getTas().add(new Carte(Valeur.AS,
	 * Couleur.COEUR)); t.getTas().add(new Carte(Valeur.AS, Couleur.CARREAU));
	 * t.getTas().add(new Carte(Valeur.DEUX, Couleur.PIC)); t.getTas().add(new
	 * Carte(Valeur.QUATRE, Couleur.PIC)); t.getTas().add(new Carte(Valeur.TROIS,
	 * Couleur.PIC)); Joueur a = new Joueur(partie); Joueur b = new Joueur(partie);
	 * b.piocherDansTas(t); b.piocherDansTas(t); b.faireOffre(false); //
	 * main.getOffre().put("carte droite",new Carte(Valeur.TROIS, Couleur.COEUR));
	 * a.piocherDansTas(t); a.piocherDansTas(t); a.faireOffre(true);
	 * a.consulterMain(); b.consulterOffre(a); b.piocherOffre(a, true);
	 * a.consulterMain(); b.jest.afficherJest();
	 * 
	 * }
	 */

	public Jest getJest() {
		return this.jest;
	}

	public String getPseudo() {
		return this.pseudo;
	}

	public void setPseudo(String nom) {
		this.pseudo = nom;
	}

	public void setMain(Offre o) {
		this.main = o;
	}

	public void setJest(Jest j) {
		this.jest = j;
	}

	public Offre getMain() {
		return this.main;
	}

	public boolean getJouabilite() {
		return this.estJouable;
	}
	public void setJouabilite(boolean b) {
		this.estJouable=b;
	}
	
	public int getScore(){
		return this.score;
	}
	
	public void setScore(int score){
		this.score = score;
	}

}
