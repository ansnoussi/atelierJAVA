public abstract class Personnage {
	
private String nom;
public Personnage(String n) {
	nom = n;
}

public void afficher() {
	System.out.println("Je m'appelle " + nom);
}

public String getNom() {
	return nom;
}

}
