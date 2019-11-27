import java.util.*;

public class Joueur {
	// Ces arguments sont en protégé pour que seules les classes filles et cette
	// classe puissent les modifier
	protected String pseudo;
	protected Jest jest;
	protected Offre main;
	private static int nbJoueurs = 0;// va être utile pour pouvoir creer le tas à partir de la pioche

	public Joueur(Partie partie) {
		pseudo = null;
		this.jest = new Jest(this);
		this.main = new Offre();
		partie.addJoueur(this);
		Joueur.nbJoueurs++;
	}

	public void piocherDansTas(Tas a) {// prend carte du haut du tas, attribue à la carte sa place dans la main
		Carte c = a.retirerCarteDuHaut();
		if (this.main.getOffre().get("carte gauche") != null) {
			this.main.getOffre().put("carte droite", c);
		} else {
			this.main.getOffre().put("carte gauche", c);
		}
	}

	public void piocherDansPioche(Pioche p) {// prend carte du haut de la pioche, attribue à la carte sa place dans la
												// main
		Carte c = p.retirerCarteDuHaut();
		if (this.main.getOffre().get("carte gauche") != null) {
			this.main.getOffre().put("carte droite", c);
		} else {
			this.main.getOffre().put("carte gauche", c);
		}
	}

	public void faireOffre(boolean carteGauche) {// rend une des cartes visible aux autres joueurs
		if (carteGauche == true) {
			this.main.getOffre().get("carte gauche").setVisibilite(true);
		} else {
			this.main.getOffre().get("carte droite").setVisibilite(true);
		}
	}

	public void piocherOffre(Joueur a, boolean carteVisible) {// enlève la carte choisie de la main et la met dans le
																// jest
		if (a.main.getPiochabilite() == true) {
			if ((carteVisible == true && a.main.getOffre().get("carte gauche").getVisibilite() == true)
					|| (carteVisible == false && a.main.getOffre().get("carte gauche").getVisibilite() == false)) {
				this.jest.getJest().add(a.main.getOffre().get("carte gauche"));
				a.main.getOffre().remove("carte gauche");
			} else {
				this.jest.getJest().add(a.main.getOffre().get("carte droite"));
				a.main.getOffre().remove("carte droite");
			}
			a.main.setPiochabilite(false);
		}
	}

	public void consulterOffre(Joueur a) {// affiche l'offre d'un joueur, les cartes non visibles sont affichés face
											// cachée
		Iterator<Map.Entry<String, Carte>> itMap = a.main.getOffre().entrySet().iterator();
		while (itMap.hasNext()) {
			Map.Entry<String, Carte> entry = itMap.next();
			if (a.main.getOffre().get("carte gauche").getVisibilite() == true && entry.getKey() == "carte gauche") {
				System.out.println(entry.getKey() + ":" + entry.getValue());
			} else if (a.main.getOffre().get("carte droite").getVisibilite() == true
					&& entry.getKey() == "carte droite") {
				System.out.println(entry.getKey() + ":" + entry.getValue());
			} else {
				System.out.println(entry.getKey() + ": face cachée");
			}
		}
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

	public static void main(String[] args) {
		Partie partie;
		partie = Partie.getInstance();
		Tas t = new Tas();
		t.getTas().add(new Carte(Valeur.AS, Couleur.COEUR));
		t.getTas().add(new Carte(Valeur.AS, Couleur.CARREAU));
		t.getTas().add(new Carte(Valeur.DEUX, Couleur.PIC));
		t.getTas().add(new Carte(Valeur.QUATRE, Couleur.PIC));
		t.getTas().add(new Carte(Valeur.TROIS, Couleur.PIC));
		Joueur a = new Joueur(partie);
		Joueur b = new Joueur(partie);
		b.piocherDansTas(t);
		b.piocherDansTas(t);
		b.faireOffre(false);
		// main.getOffre().put("carte droite",new Carte(Valeur.TROIS, Couleur.COEUR));
		a.piocherDansTas(t);
		a.piocherDansTas(t);
		a.faireOffre(true);
		a.consulterMain();
		b.consulterOffre(a);
		b.piocherOffre(a, true);
		a.consulterMain();
		b.jest.afficherJest();

	}

	public Jest getJest() {
		return this.jest;
	}

	public String getPseudo() {
		return this.pseudo;
	}

	public Offre getMain() {
		return this.main;
	}
	public void faireOffre(StrategieA methode) {
		methode.faireOffre(this);
	}
	public void piocherOffre(StrategieA methode, Joueur joueurPioche) {
		methode.piocherOffre(this, joueurPioche);
	}
}
