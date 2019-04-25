import java.awt.*;
import javax.swing.*;
import java.io.*;   
import java.util.*;
public class MyFrame extends JFrame {
  boolean v=false ;
  Color bgc; 
  Panel pNorth ;
  Panel p; 
  MyFrame() {
      v=true;
      this.setBounds(40,40,500,500); 
      p= new Panel();
      JTable j = new JTable(7,3);
      this.setBackground(Color.blue);
      this.add(p);
      p.add(j);
      this.setVisible(v);
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
    }
  }
