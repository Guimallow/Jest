package modele;
/**
 * interface qui mod�lise un objet visit�
 */
public interface ObjetVisite {
	/**
	 * m�thode � impl�menter afin d'accepter la visite d'un visiteur
	 * @param visiteur le visiteur de l'objet
	 */
	void accept(Visiteur visiteur);
}