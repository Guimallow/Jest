import java.util.ArrayList;
public class Arbitre implements Visiteur {
	public void visit(Jest j){

	}
	public void visit(Trophee t){

	}
	
	public int compterPoints(Jest jest){ //Le jest est une LinkedList --> int size: nb �l�ments, object get(index): objet � l'index
		int point = 0;
		Carte currentCart;
		int currentCartValue;
		for (int i = 0; i < jest.jest.size(); i++){
			currentCart = jest.jest.get(i);
			currentCartValue = currentCart.valeur.ordinal() + 1; //+1 parce que "l'index" de l'�num qu'on r�cup�re avec ordinal() commence avec AS = 0 (c'est fix� par la d�finition d'une �num)
			point += currentCartValue;
		}
		return point;
	}
	
	//Pas moyen de renvoyer une liste ordonn�e plut�t ?
	public ArrayList<Joueur> etablirClassement(ArrayList<Joueur> joueur){
		ArrayList<Joueur> classement;
		classement = new ArrayList<Joueur>();

		return classement;
	}
	
	public void attribuerTrophee(ArrayList<Joueur> joueur, Trophee t1, Trophee t2){
		ConditionTrophee conditionT1;
		ConditionTrophee conditionT2;
		int nbJoueur = joueur.size();
		conditionT1 = t1.getCarte().condition;
		conditionT2 = t2.getCarte().condition;
		//On attribue les troph�es simultan�ment donc on va stocker le jest auquel on attribue le premier troph�e pour ne pas l'ajouter tout de suite au Jest et ainsi perturber l'attribution du second
		Jest jestTropheeT1 = null;
		switch(conditionT1){
		case BestJest:
			break;
		case BestJestNoJoke: 
			break;
		case Highest: 
			break;
		case Lowest: 
			break;
		case Majority: 
			break;
		case Joker: 
			break;
		}
		
		switch(conditionT2){
		case BestJest:
			break;
		case BestJestNoJoke: 
			break;
		case Highest: 
			break;
		case Lowest: 
			break;
		case Majority: 
			break;
		case Joker: 
			break;
		}
		
	}
}
