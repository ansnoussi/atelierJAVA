import java.awt.event.*;
import java.awt.*;
import java.io.*;
public class MyActionListenerForOpen2 implements ActionListener{
MyFrame f;

public MyActionListenerForOpen2(MyFrame f ){
this.f=f;
}

public void actionPerformed(ActionEvent e){
FileDialog fd = new FileDialog(f);
fd.setVisible(true);
String nomFichier =fd.getFile();
String repFichier=fd.getDirectory();
String nomComplet=repFichier+nomFichier;
File file = new File (nomComplet);
int size;
size = (int) file.length();
try{
FileInputStream in = new FileInputStream(file);
byte data[] = new byte[size];
in.read(data);
String s=new String (data);
f.ta2.setText(s);
}catch (FileNotFoundException e2){System.out.println(e2);}
catch (IOException e3){System.out.println(e3);}	
}

}