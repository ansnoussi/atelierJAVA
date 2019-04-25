import java.awt.*;
import javax.swing.*;
import java.io.*;   
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class MyFrame extends JFrame {
  boolean v=false ;
  Color bgc; 
  Panel pNorth ;
  Panel p; 
  Button save = new Button("Save");
  JTable j = new JTable(5,3);
  MyFileDialog mfd = new MyFileDialog(this);
  MyFrame() {
      v=true;
      this.setBounds(40,40,500,500); 
      p= new Panel();
      this.setBackground(Color.blue);
      this.add(p);
      p.add(j);
      this.setVisible(v);
      p.add(save);
      try
        {
          InputStream is = new FileInputStream ("etudiant.txt");
          InputStreamReader s = new InputStreamReader(is);
          BufferedReader b = new BufferedReader(s);
          String ligne="";
          int l=0;
          while ( ( ligne=b.readLine())!= null )
          {
            String[] tokens =ligne.split(":");
               for(int k=0;k<tokens.length;k++) 
                  { 
                       j.setValueAt(tokens[k],l,k);
                                   }
          l++;
          }
          b.close();  
     } catch(IOException e3 ){
       System.out.println(e3.toString());
     }

     save.addActionListener( new ActionListener(){
  public void actionPerformed(ActionEvent e){

            mfd.setMode(mfd.getMS());
            mfd.setVisible(true);
            String nomFichier = mfd.getFile();
            String repFichier = mfd.getDirectory();
            String nomComplet = nomFichier + repFichier;
            File file = new File (mfd.getDirectory()+mfd.getFile());
            try
            {
             PrintWriter writer = new PrintWriter(file);
             writer.write(getTable());
             writer.close(); 
            }
            catch (FileNotFoundException e2){
            	System.out.println(e2.toString());
            }
            
     }
    });
}


   public String getTable(){
   String res="";
   for(int i=0;i< j.getRowCount();i++){
   for(int k=0;k< j.getColumnCount();k++){
   if(k!=2)
   res = res + j.getValueAt(i,k) + ":";
   else
   res = res + j.getValueAt(i,k) ;
   }
   res = res + "\n";
   }
   return res;
}

 
}
