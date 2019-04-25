import javax.swing.*;
import java.awt.*;

class AppSwing2 extends JFrame {
JButton p1= new JButton("I");	
JButton p2= new JButton("B");	
JButton p3= new JButton("M");

JSplitPane sp1=new JSplitPane();
JSplitPane sp2=new JSplitPane();

Color cp1= new Color (50,150,20);
Color cp2 =new Color (50,150,40);
Color cp3= new Color (150,150,50);
public AppSwing2(){
	initJSplitPaneEx();	
}

protected void initJSplitPaneEx(){
this.setSize(100,100); 
this.setTitle("DCAYNE");
this.getContentPane().setLayout(new BorderLayout());
p1.setBackground(cp1); 
p2.setBackground(cp2);
p3.setBackground(cp3);
sp2.setTopComponent(p2); 
sp2.setBottomComponent(p3);
sp2.setDividerSize(2);
sp2.setOrientation(JSplitPane.VERTICAL_SPLIT);
sp1.setTopComponent(p1); 
sp1.setBottomComponent(sp2);
sp1.setDividerSize(10);
sp1.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
sp1.setDividerLocation(100);
this.getContentPane().add(sp1,BorderLayout.CENTER);
this.setVisible(true);
}



public static void main (String [] args){
	AppSwing2 f=new AppSwing2();
}
}