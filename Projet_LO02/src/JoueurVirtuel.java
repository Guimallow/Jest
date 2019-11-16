
public class JoueurVirtuel extends Joueur{
	
	public JoueurVirtuel(){
		this.pseudo = genererPseudo();
		this.jest = new Jest(this);
		this.main = new Offre();
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
}
