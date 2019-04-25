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


class MyFrame extends Frame{

Panel p=new Panel();
MenuBar mb = new MenuBar();
Menu mb1 = new Menu("file");
MenuItem mi1 = new MenuItem("Open 1");
MenuItem mi2 = new MenuItem("Open 2");
MenuItem mi3 = new MenuItem("Concat");
MenuItem mi4 = new MenuItem("Save");
MenuItem mi5 = new MenuItem("Quit");


TextArea ta1 = new TextArea("");
TextArea ta2 = new TextArea("");
TextArea ta3 = new TextArea("");

MyWindowListener x = new MyWindowListener();
MyActionListenerForOpen1 x1 =new MyActionListenerForOpen1(this);
MyActionListenerForOpen2 x2 =new MyActionListenerForOpen2(this);
MyActionListenerForSave x3 = new MyActionListenerForSave(this);

    

public MyFrame(){

this.setBackground(Color.green);
this.add(p);
this.setBounds(50,50,600,600);
this.setVisible(true);
this.setTitle("My Application AWT");


p.setBackground(Color.green);
p.setBounds(0,0,600,80);
p.setLayout(new GridLayout(3,1));
p.add(ta1);
p.add(ta2);
p.add(ta3);
this.setMenuBar(mb);

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
}
);
mi4.addActionListener(x3);
mi5.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent e) {
System.exit(0);
 }
});
}
}
