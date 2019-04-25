import java.io.PrintWriter;
import java.io.File;
import java.io.*;

public class WriteFile{

public static void main(String []args){
try {
File file = new File (args[0]);
PrintWriter writer = new PrintWriter(file);
writer.write(args[1]);
writer.close();  
}
catch (Exception e){
System.out.println("Erreur");
}   
   
}
}

