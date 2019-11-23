import java.util.ArrayList;
public class Arbitre implements Visiteur {
	public void visit(Jest j){

	}
	public void visit(Trophee t){

	}
	
	public int compterPoints(Jest jest){ //Le jest est une LinkedList --> int size: nb �l�ments, object get(index): objet � l'index
		int point = 0;
		Carte currentCard;
		int currentCardValue;
		int nbPairs = 0;

		for (int i = 0; i < jest.jest.size(); i++){
			currentCard = jest.jest.get(i);
			currentCardValue = currentCard.valeur.ordinal() + 1; //+1 parce que "l'index" de l'�num qu'on r�cup�re avec ordinal() commence avec AS = 0 (c'est fix� par la d�finition d'une �num)
			
			if ((currentCardValue == 1) && (onlyCard(jest, currentCard) == true)){
				currentCardValue = 5;
			}
			
			if ((currentCard.couleur.ordinal() == 2) || (currentCard.couleur.ordinal() == 3)){
				point += currentCardValue;
				if (blackPair(jest, currentCard) == true){
					point += 2;
					nbPairs +=1;
				}
			}
			else if (currentCard.couleur.ordinal() == 1){
				point -= currentCardValue;
			}
			else if (currentCard.couleur.ordinal() == 0){
				if ((checkJoker(jest) == true) && countHeart(jest) == 4){
					point += currentCardValue;
				}
				else if ((checkJoker(jest) == true) && (countHeart(jest) < 4)){
					point -= currentCardValue;
				}
			}
			else if (currentCard.couleur.ordinal() == 4){
				if (countHeart(jest) == 0){
					point += 4;
				}
			}
		}
		point -= nbPairs /2;
		return point;
	}
	
	//Pas moyen de renvoyer une liste ordonn�e plut�t ?
	public ArrayList<Joueur> etablirClassement(ArrayList<Joueur> joueur){
		ArrayList<Joueur> classement;
		classement = new ArrayList<Joueur>();

		return classement;
	}
	
	public boolean checkJoker(Jest jest){
		boolean joker = false;
		for (int i = 0; i < jest.getJest().size(); i++){
			if (jest.getJest().get(i).valeur.ordinal() == 0){
				joker = true;
			}
		}
		return joker;
	}
	
	public int countHeart(Jest jest){
		int count = 0;
		for (int i = 0; i < jest.getJest().size(); i++){
			if (jest.getJest().get(i).couleur.ordinal() == 0){
				count ++;
			}
		}
		return count;
	}
	
	public boolean onlyCard(Jest jest, Carte carte){
		boolean onlyOne = true;
		int couleur = carte.getCouleur().ordinal();
		for (int i= 0; i < jest.getJest().size(); i++){
			if (jest.getJest().get(i).couleur.ordinal() == couleur){
				onlyOne = false;
			}
		}
		return onlyOne;
	}
	
	public boolean blackPair(Jest jest, Carte carte){
		boolean paire = false;
		int valeur1 = carte.getValeur().ordinal() + 1;
		int couleur1 = carte.getValeur().ordinal();
		for (int i = 0; i < jest.getJest().size(); i++){
			int couleur2 = jest.getJest().get(i).getCouleur().ordinal();
			int valeur2 = jest.getJest().get(i).getValeur().ordinal() + 1;
			if (((couleur2 == 2) || (couleur2 = 3)) && (couleur1 != couleur2) && (valeur1 = valeur2)){
				paire = true;
			}
		}
		return paire;
	}
	
	public void attribuerTrophee(ArrayList<Joueur> joueur, Trophee t1, Trophee t2){
		ConditionTrophee conditionT1;
		ConditionTrophee conditionT2;
		int nbJoueur = joueur.size();
		conditionT1 = t1.getCarte().condition;
		conditionT2 = t2.getCarte().condition;
		//On attribue les troph�es simultan�ment donc on va stocker le jest auquel on attribue le premier troph�e pour ne pas l'ajouter tout de suite au Jest et ainsi perturber l'attribution du second
		Jest jestTropheeT1 = null;
		Jest jestTropheeT2 = null;
		switch(conditionT1){
		case BestJest:
			for (int i=0; i<joueur.size(); i++){
				int points = 0;
				if (compterPoints(joueur.get(i).getJest()) > points){
					points = compterPoints(joueur.get(i).getJest());
					jestTropheeT1 = joueur.get(i).getJest();
				}
			System.out.println("Le trophee 1 a �t� attribu� � " + jestTropheeT1.getJoueur().getPseudo());
			}
			break;
		case BestJestNoJoke: 
			for (int i=0; i<joueur.size(); i++){
				int points = 0;
				if ((compterPoints(joueur.get(i).getJest()) > points) || checkJoker(joueur.get(i).getJest()) == false){
					points = compterPoints(joueur.get(i).getJest());
					jestTropheeT1 = joueur.get(i).getJest();
				}
			System.out.println("Le trophee 1 a �t� attribu� � " + jestTropheeT1.getJoueur().getPseudo());
			}
			break;
		case Highest: 
			break;
		case Lowest: 
			break;
		case Majority: 
			break;
		case Joker: 
			for (int i=0; i<joueur.size(); i++){
				if (checkJoker(joueur.get(i).getJest()) == true){
					jestTropheeT1 = joueur.get(i).getJest();
					System.out.println("Le trophee 1 a �t� attribu� � " + joueur.get(i).getPseudo());
					break;
				}
			}
			break;
		}
		
		switch(conditionT2){
		case BestJest:
			for (int i=0; i<joueur.size(); i++){
				int points = 0;
				if (compterPoints(joueur.get(i).getJest()) > points){
					points = compterPoints(joueur.get(i).getJest());
					jestTropheeT2 = joueur.get(i).getJest();
				}
			System.out.println("Le trophee 2 a �t� attribu� � " + jestTropheeT2.getJoueur().getPseudo());
			}
			break;
		case BestJestNoJoke: 
			for (int i=0; i<joueur.size(); i++){
				int points = 0;
				if ((compterPoints(joueur.get(i).getJest()) > points) || checkJoker(joueur.get(i).getJest()) == false){
					points = compterPoints(joueur.get(i).getJest());
					jestTropheeT2 = joueur.get(i).getJest();
				}
			System.out.println("Le trophee 2 a �t� attribu� � " + jestTropheeT2.getJoueur().getPseudo());
			}
			break;
		case Highest: 
			break;
		case Lowest: 
			break;
		case Majority: 
			break;
		case Joker: 
			for (int i=0; i<joueur.size(); i++){
				if (checkJoker(joueur.get(i).getJest()) == true){
					jestTropheeT2 = joueur.get(i).getJest();
					System.out.println("Le trophee 2 a �t� attribu� � " + joueur.get(i).getPseudo());
					break;
				}
			}
			break;
		}
		
	}
}
