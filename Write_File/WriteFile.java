import java.io.PrintWriter;
import java.io.File;
import java.io.*;

public class WriteFile{

public static void main(String []args){
try {
File file = new File ("newfile.txt");
PrintWriter writer = new PrintWriter(file);
writer.write(args[0]);
writer.close();  
}
catch (Exception e){
System.out.println("Erreur");
}   
   
}
}

