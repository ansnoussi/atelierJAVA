import java.awt.Frame;
import java.awt.*;


public class MyFrame extends Frame{


	MyFrame(int x,int y,int z,int v,Color r) {
          // Constructs a new instance of Frame that is initially invisible.
		setBounds(x,y,z,v);
		setBackground(r);
}
     /* MyFrame(GraphicsConfiguration gc) {
          // Constructs a new, initially invisible Frame with the specified GraphicsConfiguration.

}
    MyFrame(String title) {
          // Constructs a new, initially invisible Frame object with the specified title.
    }
    MyFrame(String title, GraphicsConfiguration gc) {
         // Constructs a new, initially invisible Frame object with the specified title and a GraphicsConfiguration.
    }  */


}