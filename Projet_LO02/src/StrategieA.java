
public class StrategieA implements Strategie{
	public void faireOffre(JoueurVirtuel a) {
		if(a.main.getOffre().get("carte gauche").valeur.ordinal()<a.main.getOffre().get("carte droite").valeur.ordinal()) {
			a.main.getOffre().get("carte gauche").setVisibilite(true);	
		}
		else {
			a.main.getOffre().get("carte droite").setVisibilite(true);
		}
		
	};
	public void piocherOffre(Joueur a, boolean carteVisible) {
		
	};

}