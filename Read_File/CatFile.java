import java.io.* ;
import java.awt.* ;

public class CatFile {

public static void main(String args []){

try{
	String fileName = args[0] ; 
	System.out.println("le nom du fichier est : " + fileName);
	File file = new File(fileName);
	FileInputStream in = new FileInputStream(file);
	int size = (int) file.length();
	byte data[] = new byte[size];
	in.read(data);
	String s = new String(data);
	System.out.println("le contenur du fichier est: ");
	System.out.println(s);
	
	
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
