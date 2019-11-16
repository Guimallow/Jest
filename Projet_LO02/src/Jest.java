import java.util.*;

public class Jest implements ObjetVisite{
	private LinkedList<Carte> jest;
	private Joueur joueur; //Permet de faire le lien avec le joueur possÚdant le Jest

	public Jest(Joueur player) {
		this.jest = new LinkedList<Carte>();
		this.joueur = player;
	}
	public LinkedList<Carte> getJest(){
		return this.jest;
	}
	
	public void accept(Visiteur v){
		v.visit(this);
	}

	public void afficherJest() {// affiche le jest
		Iterator<Carte> it = this.jest.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
