package modele;

import modele.cartes.Jest;
import modele.cartes.Trophee;
/**
 * interface qui mod�lise un visteur
 */
public interface Visiteur {
	/**
	 * m�thode � impl�menter afin de visiter un jest
	 * @param jest le jest � visiter
	 */
	void visit(Jest jest);
	/**
	 * m�thode � impl�menter afin de visiter un troph�e
	 * @param trophee le troph�e � visiter
	 */
	void visit(Trophee trophee);
	
}
