import java.util.*;

public class Tas {
	private LinkedList<Carte> tas;

	public Tas() {
		tas = new LinkedList<Carte>();
	}

	public Carte retirerCarteDuHaut() {
		Carte c;
		c = this.tas.getLast();
		this.tas.removeLast();
		return c;

	}

	public void nouveauTas(Partie partie) {// creer le nouveau tas � partir de la pioche et des cartes restantes dans les offres
		int joueur = Joueur.getNbJoueurs();
		int i;
		Carte c;
		for (i = 0; i < joueur; i++) {
			c = partie.getPioche().retirerCarteDuHaut();
			this.tas.add(c);
		}
		if (partie.getPioche().getA0Carte(partie) == false){
			for(Joueur j: partie.getJoueurs()) {
				if (j.getMain().getOffre().get(0) != null) {
					j.getMain().getOffre().get(0).setVisibilite(false);
					this.tas.add(j.getMain().getOffre().get(0));
					j.getMain().getOffre().remove(0);
				}
				else {
					j.getMain().getOffre().get(1).setVisibilite(false);
					this.tas.add(j.getMain().getOffre().get(1));
					j.getMain().getOffre().remove(1);
				}

		}
				}

		Collections.shuffle(this.tas);
	}

	public LinkedList<Carte> getTas() {
		return this.tas;
	}
}
