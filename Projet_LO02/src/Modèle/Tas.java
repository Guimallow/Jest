package Modèle;
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

	public void nouveauTas(Pioche p, ArrayList<Joueur> listeJoueur) {// creer le nouveau tas à partir de la pioche et des cartes restantes dans les offres
		int a = Joueur.getNbJoueurs();
		int i;
		Carte c;
		for (i = 0; i < a; i++) {
			c = p.retirerCarteDuHaut();
			this.tas.add(c);
		}
		for(Joueur j: listeJoueur) {
			if (j.getMain().getOffre().get(0) != null) {
				j.getMain().getOffre().get(0).setVisibilite(false);
				this.tas.add(j.getMain().getOffre().get(0));
				j.getMain().getOffre().remove(0);
			}else {
				j.getMain().getOffre().get(1).setVisibilite(false);
				this.tas.add(j.getMain().getOffre().get(1));
				j.getMain().getOffre().remove(1);
			}
		}
		/*Iterator<Joueur> it = listeJoueur.iterator();
		while (it.hasNext()) {
			if (it.next().getMain().getOffre().get("carte gauche") != null) {
				this.tas.add(it.next().getMain().getOffre().get("carte gauche"));
				it.next().getMain().getOffre().remove("carte gauche");
			} else {
				this.tas.add(it.next().getMain().getOffre().get("carte droite"));
				it.next().getMain().getOffre().remove("carte droite");
			}
		}*/

		Collections.shuffle(this.tas);
	}

	public LinkedList<Carte> getTas() {
		return this.tas;
	}
}
