import java.io.*;

class Etudiant implements Serializable 
{
	public String nom;
	public String prenom;
        public float moyenne;
	Etudiant(String nom,String prenom,float moyenne)
	{
		this.nom=nom;
		this.prenom=prenom; 
                this.moyenne=moyenne;
	}
}