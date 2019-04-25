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

	Panel pNorth=new Panel();
	Button bNew=new Button("New");
	Button bOpen=new Button("Open");
    Button bSave=new Button("Save");
    Button bQuit=new Button("Exit");
    Button bReset = new Button("Reset");
    TextField search = new TextField();
    Label searchResult = new Label("Search");
    TextField replace = new TextField();
    Label replaceLabel = new Label("Replace");
    Panel pSouth =new Panel();
    TextArea ta = new TextArea("");
    TextField tf = new TextField();
    Label lb = new Label("Taille");
    TextField tf2 = new TextField();
    Label lb2 = new Label("Couleur");
    TextField tf3 = new TextField();
    Label lb3 = new Label("Police");
    TextArea stat = new TextArea("");
    Button statistique = new Button("Statistique");
    MyWindowListener x1 = new MyWindowListener();
    MyActionListenerForOpen x2 =new MyActionListenerForOpen(this);
    MyActionListenerForSave x3 = new MyActionListenerForSave(this);
    

    public MyFrame(){
        this.setBackground(Color.blue);
        this.add(pNorth);
        this.add(pSouth);	
        this.setBounds(50,50,520,550);
        this.setVisible(true);
        this.setTitle("My Application AWT");


    	pNorth.setBackground(Color.blue);
        pNorth.setBounds(0,0,520,80);
        pNorth.setLayout(null);
        pNorth.add(bNew);
        bNew.setBounds(30,45,50,20);
        pNorth.add(bOpen);
        bOpen.setBounds(90,45,50,20);
        pNorth.add(bSave);
        bSave.setBounds(150,45,50,20);
        pNorth.add(bQuit);
        bQuit.setBounds(210,45,50,20);
        pNorth.add(search);
        search.setBounds(270,45,50,20);
        pNorth.add(searchResult);
        searchResult.setBounds(323,45,70,20);
        pNorth.add(replace);
        replace.setBounds(395,45,50,20);
        pNorth.add(replaceLabel);
        replaceLabel.setBounds(447,45,50,20);

    	pSouth.setBackground(Color.yellow);
        pSouth.setBounds(0,81,520,320);
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
        stat.setBounds(10,385,470,100);
        pSouth.add(stat);
        statistique.setBounds(210,490,100,20);
        pSouth.add(statistique);
        this.addWindowListener(x1);
        bOpen.addActionListener(x2);
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
        String x1 = tf.getText() ; 
        int v1 = Integer.parseInt(x1) ;  
        Font font=new Font(x3,Font.PLAIN,v1);  
        ta.setFont(font); } } );

        bReset.addActionListener(new ActionListener(){
        public void actionPerformed (ActionEvent e){
            ta.setText("");
            search.setText("");
            replace.setText("");
            search.setText("");
            searchResult.setText("Search");
            searchResult.setForeground(Color.black);
            stat.setText("");
            tf.setText("");
            tf2.setText("");
            tf3.setText("");
        }
        });

        search.addActionListener( new ActionListener () 
        { public void actionPerformed (ActionEvent e) 
        { 
        String x4 = search.getText() ;  
        String x5 =  ta.getText();
        if(x5.indexOf(x4)>=0){
        searchResult.setText("Existe");
        searchResult.setForeground(Color.green);
        }
        else {
        searchResult.setText("N'existe pas");
        searchResult.setForeground(Color.red);
        }
        } } );

        replace.addActionListener( new ActionListener () 
        { public void actionPerformed (ActionEvent e) 
        {  
        String x8 = ta.getText();
        ta.setText(x8.replaceAll(search.getText(),replace.getText()));
        } } );

        statistique.addActionListener( new ActionListener () 
        { public void actionPerformed (ActionEvent e) 
        { 
        String x9 = ta.getText();
        int nbrmots = x9.trim().split(" |\n").length;  
        int nbrlignes = x9.trim().split("\n").length;
        stat.setText("Nombre de Caractère : " + x9.length() +"\nNombre de Mots : " + nbrmots + "\nNombre de Lignes : "+ nbrlignes);
        } } );
       
    }


}