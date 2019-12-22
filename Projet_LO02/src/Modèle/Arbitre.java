package Modèle;
import java.util.*;

public class Arbitre implements Visiteur {
	
	public Arbitre(){
		
	}
	
	public void visit(Jest j){

	}
	public void visit(Trophee t){

	}
	
	public int compterPoints(Jest jest, Variante variante){
		int point = 0;
		Carte currentCard;
		int currentCardValue;
		int nbPairs = 0;

		for (int i = 0; i < jest.getCartes().size(); i++){
			currentCard = jest.getCartes().get(i);
			currentCardValue = currentCard.getValeur().ordinal() + 1; //+1 parce que "l'index" de l'énum qu'on récupère avec ordinal() commence avec AS = 0 (c'est fixé par la définition d'une énum)
			
			if ((currentCardValue == 1) && (onlyCard(jest, currentCard) == true)){
				currentCardValue = 5;
			}
			
			if ((currentCard.getCouleur().ordinal() == 2) || (currentCard.getCouleur().ordinal() == 3)){
				point += currentCardValue;
				if (blackPair(jest, currentCard) == true){
					point += 2;
					nbPairs ++;
				}
			}
			else if (currentCard.getCouleur().ordinal() == 1){
				point -= currentCardValue;
			}
			else if (currentCard.getCouleur().ordinal() == 0){
				if ((checkJoker(jest) == true) && countHeart(jest) == 4){
					point += currentCardValue;
				}
				else if ((checkJoker(jest) == true) && (countHeart(jest) < 4)){
					point -= currentCardValue;
				}
			}
			else if (currentCard.getCouleur().ordinal() == 4){
				if (countHeart(jest) == 0){
					point += 4;
				}
			}
		}
		point -= nbPairs;
		
		if (variante == Variante.COMPTAGE){
			if (allCardsValue(jest, Valeur.DEUX)){
				point = point *2;
			}
			if (allCardsValue(jest, Valeur.TROIS)){
				point = point * 3;
			}
		}
		
		return point;
	}
	
	/*//Soucis si deux joueurs ont le même nombre de points
	public LinkedList<Joueur> etablirClassement(ArrayList<Joueur> joueurs, Variante variante){ //add(int index, element e)
		LinkedList<Joueur> classement;
		int classementPoints[] = new int[joueurs.size()];
		classement = new LinkedList<Joueur>();
		
		//On va recopier joueurs dans classement pour ne pas avoir de soucis en ajoutant, par exemple, le premier joueur à la troisième place sans avoir préalablement rempli les deux premières
		
		for (int i = 0; i < joueurs.size(); i++){
			classement.add(joueurs.get(i));
		}
		
		for (int i = 0; i < joueurs.size(); i++){
			int pointsJoueur = compterPoints(joueurs.get(i).getJest(), variante);
			classementPoints[i] = pointsJoueur;
		}
		//On a maintenant deux listes, dont une qu'on peut trier avec des comparaisons simples
		//On peut essayer d'utiliser Arrays.sort()
		Arrays.sort(classementPoints);
		
		//Ensuite on associe chaque joueur à son nombre de points pour le placer dans le tableau classement
		for (int i = 0; i < joueurs.size(); i++){
			for (int j = 0; j < classementPoints.length; j++){
				if (compterPoints(joueurs.get(i).getJest(), variante) == classementPoints[j]){
					classement.remove(j);
					classement.add(j, joueurs.get(i));
				}
			}
		}
		
		return classement;
	}
	*/
	public boolean checkJoker(Jest jest){
		boolean joker = false;
		for (int i = 0; i < jest.getCartes().size(); i++){
			if (jest.getCartes().get(i).getValeur().ordinal() == 0){
				joker = true;
			}
		}
		return joker;
	}
	
	public int countHeart(Jest jest){
		int count = 0;
		for (int i = 0; i < jest.getCartes().size(); i++){
			if (jest.getCartes().get(i).getCouleur().ordinal() == 0){
				count ++;
			}
		}
		return count;
	}
	
	public boolean onlyCard(Jest jest, Carte carte){
		boolean onlyOne = true;
		int couleur = carte.getCouleur().ordinal();
		for (int i= 0; i < jest.getCartes().size(); i++){
			if (jest.getCartes().get(i).getCouleur().ordinal() == couleur){
				onlyOne = false;
			}
		}
		return onlyOne;
	}
	
	public boolean blackPair(Jest jest, Carte carte){
		boolean paire = false;
		int valeur1 = carte.getValeur().ordinal() + 1;
		int couleur1 = carte.getValeur().ordinal();
		for (int i = 0; i < jest.getCartes().size(); i++){
			int couleur2 = jest.getCartes().get(i).getCouleur().ordinal();
			int valeur2 = jest.getCartes().get(i).getValeur().ordinal() + 1;
			if (((couleur2 == 2) || (couleur2 == 3)) && (couleur1 != couleur2) && (valeur1 == valeur2)){
				paire = true;
			}
		}
		return paire;
	}
	
	public int countMajority(Jest jest, Valeur valeur){
		int count = 0;
		for (int i = 0; i < jest.getCartes().size(); i++){
			if (jest.getCartes().get(i).getValeur().ordinal() == valeur.ordinal()){
				count ++;
			}
		}
		return count;
	}
	
	//Il reste à faire la gestion des égalités
	public void attribuerTrophee(ArrayList<Joueur> joueur, Trophee t1, Trophee t2, Variante variante){
		ConditionTrophee conditionT1 = null;
		ConditionTrophee conditionT2 = null;
		conditionT1 = t1.getCondition();
		if (t2 !=  null){
			conditionT2 = t2.getCondition();
		}
		//On attribue les trophées simultanément donc on va stocker le jest auquel on attribue le premier trophée pour ne pas l'ajouter tout de suite au Jest et ainsi perturber l'attribution du second
		Jest jestTropheeT1 = null;
		Jest jestTropheeT2 = null;
		switch(conditionT1){
			case BestJest:
			for (int i=0; i<joueur.size(); i++){
				int points = 0;
				if (compterPoints(joueur.get(i).getJest(), variante) > points){
					points = compterPoints(joueur.get(i).getJest(), variante);
					jestTropheeT1 = joueur.get(i).getJest();
				}

			}
			break;
		case BestJestNoJoke: 
			for (int i=0; i<joueur.size(); i++){
				int points = 0;
				if ((compterPoints(joueur.get(i).getJest(), variante) > points) || checkJoker(joueur.get(i).getJest()) == false){
					points = compterPoints(joueur.get(i).getJest(), variante);
					jestTropheeT1 = joueur.get(i).getJest();
				}
			}
			break;
		case Highest: 
			int highestValue = 0;
			for (int i = 0; i < joueur.size(); i++){
				for (int j = 0; j < joueur.get(i).getJest().getCartes().size(); j++){
					if ((joueur.get(i).getJest().getCartes().get(j).getValeur().ordinal() + 1 > highestValue) 
							&& (joueur.get(i).getJest().getCartes().get(j).getCouleur().ordinal()==t1.getCouleurCondition().ordinal())){
						highestValue = joueur.get(i).getJest().getCartes().get(j).getValeur().ordinal() + 1;
						jestTropheeT1 = joueur.get(i).getJest();
					}
				}
			}
			break;
		case Lowest:
			int lowestValue = 6;
			for (int i = 0; i < joueur.size(); i++){
				for (int j = 0; j < joueur.get(i).getJest().getCartes().size(); j++){
					if ((joueur.get(i).getJest().getCartes().get(j).getValeur().ordinal() + 1 < lowestValue) 
							&& (joueur.get(i).getJest().getCartes().get(j).getCouleur().ordinal()==t1.getCouleurCondition().ordinal())){
						lowestValue = joueur.get(i).getJest().getCartes().get(j).getValeur().ordinal() + 1;
						jestTropheeT1 = joueur.get(i).getJest();
					}
				}
			}
			break;
		case Majority: 
			int compte = 0;
			for (int i = 0; i <joueur.size(); i++){
				if (countMajority(joueur.get(i).getJest(), t1.getValeurCondition()) > compte){
					jestTropheeT1 = joueur.get(i).getJest();
					compte = countMajority(joueur.get(i).getJest(), t1.getValeurCondition());
				}
			}
			break;
		case Joker: 
			for (int i=0; i<joueur.size(); i++){
				if (checkJoker(joueur.get(i).getJest()) == true){
					jestTropheeT1 = joueur.get(i).getJest();
					break;
				}
			}
			break;
			default: break;
		}
		
		System.out.println("Le trophee 1 a été attribué à " + jestTropheeT1.getJoueur().getPseudo());

		if (t2 != null && t2.getCondition() != null){
			
			switch(conditionT2){
			case BestJest:
				for (int i=0; i<joueur.size(); i++){
					int points = 0;
					if (compterPoints(joueur.get(i).getJest(), variante) > points){
						points = compterPoints(joueur.get(i).getJest(), variante);
						jestTropheeT2 = joueur.get(i).getJest();
					}

				}
				break;
			case BestJestNoJoke: 
				for (int i=0; i<joueur.size(); i++){
					int points = 0;
					if ((compterPoints(joueur.get(i).getJest(), variante) > points) || checkJoker(joueur.get(i).getJest()) == false){
						points = compterPoints(joueur.get(i).getJest(), variante);
						jestTropheeT2 = joueur.get(i).getJest();
					}
				
				}
				break;
			case Highest: 
				int highestValue = 0;
				for (int i = 0; i < joueur.size(); i++){
					for (int j = 0; j < joueur.get(i).getJest().getCartes().size(); j++){
						if ((joueur.get(i).getJest().getCartes().get(j).getValeur().ordinal() + 1 > highestValue) 
								&& (joueur.get(i).getJest().getCartes().get(j).getCouleur().ordinal()==t2.getCouleurCondition().ordinal())){
							highestValue = joueur.get(i).getJest().getCartes().get(j).getValeur().ordinal() + 1;
							jestTropheeT2 = joueur.get(i).getJest();
						}
					}
				}
				break;
			case Lowest: 
				int lowestValue = 6;
				for (int i = 0; i < joueur.size(); i++){
					for (int j = 0; j < joueur.get(i).getJest().getCartes().size(); j++){
						if ((joueur.get(i).getJest().getCartes().get(j).getValeur().ordinal() + 1 < lowestValue) 
								&& (joueur.get(i).getJest().getCartes().get(j).getCouleur().ordinal()==t2.getCouleurCondition().ordinal())){
							lowestValue = joueur.get(i).getJest().getCartes().get(j).getValeur().ordinal() + 1;
							jestTropheeT2 = joueur.get(i).getJest();
						}
					}
				}
				break;
			case Majority: 
				int compte = 0;
				for (int i = 0; i <joueur.size(); i++){
					if (countMajority(joueur.get(i).getJest(), t1.getValeurCondition()) > compte){
						jestTropheeT2 = joueur.get(i).getJest();
						compte = countMajority(joueur.get(i).getJest(), t1.getValeurCondition());
					}
				}
				break;
			case Joker: 
				for (int i=0; i<joueur.size(); i++){
					if (checkJoker(joueur.get(i).getJest()) == true){
						jestTropheeT2 = joueur.get(i).getJest();
						System.out.println("Le trophee 2 a été attribué à " + joueur.get(i).getPseudo());
						break;
					}
				}
				break;
			default : System.out.println("Erreur trophée 2");
				break;
			}
			System.out.println("Le trophee 2 a été attribué à " + jestTropheeT2.getJoueur().getPseudo());
			
		}
		
	}
	
	public ArrayList<Joueur> etablirClassement2(Partie partie){
		ArrayList<Joueur> classement = new ArrayList<Joueur>();
		for (Joueur joueur : partie.getJoueurs()){
			joueur.setScore(this.compterPoints(joueur.getJest(), partie.getVariante()));
			classement.add(joueur);
		}
		Collections.sort(classement, new ComparaisonScore());
		return classement;
		
	}
	public boolean verification(int index, int[] tableau){
		boolean utilise = false;
		for (int i = 0; i < tableau.length; i++){
			if (tableau[i] == index){
				utilise = true;
			}
		}
		return utilise;
	}

	public void echangeJest(Partie partie){ //Le joueur 1 a le paquet du joueur 2, etc.
		ArrayList<Carte> jestStocke = partie.getJoueurs().get(0).getJest().getCartes();
		for (int i = 0; i < partie.getJoueurs().size(); i++){
			partie.getJoueurs().get(i).getJest().setCartes(partie.getJoueurs().get(i+1).getJest().getCartes());
		}
		partie.getJoueurs().get(partie.getJoueurs().size()-1).getJest().setCartes(jestStocke);
	}
	
	public boolean allCardsValue(Jest jest, Valeur valeur){
		int count = 0;
		boolean all = false;
		for (int i = 0; i < jest.getCartes().size(); i++){
			if (jest.getCartes().get(i).getValeur() == valeur){
				count ++;
			}
		}
		if (count == 4){ all = true;}
		return all;
	}

}
