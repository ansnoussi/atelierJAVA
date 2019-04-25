public class Init2 extends Init {
	Init2(int x){
		System.out.println("1-arg const Init2");
	}
	Init2(){
         System.out.println("no-arg const Init2");
	}
	static{
		System.out.println("static int Init2");
	} 
}