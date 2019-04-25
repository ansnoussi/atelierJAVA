import java.util.*;
import java.lang.*;

public class Etudiant implements Comparable <Etudiant> {
	public String nom;
	public String prenom;
	public int id;
	public double moy; 
	
	public Etudiant(String nom,String prenom, int id , double moy){
		this.nom = nom;
		this.prenom = prenom;
		this.id=id;
		this.moy=moy;
	}
	
	public String toString(){
		String s =nom+"\t"+prenom+"\t"+id+"\t"+moy;
		return s;
	}
	public boolean equals(Etudiant e){
		if(!(e instanceof Etudiant)) return false;
		return nom.equals(e.nom) && prenom.equals(e.prenom) ;
	}

	public int compareTo(Etudiant e)
	{
          if (moy > e.moy)
           return 1;
          else if(moy == e.moy)
           return 0;
          else
           return -1 ;
	}

}
