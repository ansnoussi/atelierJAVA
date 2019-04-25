import java.io.*;
public class SerializeEtudiant
{
	public static void main (String[] args)
	{
		Etudiant etudiant = new Etudiant("Barghouda","Mohamed Lamine",13);
		try {       
			FileOutputStream fichier = new FileOutputStream("etudiant.ser");       
			ObjectOutputStream oos = new ObjectOutputStream(fichier);       
			oos.writeObject(etudiant);             
			oos.close();}     
			catch (java.io.IOException e) {
				e.printStackTrace();}
			}

		} 