public class Test{

	public static void main(String[] args) {
		Init i1 = new Init();
		i1=null;
		System.out.println("**********");
		System.gc();

	}
}