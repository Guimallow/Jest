import java.util.ArrayList;

public class JoueurVirtuel extends Joueur{
	
	public JoueurVirtuel(Partie partie){
		super(partie);
		this.setPseudo(genererPseudo());
		
	}
	
	//Permet de prendre 5 caract�res al�atoires dans la cha�ne caracteresPossibles 
	public static String genererPseudo() {
        String caracteresPossibles = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890"; 
        StringBuffer pass = new StringBuffer();
        
        for(int x = 0 ; x < 5 ; x++){
           int i = (int)Math.floor(Math.random() * (caracteresPossibles.length() -1));
           pass.append(caracteresPossibles.charAt(i));
        }
        return pass.toString();
	}
	
	public void faireOffre(StrategieA methode) {
		methode.faireOffre(this);
	}
	public void piocherOffre(StrategieA methode, Joueur joueurPioche) {
		methode.piocherOffre(this, joueurPioche);
	}
	public Joueur choisirJoueurAPiocher(StrategieA methode, ArrayList<Joueur> joueurs) {
		return methode.choisirJoueurAPiocher(joueurs);
	}
}
