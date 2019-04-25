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

class MyFrame extends Frame{

	Panel pNorth=new Panel();
	Button bNew=new Button("New");
	Button bOpen=new Button("Open");
    Button bSave=new Button("Save");
    Button bQuit=new Button("Exit");
    Button bReset = new Button("Reset");

    Panel pSouth =new Panel();
    TextArea ta = new TextArea("");
    TextField tf = new TextField();
    Label lb = new Label("Taille");
    TextField tf2 = new TextField();
    Label lb2 = new Label("Couleur");
    TextField tf3 = new TextField();
    Label lb3 = new Label("Police");
    
    

    public MyFrame(){
        this.setBackground(Color.blue);
        this.add(pNorth);
        this.add(pSouth);
        this.setBounds(0,0,505,420);
        this.setVisible(true);


    	pNorth.setBackground(Color.green);
        pNorth.setBounds(0,0,500,80);
        pNorth.setLayout(new FlowLayout(1,10,40));
        pNorth.add(bNew);
        pNorth.add(bOpen);
        pNorth.add(bSave);
        pNorth.add(bQuit);
               

    	pSouth.setBackground(Color.yellow);
        pSouth.setBounds(0,81,500,320);
        pSouth.setLayout(null);
    	pSouth.add(ta);
        ta.setBounds(10,80,470,270);
        pSouth.add(tf);
        pSouth.add(lb);
        tf.setBounds(10,355,50,20);
        lb.setBounds(65,355,50,20);
        pSouth.add(tf2);
        pSouth.add(lb2);
        tf2.setBounds(120,355,50,20);
        lb2.setBounds(175,355,50,20);
        pSouth.add(tf3);
        pSouth.add(lb3);
        tf3.setBounds(230,355,50,20);
        lb3.setBounds(285,355,50,20);
        pSouth.add(bReset);
        bReset.setBounds(350,355,50,20);


        

    	


        MyWindowListener x1 = new MyWindowListener();
    	this.addWindowListener(x1);

    	MyActionListenerForOpen x2 =new MyActionListenerForOpen(this);
    	bOpen.addActionListener(x2);

    	MyActionListenerForSave x3 = new MyActionListenerForSave(this);
    	bSave.addActionListener(x3);

        bQuit.addActionListener(new ActionListener(){
    	public void actionPerformed(ActionEvent e) {
				System.exit(0);
				 }
			});


        tf.addActionListener( new ActionListener () 
        { public void actionPerformed (ActionEvent e) 
        { 
        String x1 = tf.getText() ; 
        int v1 = Integer.parseInt(x1) ; 
        Font font=new Font("Arial",0,v1);  
        ta.setFont(font); } } );


        tf2.addActionListener( new ActionListener()
        { public void actionPerformed (ActionEvent e){
        String x2 = tf2.getText();
        Color c2 ;
        try {
        Field field = Class.forName("java.awt.Color").getField(x2);
        c2 = (Color)field.get(null);
        } catch (Exception b) {
        c2 = null; // Not defined
        }
        ta.setForeground(c2);       
        } 
        });

        tf3.addActionListener( new ActionListener () 
        { public void actionPerformed (ActionEvent e) 
        { 
        String x3 = tf3.getText() ;  
        Font font=new Font(x3,0,15);  
        ta.setFont(font); } } );

        bReset.addActionListener(new ActionListener(){
        public void actionPerformed (ActionEvent e){
            ta.setText("");
        }

        });
       
    }


}