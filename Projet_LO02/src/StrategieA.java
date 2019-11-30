import java.util.*;

public class StrategieA implements Strategie {
	
	public StrategieA(){
		
	}
	
	public void faireOffre(Joueur a) {
		if (a.getMain().getOffre().get("carte gauche").getValeur().ordinal() < a.getMain().getOffre().get("carte droite").getValeur()
				.ordinal()) {
			a.getMain().getOffre().get("carte gauche").setVisibilite(true);
		} else {
			a.getMain().getOffre().get("carte droite").setVisibilite(true);
		}

	}

	public void piocherOffre(Joueur piocheur, Joueur pioche) {
		if (pioche.getMain().getPiochabilite() == true) {
			if (pioche.getMain().getOffre().get("carte gauche").getVisibilite() == false) {
				piocheur.getJest().getCartes().add(pioche.getMain().getOffre().get("carte gauche"));
				pioche.getMain().getOffre().remove("carte gauche");
			} else {
				piocheur.getJest().getCartes().add(pioche.getMain().getOffre().get("carte droite"));
				pioche.getMain().getOffre().remove("carte droite");
			}
			pioche.getMain().setPiochabilite(false);
		}

	}
	public Joueur choisirJoueurAPiocher(ArrayList<Joueur> liste) {
		boolean cibleChoisie=false;
		Iterator<Joueur> it=liste.iterator();
		while(it.hasNext()&&cibleChoisie==false) {
			it.next();
			if(it.next().getMain().getPiochabilite()==true) {
				cibleChoisie=true;
			}
			
		}
		return it.next();
	}

}
