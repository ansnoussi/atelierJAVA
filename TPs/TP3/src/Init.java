public class Init {
	Init(int x){
		System.out.println("1-arg const Init");
	}

	Init(){
         System.out.println("no-arg const Init");
	}

	static{
		System.out.println("static int Init");
	}

    public void finalize(){
      System.out.println("Garbage Collection Activated ! ");
      System.out.println("Object Deleted");
    } 

}