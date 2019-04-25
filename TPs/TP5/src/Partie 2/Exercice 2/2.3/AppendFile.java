import java.io.* ;
import java.awt.* ;

public class AppendFile {

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
	String finalText = s + args[1] ;
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