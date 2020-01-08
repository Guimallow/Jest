package modele;

import modele.cartes.Jest;
import modele.cartes.Trophee;

public interface Visiteur {
	void visit(Jest jest);
	void visit(Trophee trophee);
	
}
