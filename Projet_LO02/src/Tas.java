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
	public LinkedList<Carte> getTas(){
		return this.tas;
	}
	
	
	
	public static void main(String[] args) {
		Tas t= new Tas();
		t.tas.add(new Carte(Valeur.AS,Couleur.TRÊFLE));
		t.tas.add(new Carte(Valeur.AS,Couleur.COEUR));
		t.tas.add(new Carte(Valeur.AS,Couleur.CARREAU));
		t.tas.removeLast();
		Iterator<Carte> it=t.tas.iterator();//fonctionnement identique pour HashSet et LinkedList
		while(it.hasNext()) {
			System.out.println(it.next());		
			
		}
		
	}
}
