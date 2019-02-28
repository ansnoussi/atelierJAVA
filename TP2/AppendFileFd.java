import java.io.PrintWriter;
import java.io.File.*;
import java.io.*;
import java.awt.* ;
import java.awt.FileDialog.* ;
import java.util.Scanner;


public class AppendFileFd {

public static void main(String [] args){

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

	File file = new File(fileName);
	FileInputStream in = new FileInputStream(file);
	int size = (int) file.length();
	byte data[] = new byte[size];
	in.read(data);
	String s = new String(data);
	
	PrintWriter writer = new PrintWriter(file);

	Scanner sc = new Scanner(System.in);
	String text = sc.nextLine();
	String finalText = s + text ;

	System.out.println("votre text: " + finalText);
	writer.write(finalText);
	writer.close();


}catch(Exception e){
System.out.println("erreur");
}

}

}
