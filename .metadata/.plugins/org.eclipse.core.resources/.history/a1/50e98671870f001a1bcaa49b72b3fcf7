import java.util.*;

public class Tas {
	private LinkedList<Carte> tas;
	public Tas() {
		tas= new LinkedList<Carte>();
	}
	public Carte retirerCarteDuHaut() {
		Carte c;
		c=this.tas.getLast();
		this.tas.removeLast();
		return c;
		
	}
	public void nouveauTas(Pioche p, ArrayList<Joueur> listeJoueur) {//creer le nouveau tas à partir de la pioche et des cartes restantes dans les offres
		int a=Joueur.getNbJoueurs();
		int i;
		Carte c;
		for(i=0;i<a;i++) {
			c=p.retirerCarteDuHaut();
			this.tas.add(c);
		}
		Iterator<Joueur> it=listeJoueur.iterator();
		while(it.hasNext()) {
			if(it.next().main.getOffre().get("carte gauche")!=null){
			this.tas.add(it.next().main.getOffre().get("carte gauche"));
			it.next().main.getOffre().remove("carte gauche");
			}
			else {
			this.tas.add(it.next().main.getOffre().get("carte droite"));
			it.next().main.getOffre().remove("carte droite");
			}
		}
		
		Collections.shuffle(this.tas);
	}
	
	public LinkedList<Carte> getTas(){
		return this.tas;
	}
	
	
	
	public static void main(String[] args) {
		Tas t= new Tas();
		t.tas.add(new Carte(Valeur.AS,Couleur.TRÊFLE));
		t.tas.add(new Carte(Valeur.AS,Couleur.COEUR));
		t.tas.add(new Carte(Valeur.AS,Couleur.CARREAU));
		t.tas.removeLast();
		Iterator<Carte> it=t.tas.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());		
			
		}
		
	}
}
