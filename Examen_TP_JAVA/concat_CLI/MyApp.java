import java.io.* ;

public class MyApp {

public static void main(String []args){

try{
	String fileName1 = args[0] ; 
	String fileName2 = args[1] ; 
	System.out.println("le nom du fichier 1 est : " + fileName1);
	System.out.println("le nom du fichier 2 est : " + fileName2);
	File file1 = new File(fileName1);
	File file2 = new File(fileName2);
	FileInputStream in1 = new FileInputStream(file1);
	FileInputStream in2 = new FileInputStream(file2);
	int sizef1 = (int) file1.length();
	int sizef2 = (int) file2.length();
	byte dataf1[] = new byte[sizef1];
	byte dataf2[] = new byte[sizef2];
	in1.read(dataf1);
	in2.read(dataf2);
	String s1 = new String(dataf1);
	String s2 = new String(dataf2);
	
	System.out.println("le contenur du fichier 1 est: ");
	System.out.println(s1);
    System.out.println("*******************************");
    System.out.println("le contenur du fichier 2 est: ");
	System.out.println(s2);
	
	String finalText = s1 + s2 ;
	
	File file = new File("concat.txt");
    PrintWriter writer = new PrintWriter(file);
    writer.write(finalText);
    writer.close();

}catch(ArrayIndexOutOfBoundsException e1){
	System.out.println("il faur préciser le nom du fichier");
}catch(FileNotFoundException e2){
	System.out.println("fichier non trouvée");
}catch(IOException e3){
	System.out.println("erreur de chargement du fichier");
}
}
}
