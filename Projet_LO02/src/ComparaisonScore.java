import java.util.*;

public class ComparaisonScore implements Comparator<Joueur>{
	
	public int compare(Joueur j1, Joueur j2){
		
		if (j1.getScore() == j2.getScore()){return 0;}
		else if (j1.getScore() > j2.getScore()){return 1;}
		else { return -1;}
	}
}
