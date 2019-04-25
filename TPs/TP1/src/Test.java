public class Test {
 public static void main(String [] args) {
	 Eleve e = new Eleve("Mohamed Lamine Barghouda",2);
	 Professeur p = new Professeur("Dupont Britt","Maître de conférences");
	 e.afficher();
	 e.direBonjour();
	 System.out.println("\n");
	 p.afficher();
	 p.direBonjour();
	 System.out.println("\n");
	 System.out.println("*** L'eleve a reussi ***\n");
	 e.aReussi();
	 e.afficher();
 }
}