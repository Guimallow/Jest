import java.util.*;
public interface Strategie {
	public void faireOffre(Joueur a);
	public void piocherOffre(Joueur a, Joueur b);
	public Joueur choisirJoueurAPiocher(ArrayList<Joueur> liste, Joueur j);

}
