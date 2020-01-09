package modele;
import java.util.*;

import controleur.Partie;
import modele.cartes.Carte;
import modele.cartes.Couleur;
import modele.cartes.Jest;
import modele.cartes.Trophee;
import modele.cartes.Valeur;
import modele.joueurs.Joueur;
import java.util.Random;

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
		int nbPaires = 0;

		for (int i = 0; i < jest.getCartes().size(); i++){
			currentCard = jest.getCartes().get(i);
			currentCardValue = currentCard.getValeur().ordinal();
			
			if ((currentCardValue == 1) && (onlyCard(jest, currentCard) == true)){
				currentCardValue = 5;
			}
			
			if ((currentCard.getCouleur() == Couleur.PIC) || (currentCard.getCouleur() == Couleur.TR�FLE)){
				point += currentCardValue;
				if (blackPair(jest, currentCard) == true){
					point += 2;
					nbPaires ++;
				}
			}
			else if (currentCard.getCouleur() == Couleur.CARREAU){
				point -= currentCardValue;
			}
			else if (currentCard.getCouleur() == Couleur.COEUR){
				if ((checkJoker(jest) == true) && countHeart(jest) == 4){
					point += currentCardValue;
				}
				else if ((checkJoker(jest) == true) && (countHeart(jest) < 4)){
					point -= currentCardValue;
				}
			}
			else if (currentCard.getCouleur() == Couleur.JOKER){
				if (countHeart(jest) == 0){
					point += 4;
				}
			}
		}
		point -= nbPaires; //Parce qu'on a th�oriquement compt� chaque paire deux fois en ajoutant donc 2 points en plus par nombre de paires
		
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
	
	public boolean checkJoker(Jest jest){
		boolean joker = false;
		for (int i = 0; i < jest.getCartes().size(); i++){
			if (jest.getCartes().get(i).getValeur() == Valeur.JOKER){
				joker = true;
			}
		}
		return joker;
	}
	
	public int countHeart(Jest jest){
		int count = 0;
		for (int i = 0; i < jest.getCartes().size(); i++){
			if (jest.getCartes().get(i).getCouleur() == Couleur.COEUR){
				count ++;
			}
		}
		return count;
	}
	
	public boolean onlyCard(Jest jest, Carte carte){
		boolean onlyOne = true;
		Couleur couleur = carte.getCouleur();
		for (int i= 0; i < jest.getCartes().size(); i++){
			if (jest.getCartes().get(i).getCouleur() == couleur){
				onlyOne = false;
			}
		}
		return onlyOne;
	}
	
	public boolean blackPair(Jest jest, Carte carte){
		boolean paire = false;
		Valeur valeur1 = carte.getValeur();
		Couleur couleur1 = carte.getCouleur();
		for (int i = 0; i < jest.getCartes().size(); i++){
			Couleur couleur2 = jest.getCartes().get(i).getCouleur();
			Valeur valeur2 = jest.getCartes().get(i).getValeur();
			if (((couleur2 == Couleur.PIC) || (couleur2 == Couleur.TR�FLE)) && (couleur1 != couleur2) && (valeur1 == valeur2)){
				paire = true;
			}
		}
		return paire;
	}
	
	public int countMajority(Jest jest, Valeur valeur){
		int count = 0;
		for (int i = 0; i < jest.getCartes().size(); i++){
			if (jest.getCartes().get(i).getValeur() == valeur){
				count ++;
			}
		}
		return count;
	}
	
	//Il reste � faire la gestion des �galit�s
	public void attribuerTrophee(ArrayList<Joueur> joueurs, Trophee t1, Trophee t2, Variante variante){
		ConditionTrophee conditionT1 = null;
		ConditionTrophee conditionT2 = null;
		conditionT1 = t1.getCondition();
		if (t2 !=  null){
			conditionT2 = t2.getCondition();
		}
		//On attribue les troph�es simultan�ment donc on va stocker le jest auquel on attribue le premier troph�e pour ne pas l'ajouter tout de suite au Jest et ainsi perturber l'attribution du second
		Jest jestTropheeT1 = null;
		Jest jestTropheeT2 = null;
		switch(conditionT1){
			case BestJest:
			int points = compterPoints(joueurs.get(0).getJest(), variante);
			jestTropheeT1 = joueurs.get(0).getJest();
			for (int i=0; i<joueurs.size(); i++){
				if (compterPoints(joueurs.get(i).getJest(), variante) > points){
					points = compterPoints(joueurs.get(i).getJest(), variante);
					jestTropheeT1 = joueurs.get(i).getJest();
				}

			}
			break;
		case BestJestNoJoke: 
			int point = 0;
			jestTropheeT1 = joueurs.get(0).getJest();
			for (int i=0; i<joueurs.size(); i++){
				if ((compterPoints(joueurs.get(i).getJest(), variante) > point) || checkJoker(joueurs.get(i).getJest()) == false){
					point = compterPoints(joueurs.get(i).getJest(), variante);
					jestTropheeT1 = joueurs.get(i).getJest();
				}
			}
			break;
		case Highest: 
			int highestValue = 0;
			for (int i = 0; i < joueurs.size(); i++){
				for (int j = 0; j < joueurs.get(i).getJest().getCartes().size(); j++){
					if ((joueurs.get(i).getJest().getCartes().get(j).getValeur().ordinal() > highestValue) 
							&& (joueurs.get(i).getJest().getCartes().get(j).getCouleur().ordinal()==t1.getCouleurCondition().ordinal())){
						highestValue = joueurs.get(i).getJest().getCartes().get(j).getValeur().ordinal();
						jestTropheeT1 = joueurs.get(i).getJest();
					}
				}
			}
			break;
		case Lowest:
			int lowestValue = 6;
			for (int i = 0; i < joueurs.size(); i++){
				for (int j = 0; j < joueurs.get(i).getJest().getCartes().size(); j++){
					if ((joueurs.get(i).getJest().getCartes().get(j).getValeur().ordinal() < lowestValue) 
							&& (joueurs.get(i).getJest().getCartes().get(j).getCouleur().ordinal()==t1.getCouleurCondition().ordinal())){
						lowestValue = joueurs.get(i).getJest().getCartes().get(j).getValeur().ordinal();
						jestTropheeT1 = joueurs.get(i).getJest();
					}
				}
			}
			break;
		case Majority: 
			int compte = 0;
			for (int i = 0; i <joueurs.size(); i++){
				if (countMajority(joueurs.get(i).getJest(), t1.getValeurCondition()) > compte){
					jestTropheeT1 = joueurs.get(i).getJest();
					compte = countMajority(joueurs.get(i).getJest(), t1.getValeurCondition());
				}
			}
			break;
		case Joker: 
			for (int i=0; i<joueurs.size(); i++){
				if (checkJoker(joueurs.get(i).getJest()) == true){
					jestTropheeT1 = joueurs.get(i).getJest();
					break;
				}
			}
			break;
		case Random:
			Random rand = new Random();
			// Obtain a number between [0 - joueurs.size()-1]
			int n = rand.nextInt(joueurs.size());
			jestTropheeT1 = joueurs.get(n).getJest();
			break;
			default: System.out.println("Erreur troph�e 2");
				break;
		}
		
		System.out.println("Le trophee 1 a �t� attribu� � " + jestTropheeT1.getJoueur().getPseudo());
		

		if (t2 != null && t2.getCondition() != null){
			
			switch(conditionT2){
			case BestJest:
				int points = compterPoints(joueurs.get(0).getJest(), variante);
				jestTropheeT2 = joueurs.get(0).getJest();
				for (int i=0; i<joueurs.size(); i++){
					if (compterPoints(joueurs.get(i).getJest(), variante) > points){
						points = compterPoints(joueurs.get(i).getJest(), variante);
						jestTropheeT2 = joueurs.get(i).getJest();
					}

				}
				break;
			case BestJestNoJoke: 
				int point = compterPoints(joueurs.get(0).getJest(), variante);
				jestTropheeT2 = joueurs.get(0).getJest();
				for (int i=0; i<joueurs.size(); i++){
					if ((compterPoints(joueurs.get(i).getJest(), variante) > point) || checkJoker(joueurs.get(i).getJest()) == false){
						point = compterPoints(joueurs.get(i).getJest(), variante);
						jestTropheeT2 = joueurs.get(i).getJest();
					}
				}
				break;
			case Highest: 
				int highestValue = 0;
				for (int i = 0; i < joueurs.size(); i++){
					for (int j = 0; j < joueurs.get(i).getJest().getCartes().size(); j++){
						if ((joueurs.get(i).getJest().getCartes().get(j).getValeur().ordinal() > highestValue) 
								&& (joueurs.get(i).getJest().getCartes().get(j).getCouleur().ordinal()==t2.getCouleurCondition().ordinal())){
							highestValue = joueurs.get(i).getJest().getCartes().get(j).getValeur().ordinal();
							jestTropheeT2 = joueurs.get(i).getJest();
						}
					}
				}
				break;
			case Lowest: 
				int lowestValue = 6;
				for (int i = 0; i < joueurs.size(); i++){
					for (int j = 0; j < joueurs.get(i).getJest().getCartes().size(); j++){
						if ((joueurs.get(i).getJest().getCartes().get(j).getValeur().ordinal() < lowestValue) 
								&& (joueurs.get(i).getJest().getCartes().get(j).getCouleur().ordinal()==t2.getCouleurCondition().ordinal())){
							lowestValue = joueurs.get(i).getJest().getCartes().get(j).getValeur().ordinal();
							jestTropheeT2 = joueurs.get(i).getJest();
						}
					}
				}
				break;
			case Majority: 
				int compte = countMajority(joueurs.get(0).getJest(), t2.getValeurCondition());
				jestTropheeT2 = joueurs.get(0).getJest();
				for (int i = 0; i <joueurs.size(); i++){
					if (countMajority(joueurs.get(i).getJest(), t2.getValeurCondition()) > compte){
						jestTropheeT2 = joueurs.get(i).getJest();
						compte = countMajority(joueurs.get(i).getJest(), t2.getValeurCondition());
					}
				}
				break;
			case Joker: 
				for (int i=0; i<joueurs.size(); i++){
					if (checkJoker(joueurs.get(i).getJest()) == true){
						jestTropheeT2 = joueurs.get(i).getJest();
						break;
					}
				}
				break;
			case Random:
				Random rand = new Random();
				// Obtain a number between [0 - joueurs.size()-1]
				int n = rand.nextInt(joueurs.size());
				jestTropheeT2 = joueurs.get(n).getJest();
				break;
			default : System.out.println("Erreur troph�e 2");
				break;
			}
			if (jestTropheeT2.getJoueur().getPseudo() != null){
				System.out.println("Le trophee 2 a �t� attribu� � " + jestTropheeT2.getJoueur().getPseudo());
				jestTropheeT2.getCartes().add(t2.getCarte());	
			}
			else if (jestTropheeT2.getJoueur().getPseudo() == null && jestTropheeT2.getJoueur() != null){
				jestTropheeT2.getCartes().add(t2.getCarte());
			}
			
		}
		jestTropheeT1.getCartes().add(t1.getCarte());
		
	}
	
	public ArrayList<Joueur> etablirClassement(Partie partie){
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
		for (int i = 0; i < partie.getJoueurs().size()-1; i++){
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
