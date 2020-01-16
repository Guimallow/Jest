package modele;

import modele.cartes.Jest;
import modele.cartes.Trophee;
/**
 * interface qui modélise un visteur
 */
public interface Visiteur {
	/**
	 * méthode à implémenter afin de visiter un jest
	 * @param jest le jest à visiter
	 */
	void visit(Jest jest);
	/**
	 * méthode à implémenter afin de visiter un trophée
	 * @param trophee le trophée à visiter
	 */
	void visit(Trophee trophee);
	
}
