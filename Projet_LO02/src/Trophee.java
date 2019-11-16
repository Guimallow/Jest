
public class Trophee implements ObjetVisite{
	public boolean estAttribue;
	public void accept(Visiteur v){
		v.visit(this);
	}
	
}
