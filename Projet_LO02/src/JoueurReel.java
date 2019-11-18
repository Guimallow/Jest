
public class JoueurReel extends Joueur {
	
	public JoueurReel(String nom, Partie partie){
		super(partie);
		this.pseudo = nom;
		this.jest = new Jest(this);
		this.main = new Offre();
		partie.addJoueur(this);
	}
}
