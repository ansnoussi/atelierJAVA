import java.io.*; 
public class Test2{

	public static void main(String [] args) throws java.io.IOException{
            File fichier = new File(args[0]);
         try {
         	FileOutputStream fichier = new FileOutputStream(args[0]);
         }
         catch (FileNotFoundException e){
           System.out.println("File Not Found ! ");
       
	}

    
}  
}