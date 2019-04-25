import java.awt.Frame;
import java.awt.*;

public class MyFrame extends Frame{

        	MyFrame() {
		
   }

	MyFrame(int x,int y,int z,int v,Color r,boolean etat,String title) {
		setBounds(x,y,z,v);
		setBackground(r);
                setVisible(etat);
                setTitle(title);
		
   }

       	MyFrame(int x,int y,int z,int v) {
		setBounds(x,y,z,v);
		
   }
	MyFrame(Color r,boolean etat,String title) {
		setBackground(r);
                setVisible(etat);
                setTitle(title);
		
   }


}