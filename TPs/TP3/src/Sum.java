public class Sum{
	public static void main (String [] args){
		int i =0; String s="";
		while (args.length>i)
		{
			
			String a = args[i];
			s = s + a ;
			i++;
		}
		System.out.print(s);
	}
}