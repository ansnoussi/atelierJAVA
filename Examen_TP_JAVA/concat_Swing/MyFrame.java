import java.awt.*;
import java.util.*;
import java.awt.Frame;
import java.awt.Component;
import java.awt.event.*;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JTabbedPane;
import java.lang.reflect.Field;
import java.awt.Font;
class MyFrame extends JFrame{
    JSplitPane sp1 = new JSplitPane();
    JSplitPane sp2 = new JSplitPane();
    JPanel p=new JPanel();
    JMenuBar mb = new JMenuBar();
    JMenu mb1 = new JMenu("file");
    JMenuItem mi1 = new JMenuItem("Open 1");
    JMenuItem mi2 = new JMenuItem("Open 2");
    JMenuItem mi3 = new JMenuItem("Concat");
    JMenuItem mi4 = new JMenuItem("Save");
    JMenuItem mi5 = new JMenuItem("Quit");

    JTextArea ta1 = new JTextArea("");
    JTextArea ta2 = new JTextArea("");
    JTextArea ta3 = new JTextArea("");
    MyWindowListener x = new MyWindowListener();
    MyActionListenerForOpen1 x1 =new MyActionListenerForOpen1(this);
    MyActionListenerForOpen2 x2 =new MyActionListenerForOpen2(this);
    MyActionListenerForSave x3 = new MyActionListenerForSave(this);

    

    public MyFrame(){
        this.setBackground(Color.blue);
        sp1.setTopComponent(ta1);
        sp1.setBottomComponent(sp2);
        sp2.setTopComponent(ta2);
        sp2.setBottomComponent(ta3);
        this.setBounds(50,50,520,550);
        this.setVisible(true);
        this.setTitle("My Application AWT");
        ta1.setBackground(Color.blue);
        ta2.setBackground(Color.yellow);
        ta3.setBackground(Color.white);
    	p.setBackground(Color.blue);
        p.setBounds(0,0,520,80);
this.getContentPane().setLayout(new BorderLayout());
this.add(sp1);
sp1.setOrientation(JSplitPane.VERTICAL_SPLIT);
sp2.setOrientation(JSplitPane.VERTICAL_SPLIT);
sp1.setDividerLocation(200);
sp2.setDividerLocation(200);
        this.setJMenuBar(mb);
    mb1.add(mi1);
    mb1.add(mi2);
    mb1.add(mi3);
    mb1.add(mi4);
    mb1.add(mi5);
    mb.add(mb1);
        this.addWindowListener(x);
        mi1.addActionListener(x1);
        mi2.addActionListener(x2);
        mi3.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
        String s1 = ta1.getText();
        String s2 = ta2.getText();
        ta3.setText(s1 +"\n" + s2);
        }
});
        mi4.addActionListener(x3);
        mi5.addActionListener(new ActionListener(){
    	public void actionPerformed(ActionEvent e) {
				System.exit(0);
				 }
			});


       
    }


}