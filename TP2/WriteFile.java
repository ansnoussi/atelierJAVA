import java.io.PrintWriter;
import java.io.File;
import java.io.*;

public class WriteFile{

public static void main(String []args){
try {
String fileName = args[0];
File file = new File (fileName);
PrintWriter writer = new PrintWriter(file);
String text = args[1];
writer.write(args[1]);
writer.close();  
}
catch (Exception e){
System.out.println("Erreur");
}   
   
}
}

