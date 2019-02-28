import java.io.PrintWriter;
import java.io.File.*;
import java.io.*;
import java.awt.* ;
import java.awt.FileDialog.* ;
import java.util.Scanner;

public class WriteFileFd {

public static void main(String[]  args){

String fileName ;

try{
if(args.length == 0){

Frame tempFrame = new Frame();
FileDialog fd = new FileDialog(tempFrame);
fd.setVisible(true);
fileName = fd.getDirectory() + fd.getFile();
}else{
fileName = args[0];
}

File monFichier = new File(fileName);
PrintWriter writer = new PrintWriter(monFichier);

Scanner sc = new Scanner(System.in);
String text = sc.nextLine();
System.out.println("votre text: " + text);
writer.write(text);
writer.close();  


}catch(Exception e){
System.out.println("erreur");
}

}

}