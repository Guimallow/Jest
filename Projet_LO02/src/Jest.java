import java.util.*;

public class Jest {
	private LinkedList<Carte> jest;

	public Jest() {
		this.jest = new LinkedList<Carte>();
	}

	public void afficherJest() {// affiche le jest
		Iterator<Carte> it = this.jest.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
