package modele.joueurs;


import controleur.*;
import modele.cartes.Carte;
import modele.cartes.Jest;
import modele.cartes.Offre;
import modele.cartes.Pioche;
import modele.cartes.Tas;
/**
 * Classe repr�sentant un joueur
 */

public class Joueur {

	/**
	 * attribut priv� de type cha�ne de caract�re qui d�finit le nom du joueur
	 */
	protected String pseudo;
	/**
	 * attribut priv� de type Jest repr�sentant le jest d'un joueur {@link Jest}
	 */
	protected Jest jest;
	/**
	 * attribut priv� de type Offre repr�sentant la main d'un joueur {@link Main}
	 */
	protected Offre main;
	/**
	 * attribut priv� de type bool�en qui d�finit si le joueur peut jouer
	 */
	protected boolean estJouable;
	/**
	 * attribut priv� statique de type entier repr�sentant le nombre de joueurs dans
	 * la partie
	 */
	private static int nbJoueurs = 0;
	/**
	 * attribut priv� de type entier qui d�finit le score du joueur
	 */
	protected int score;

	/**
	 * constructeur de la classe Joueur avec comme param�tre la partie
	 * {@link Partie}
	 * 
	 * @param partie la partie dans laquelle va jouer le joueur
	 */
	public Joueur(Partie partie) {
		pseudo = null;
		this.jest = new Jest(this);
		this.main = new Offre();
		this.estJouable = true;
		partie.addJoueur(this);
		Joueur.nbJoueurs++;
		this.score = 0;
	}

	/**
	 * constructeur de la classe Joueur sans param�tre d'entr�e
	 */
	public Joueur() {
		pseudo = null;
		this.jest = new Jest(this);
		this.main = new Offre();
		this.score = 0;
	}

	/**
	 * m�thode qui affiche l'offre d'un joueur
	 * 
	 * @param a le joueur que l'on souhaite consulter
	 */
	public void consulterOffre(Joueur a) {

		for (Carte c : a.main.getOffre()) {
			if (c.getVisibilite() == true) {
				System.out.println(c);
			} else {
				System.out.println("Carte face cach�e");
			}

		}
	}
	/**
	 * m�thode qui fait piocher le joueur dans le tas de la partie {@link Tas}
	 * 
	 * @param a le tas dans lequel pioche le joueur
	 */
	public void piocherDansTas(Tas a) {
		Carte c = a.retirerCarteDuHaut();
		this.main.getOffre().add(c);
	}

	/**
	 * m�thode qui fait piocher le joueur dans la pioche de la partie {@link Pioche}
	 * 
	 * @param p la pioche dans laquelle pioche le joueur
	 */
	public void piocherDansPioche(Pioche p) {
		Carte c = p.retirerCarteDuHaut();
		this.main.getOffre().add(c);
	}
	
	/**
	 * m�thode qui affiche sa main
	 */
	public void consulterMain() {
		this.main.afficherOffre();

	}
	/**
	 * m�thode qui affiche son jest
	 */
	public void consulterJest() {
		this.jest.afficherJest();

	}
	/**
	 * getter qui retourne le nombre de joueurs de la partie
	 * @return le nombre de joueurs de la partie, de type entier
	 */
	public static int getNbJoueurs() {
		return Joueur.nbJoueurs;
	}
	/**
	 * retourne le pseudo du joueur
	 * @return le pseudo, de type chaine de caract�re
	 */
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(this.pseudo);
		return sb.toString();

	}
	/**
	 * getter qui retourne le jest du joueur
	 * @return le jest du joueur
	 */
	public Jest getJest() {
		return this.jest;
	}
	/**
	 * getter qui retourne le pseudo du joueur
	 * @return le pseudo du joueur de type chaine de caract�re
	 */
	public String getPseudo() {
		return this.pseudo;
	}
	/**
	 * setter qui permet de modifier le nom d'un joueur
	 * @param nom le nouveau pseudo du joueur
	 */
	public void setPseudo(String nom) {
		this.pseudo = nom;
	}
	/**
	 * setter qui permet de modifier la main d'un joueur
	 * @param o la nouvelle main du joueur
	 */
	public void setMain(Offre o) {
		this.main = o;
	}
	/**
	 * setter qui permet de modifier le jest du joueur
	 * @param j le nouveau jest du joueur
	 */
	public void setJest(Jest j) {
		this.jest = j;
	}
	/**
	 * getter qui retourne la main d'un  joueur
	 * @return la main du joueur
	 */
	public Offre getMain() {
		return this.main;
	}
	/**
	 * getter qui retourne si un joueur est jouable ou pas
	 * @return le bool�en qui repr�sente la jouabilit� du joueur
	 */
	public boolean getJouabilite() {
		return this.estJouable;
	}
	/**
	 * setter qui permet de modifier la jouabilit� d'un joueur
	 * @param b le bool�en correspondant � la nouvelle jouabilit� du joueur
	 */
	public void setJouabilite(boolean b) {
		this.estJouable = b;
	}
	/**
	 * getter qui retourne le score du joueur
	 * @return le score du joueur, de type entier
	 */
	public int getScore() {
		return this.score;
	}
	/**
	 * setter qui permet de modifier le score d'un joueur
	 * @param score le nouveau score du joueur
	 */
	public void setScore(int score) {
		this.score = score;
	}

}
