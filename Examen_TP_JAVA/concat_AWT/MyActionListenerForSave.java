import java.awt.event.*;
import java.awt.*;
import java.io.*;
public class MyActionListenerForSave implements ActionListener{
MyFrame f;
public MyActionListenerForSave(MyFrame f ){
this.f=f;
}
public void actionPerformed(ActionEvent e){
MyFileDialog mfd = new MyFileDialog(f);
mfd.setMode(mfd.getMS());
mfd.setVisible(true);
File file = new File (mfd.getDirectory()+mfd.getFile());
try
{
PrintWriter writer = new PrintWriter(file);
writer.write(f.ta3.getText());
writer.close(); 
}
catch (FileNotFoundException e2){
System.out.println(e2.toString());
}
}
}
