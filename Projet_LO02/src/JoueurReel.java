
public class JoueurReel extends Joueur {
	
	public JoueurReel(String nom){
		this.pseudo = nom;
		this.jest = new Jest();
		this.main = new Offre();
	}
}
