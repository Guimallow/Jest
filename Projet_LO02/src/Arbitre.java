
public class Arbitre implements Visiteur {
	public void visit(Jest j){

	}
	public void visit(Trophee t){

	}
	
	public int compterLesPoints(Jest jest){ //Le jest est une LinkedList --> int size: nb éléments, object get(index): objet à l'index
		int point = 0;
		Carte currentCart;
		int currentCartValue;
		for (int i = 0; i < jest.jest.size(); i++){
			currentCart = jest.jest.get(i);
			currentCartValue = currentCart.valeur.ordinal() + 1; //+1 parce que "l'index" de l'énum qu'on récupère avec ordinal() commence avec AS = 0 (c'est fixé par la définition d'une énum)
			point += currentCartValue;
		}
		return point;
	}
	
	//Pas moyen de renvoyer une liste ordonnée plutôt ?
	public String etablirClassement(int nbJoueurs){
		String classement;
		classement = "Cette méthode ne marche pas encore "; //Le temps de programmer la méthode
		return classement;
	}
	
	public void attribuerTrophee(Jest jest, Trophee t1, Trophee t2){
		
	}
}
