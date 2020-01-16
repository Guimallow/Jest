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

/**
 * Classe repr�sentant l'arbitre de la partie qui va compter les points,
 * attribuer les troph�es et �tablir le classement
 */
public class Arbitre implements Visiteur {
	/**
	 * le constructeur de la classe
	 */
	public Arbitre() {

	}

	/**
	 * m�thode permettant de visiter un jest
	 * 
	 * @param j le jest � visiter
	 */
	public void visit(Jest j) {

	}

	/**
	 * m�thode permettant de visiter un troph�e
	 * 
	 * @param t le troph�e � visiter
	 */
	public void visit(Trophee t) {

	}

	/**
	 * m�thode permettant de compter les points d'un jest en fonction de la variante
	 * en jeu
	 * 
	 * @param jest     le jest dont il faut compter les points
	 * @param variante la variante utilis�e lors de la partie
	 * @return le nombre de points du jest
	 */
	public int compterPoints(Jest jest, Variante variante) {
		int point = 0;
		Carte currentCard;
		int currentCardValue;
		int nbPaires = 0;

		for (int i = 0; i < jest.getCartes().size(); i++) {
			currentCard = jest.getCartes().get(i);
			currentCardValue = currentCard.getValeur().ordinal();

			if ((currentCardValue == 1) && (onlyCard(jest, currentCard) == true)) {
				currentCardValue = 5;
			}

			if ((currentCard.getCouleur() == Couleur.PIC) || (currentCard.getCouleur() == Couleur.TR�FLE)) {
				point += currentCardValue;
				if (blackPair(jest, currentCard) == true) {
					point += 2;
					nbPaires++;
				}
			} else if (currentCard.getCouleur() == Couleur.CARREAU) {
				point -= currentCardValue;
			} else if (currentCard.getCouleur() == Couleur.COEUR) {
				if ((checkJoker(jest) == true) && countHeart(jest) == 4) {
					point += currentCardValue;
				} else if ((checkJoker(jest) == true) && (countHeart(jest) < 4)) {
					point -= currentCardValue;
				}
			} else if (currentCard.getCouleur() == Couleur.JOKER) {
				if (countHeart(jest) == 0) {
					point += 4;
				}
			}
		}
		point -= nbPaires;

		if (variante == Variante.COMPTAGE) {
			if (allCardsValue(jest, Valeur.DEUX)) {
				point = point * 2;
			}
			if (allCardsValue(jest, Valeur.TROIS)) {
				point = point * 3;
			}
		}

		return point;
	}

	/**
	 * m�thode qui v�rifie si le joker est pr�sent dans le jest
	 * 
	 * @param jest le jest visit�
	 * @return le bool�en qui d�finit si le joker est pr�sent
	 */
	public boolean checkJoker(Jest jest) {
		boolean joker = false;
		for (int i = 0; i < jest.getCartes().size(); i++) {
			if (jest.getCartes().get(i).getValeur() == Valeur.JOKER) {
				joker = true;
			}
		}
		return joker;
	}

	/**
	 * m�thode qui compte le nombre de coeurs dans le jest
	 * 
	 * @param jest le jest visit�
	 * @return le nombre de coeurs pr�sents dans le jest
	 */
	public int countHeart(Jest jest) {
		int count = 0;
		for (int i = 0; i < jest.getCartes().size(); i++) {
			if (jest.getCartes().get(i).getCouleur() == Couleur.COEUR) {
				count++;
			}
		}
		return count;
	}

	/**
	 * m�thode qui v�rifie si la carte est la seule de cette couleur dans le jest
	 * 
	 * @param jest  le jest visit�
	 * @param carte la carte dont on v�rifie la couleur
	 * @return un bool�en qui d�finit si la carte est la seule de cette couleur dans
	 *         le jest
	 */
	public boolean onlyCard(Jest jest, Carte carte) {
		boolean onlyOne = true;
		Couleur couleur = carte.getCouleur();
		for (int i = 0; i < jest.getCartes().size(); i++) {
			if (jest.getCartes().get(i).getCouleur() == couleur) {
				onlyOne = false;
			}
		}
		return onlyOne;
	}

	/**
	 * m�thode qui v�rifie si il y a deux cartes de la m�me valeur avec comme
	 * couleur tr�fle et pic
	 * 
	 * @param jest  le jest visit�
	 * @param carte la carte compar�
	 * @return le bool�en qui d�finit si il y a une paire de tr�fle et pic
	 */
	public boolean blackPair(Jest jest, Carte carte) {
		boolean paire = false;
		Valeur valeur1 = carte.getValeur();
		Couleur couleur1 = carte.getCouleur();
		for (int i = 0; i < jest.getCartes().size(); i++) {
			Couleur couleur2 = jest.getCartes().get(i).getCouleur();
			Valeur valeur2 = jest.getCartes().get(i).getValeur();
			if (((couleur2 == Couleur.PIC) || (couleur2 == Couleur.TR�FLE)) && (couleur1 != couleur2)
					&& (valeur1 == valeur2)) {
				paire = true;
			}
		}
		return paire;
	}

	/**
	 * m�thode qui v�rifie combien de cartes dans le jest ont la m�me valeur que
	 * celle choisie
	 * 
	 * @param jest   le jest visit�
	 * @param valeur la valeur choisie
	 * @return le nombre de carte ayant cette valeur
	 */
	public int countMajority(Jest jest, Valeur valeur) {
		int count = 0;
		for (int i = 0; i < jest.getCartes().size(); i++) {
			if (jest.getCartes().get(i).getValeur() == valeur) {
				count++;
			}
		}
		return count;
	}

	/**
	 * m�thode qui attribue le ou les troph�es aux joueurs qui remplissent les
	 * conditions d'obtention
	 * 
	 * @param joueurs  la liste des joueurs de la partie
	 * @param t1       le premier troph�e
	 * @param t2       le deuxi�me troph�e
	 * @param variante la variante choisie dans la partie
	 */
	public void attribuerTrophee(ArrayList<Joueur> joueurs, Trophee t1, Trophee t2, Variante variante) {
		ConditionTrophee conditionT1 = null;
		ConditionTrophee conditionT2 = null;
		conditionT1 = t1.getCondition();
		if (t2 != null) {
			conditionT2 = t2.getCondition();
		}

		Jest jestTropheeT1 = null;
		Jest jestTropheeT2 = null;
		switch (conditionT1) {
		case BestJest:
			int points = compterPoints(joueurs.get(0).getJest(), variante);
			jestTropheeT1 = joueurs.get(0).getJest();
			for (int i = 0; i < joueurs.size(); i++) {
				if (compterPoints(joueurs.get(i).getJest(), variante) > points) {
					points = compterPoints(joueurs.get(i).getJest(), variante);
					jestTropheeT1 = joueurs.get(i).getJest();
				}

			}
			break;
		case BestJestNoJoke:
			int point = 0;
			jestTropheeT1 = joueurs.get(0).getJest();
			for (int i = 0; i < joueurs.size(); i++) {
				if ((compterPoints(joueurs.get(i).getJest(), variante) > point)
						|| checkJoker(joueurs.get(i).getJest()) == false) {
					point = compterPoints(joueurs.get(i).getJest(), variante);
					jestTropheeT1 = joueurs.get(i).getJest();
				}
			}
			break;
		case Highest:
			int highestValue = 0;
			for (int i = 0; i < joueurs.size(); i++) {
				for (int j = 0; j < joueurs.get(i).getJest().getCartes().size(); j++) {
					if ((joueurs.get(i).getJest().getCartes().get(j).getValeur().ordinal() > highestValue)
							&& (joueurs.get(i).getJest().getCartes().get(j).getCouleur().ordinal() == t1
									.getCouleurCondition().ordinal())) {
						highestValue = joueurs.get(i).getJest().getCartes().get(j).getValeur().ordinal();
						jestTropheeT1 = joueurs.get(i).getJest();
					}
				}
			}
			break;
		case Lowest:
			int lowestValue = 6;
			for (int i = 0; i < joueurs.size(); i++) {
				for (int j = 0; j < joueurs.get(i).getJest().getCartes().size(); j++) {
					if ((joueurs.get(i).getJest().getCartes().get(j).getValeur().ordinal() < lowestValue)
							&& (joueurs.get(i).getJest().getCartes().get(j).getCouleur().ordinal() == t1
									.getCouleurCondition().ordinal())) {
						lowestValue = joueurs.get(i).getJest().getCartes().get(j).getValeur().ordinal();
						jestTropheeT1 = joueurs.get(i).getJest();
					}
				}
			}
			break;
		case Majority:
			int compte = 0;
			for (int i = 0; i < joueurs.size(); i++) {
				if (countMajority(joueurs.get(i).getJest(), t1.getValeurCondition()) > compte) {
					jestTropheeT1 = joueurs.get(i).getJest();
					compte = countMajority(joueurs.get(i).getJest(), t1.getValeurCondition());
				}
			}
			break;
		case Joker:
			for (int i = 0; i < joueurs.size(); i++) {
				if (checkJoker(joueurs.get(i).getJest()) == true) {
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
		default:
			System.out.println("Erreur troph�e 2");
			break;
		}

		System.out.println("Le trophee 1 a �t� attribu� � " + jestTropheeT1.getJoueur().getPseudo());

		if (t2 != null && t2.getCondition() != null) {

			switch (conditionT2) {
			case BestJest:
				int points = compterPoints(joueurs.get(0).getJest(), variante);
				jestTropheeT2 = joueurs.get(0).getJest();
				for (int i = 0; i < joueurs.size(); i++) {
					if (compterPoints(joueurs.get(i).getJest(), variante) > points) {
						points = compterPoints(joueurs.get(i).getJest(), variante);
						jestTropheeT2 = joueurs.get(i).getJest();
					}

				}
				break;
			case BestJestNoJoke:
				int point = compterPoints(joueurs.get(0).getJest(), variante);
				jestTropheeT2 = joueurs.get(0).getJest();
				for (int i = 0; i < joueurs.size(); i++) {
					if ((compterPoints(joueurs.get(i).getJest(), variante) > point)
							|| checkJoker(joueurs.get(i).getJest()) == false) {
						point = compterPoints(joueurs.get(i).getJest(), variante);
						jestTropheeT2 = joueurs.get(i).getJest();
					}
				}
				break;
			case Highest:
				int highestValue = 0;
				for (int i = 0; i < joueurs.size(); i++) {
					for (int j = 0; j < joueurs.get(i).getJest().getCartes().size(); j++) {
						if ((joueurs.get(i).getJest().getCartes().get(j).getValeur().ordinal() > highestValue)
								&& (joueurs.get(i).getJest().getCartes().get(j).getCouleur().ordinal() == t2
										.getCouleurCondition().ordinal())) {
							highestValue = joueurs.get(i).getJest().getCartes().get(j).getValeur().ordinal();
							jestTropheeT2 = joueurs.get(i).getJest();
						}
					}
				}
				break;
			case Lowest:
				int lowestValue = 6;
				for (int i = 0; i < joueurs.size(); i++) {
					for (int j = 0; j < joueurs.get(i).getJest().getCartes().size(); j++) {
						if ((joueurs.get(i).getJest().getCartes().get(j).getValeur().ordinal() < lowestValue)
								&& (joueurs.get(i).getJest().getCartes().get(j).getCouleur().ordinal() == t2
										.getCouleurCondition().ordinal())) {
							lowestValue = joueurs.get(i).getJest().getCartes().get(j).getValeur().ordinal();
							jestTropheeT2 = joueurs.get(i).getJest();
						}
					}
				}
				break;
			case Majority:
				int compte = countMajority(joueurs.get(0).getJest(), t2.getValeurCondition());
				jestTropheeT2 = joueurs.get(0).getJest();
				for (int i = 0; i < joueurs.size(); i++) {
					if (countMajority(joueurs.get(i).getJest(), t2.getValeurCondition()) > compte) {
						jestTropheeT2 = joueurs.get(i).getJest();
						compte = countMajority(joueurs.get(i).getJest(), t2.getValeurCondition());
					}
				}
				break;
			case Joker:
				for (int i = 0; i < joueurs.size(); i++) {
					if (checkJoker(joueurs.get(i).getJest()) == true) {
						jestTropheeT2 = joueurs.get(i).getJest();
						break;
					}
				}
				break;
			case Random:
				Random rand = new Random();

				int n = rand.nextInt(joueurs.size());
				jestTropheeT2 = joueurs.get(n).getJest();
				break;
			default:
				System.out.println("Erreur troph�e 2");
				break;
			}
			if (jestTropheeT2.getJoueur().getPseudo() != null) {
				System.out.println("Le trophee 2 a �t� attribu� � " + jestTropheeT2.getJoueur().getPseudo());
				jestTropheeT2.getCartes().add(t2.getCarte());
			} else if (jestTropheeT2.getJoueur().getPseudo() == null && jestTropheeT2.getJoueur() != null) {
				jestTropheeT2.getCartes().add(t2.getCarte());
			}

		}
		jestTropheeT1.getCartes().add(t1.getCarte());

	}
	/**
	 * m�thode qui �tablit le classement en fonction du score des joueurs
	 * @param partie la partie en cours
	 * @return la liste des joueurs �tablit par le classement
	 */
	public ArrayList<Joueur> etablirClassement(Partie partie) {
		ArrayList<Joueur> classement = new ArrayList<Joueur>();
		for (Joueur joueur : partie.getJoueurs()) {
			joueur.setScore(this.compterPoints(joueur.getJest(), partie.getVariante()));
			classement.add(joueur);
		}
		Collections.sort(classement, new ComparaisonScore());
		return classement;

	}
	/**
	 * m�thode qui v�rifie qu'une case d'un tableau est utilis�e
	 * @param index la case � v�rifier
	 * @param tableau le tableau test�
	 * @return le bool�en qui d�finit si la case est utilis�e
	 */
	public boolean verification(int index, int[] tableau) {
		boolean utilise = false;
		for (int i = 0; i < tableau.length; i++) {
			if (tableau[i] == index) {
				utilise = true;
			}
		}
		return utilise;
	}
	/**
	 * m�thode qui �change les jests des joueurs de la partie (une des variantes)
	 * @param partie la partie en cours
	 */
	public void echangeJest(Partie partie) { 
		ArrayList<Carte> jestStocke = partie.getJoueurs().get(0).getJest().getCartes();
		for (int i = 0; i < partie.getJoueurs().size() - 1; i++) {
			partie.getJoueurs().get(i).getJest().setCartes(partie.getJoueurs().get(i + 1).getJest().getCartes());
		}
		partie.getJoueurs().get(partie.getJoueurs().size() - 1).getJest().setCartes(jestStocke);
	}
	/**
	 * m�thode qui v�rifie que le jest contient toutes les cartes d'une m�me valeur (une des variantes)
	 * @param jest le jest visit�
	 * @param valeur la valeur test�e
	 * @return le bool�en qui d�finit si le jest contient toutes les cartes avec cette valeur
	 */
	public boolean allCardsValue(Jest jest, Valeur valeur) {
		int count = 0;
		boolean all = false;
		for (int i = 0; i < jest.getCartes().size(); i++) {
			if (jest.getCartes().get(i).getValeur() == valeur) {
				count++;
			}
		}
		if (count == 4) {
			all = true;
		}
		return all;
	}

}
