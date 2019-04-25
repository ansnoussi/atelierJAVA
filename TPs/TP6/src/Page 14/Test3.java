public class Test3{
public static void main(String[] args){
// Partie 1
StringBuffer sb = new StringBuffer("abc"); 
sb.append("def"); 
System.out.println("sb = " + sb);
// Partie 2
StringBuilder sb2 = new StringBuilder("abc");
sb2.append("def").reverse().insert(3, "---");
System.out.println( sb2 );
}
}