import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class AppSwing extends JFrame 
{
JButton b1= new JButton("Nord");	
JButton b2= new JButton("Ouest");	
JButton b3= new JButton("Est");	

public AppSwing()
{	
	initGUI();
}

public void initGUI()
{this.getContentPane().add(b1,BorderLayout.NORTH);
this.getContentPane().add(b2,BorderLayout.WEST);
this.getContentPane().add(b3,BorderLayout.EAST);
this.setSize(new Dimension(500,400));
this.setVisible(true);
	
	
}
	
public static void main (String []args)
{AppSwing f=new AppSwing ();

}		

}