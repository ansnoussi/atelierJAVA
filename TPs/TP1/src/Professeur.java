
public class Professeur extends Personnage implements MotDeSalut,Salutation{
	private String grade;
	public Professeur(String n,String g) {
		super(n);
		grade = g;
	}
	
	@Override
	public void direBonjour() {
		System.out.println(BNJ + " tout le monde ! \n");
	}
	
	@Override
		public void direBye() {
			System.out.println(BYE + " ! A la prochaine :) \n");
		}
	
	public void afficher() {
		super.afficher();
		System.out.println("Je suis un Professeur de grade " + grade);
	}
	
	public void setGrade(String g) {
		grade = g;
	}
}
