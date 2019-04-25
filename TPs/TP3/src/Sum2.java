public class Sum2{
	public static void main (String [] args){
		int i =0; int s=0;
		while (args.length>i)
		{
			
			int a = Integer.parseInt(args[i]);
			s+=a;
			i++;
		}
		System.out.print(s);
	}
}