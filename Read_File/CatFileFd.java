import java.io.* ;
import java.awt.* ;

public class CatFileFd {

public static void main(String args []){
	
	File fichier ;

try{
	if(args.length == 1){
	String fileName = args[0] ; 
	System.out.println("le nom du fichier est : " + fileName);
	fichier = new File(fileName);
	}else{
	Frame tempFrame = new Frame();
	FileDialog fd = new FileDialog(tempFrame);
	fd.setVisible(true);
	String fileNameComplet = fd.getDirectory() + fd.getFile();
	System.out.println(fileNameComplet );
	fichier = new File(fd.getDirectory() + fd.getFile() );
	}

	FileInputStream in = new FileInputStream(fichier );
	int size = (int)fichier.length();
	byte data[] = new byte[size];
	in.read(data);
	String s = new String(data);
	System.out.println("le contenu du fichier est: ");
	System.out.println(s);


}catch(FileNotFoundException e2){
	System.out.println("fichier non trouvée");
}catch(IOException e3){
	System.out.println("erreur de chargement du fichier");
}


}
}
