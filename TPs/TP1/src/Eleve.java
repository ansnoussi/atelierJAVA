public class Eleve extends Personnage implements MotDeSalut,Salutation{
	private int niveau;
	public Eleve(String n,int v) {
		super(n);
		niveau = v;
	}
	
@Override
public void direBonjour() {
	System.out.println( BNJ + " Monsieur ! " + BNJ + " mes camarades ! \n");
}

@Override
	public void direBye() {
		System.out.println(BYE + "! \n");
	}

public void afficher() {
	super.afficher();
	System.out.println("Je suis un Eleve de niveau " + niveau);
}

public void aReussi() {
	niveau++;
}


}
