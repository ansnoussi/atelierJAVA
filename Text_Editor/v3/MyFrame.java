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
import javax.swing.JOptionPane;


class MyFrame extends Frame{

    Panel pNorth=new Panel();
    Button bReset = new Button("Reset");
    TextField search = new TextField();
    Label searchResult = new Label("Search");
    TextField replace = new TextField();
    Label replaceLabel = new Label("Replace");
    

    Panel pSouth =new Panel();
    TextArea ta = new TextArea("");
    TextArea stat = new TextArea("");


    MenuBar mb = new MenuBar();
    Menu me = new   Menu("file");
    MenuItem me1 = new MenuItem("open");
    MenuItem me2= new MenuItem("save");
    MenuItem me3 = new MenuItem("quite");
    Menu mf = new Menu("Format");
    MenuItem mf1 = new MenuItem("Taille");
    MenuItem mf2 = new MenuItem("Couleur");
    MenuItem mf3 = new MenuItem("Police");
    MenuItem mf4 = new MenuItem("Reset");
    MenuItem mf5 = new MenuItem("Statistiques");
    

    public MyFrame(){
        this.setBackground(Color.blue);
        this.setLayout(null);
        this.add(pNorth);
        this.add(pSouth);	
        this.setBounds(50,50,520,550);
        this.setVisible(true);
        this.setTitle("mon editeur de texte");

        me.add(me1);
        me.add(me2);
        me.add(me3);
        mb.add(me);
        mf.add(mf1);
        mf.add(mf2);
        mf.add(mf3);
        mf.add(mf4);
        mf.add(mf5);
        mb.add(mf);
        this.setMenuBar(mb);















    	pNorth.setBackground(Color.green);
        pNorth.setBounds(0,15,520,180);
        pNorth.setLayout(null);
        pNorth.add(stat);
        stat.setBounds(20,50,470,100);


               
    	pSouth.setBackground(Color.blue);
        pSouth.setBounds(0,195,800,320);
        pSouth.setLayout(null);

        pSouth.add(ta);
        ta.setBounds(20,20,470,270);


        pSouth.add(search);
        search.setBounds(50,300,50,20);
        pSouth.add(searchResult);
        searchResult.setBounds(103,300,70,20);
        pSouth.add(replace);
        replace.setBounds(175,300,50,20);
        pSouth.add(replaceLabel);
        replaceLabel.setBounds(227,300,50,20);
 
    	


        MyWindowListener x1 = new MyWindowListener();
    	this.addWindowListener(x1);

    	MyActionListenerForOpen x2 =new MyActionListenerForOpen(this);
        me1.addActionListener(x2);

    	MyActionListenerForSave x3 = new MyActionListenerForSave(this);
    	me2.addActionListener(x3);

        me3.addActionListener(new ActionListener(){
    	public void actionPerformed(ActionEvent e) {
				System.exit(0);
				 }
		});



        mf1.addActionListener( new ActionListener () 
        { public void actionPerformed (ActionEvent e) 
        { 
        String x1 = JOptionPane.showInputDialog(null,"donner la taille: ", null); 
        int v1 = Integer.parseInt(x1) ; 
        Font font=new Font("Arial",0,v1);  
        ta.setFont(font); } } );


        mf2.addActionListener( new ActionListener()
        { public void actionPerformed (ActionEvent e){
        String x2 = JOptionPane.showInputDialog(null,"donner la couleur: ", null); 
        Color c2 ;
        try {
        Field field = Class.forName("java.awt.Color").getField(x2);
        c2 = (Color)field.get(null);
        } catch (Exception b) {
        c2 = Color.black;
        }
        ta.setForeground(c2);       
        } 
        });

        mf3.addActionListener( new ActionListener () 
        { public void actionPerformed (ActionEvent e) 
        { 
        String x3 = JOptionPane.showInputDialog(null,"donner le police: ", null);   
        Font font=new Font(x3,0,15);  
        ta.setFont(font); } } );




        mf4.addActionListener(new ActionListener(){
        public void actionPerformed (ActionEvent e){
            ta.setText("");
            stat.setText("");
        }
        });

        mf5.addActionListener( new ActionListener () 
        { public void actionPerformed (ActionEvent e) 
        { 
        String x9 = ta.getText();
        int nbrmots = x9.trim().split(" |\n").length;  
        int nbrlignes = x9.trim().split("\n").length;
        stat.setText("Nombre de Caracteres : " + x9.length() +"\nNombre de Mots : " + nbrmots + "\nNombre de Lignes : "+ nbrlignes);
        } } );




        search.addActionListener( new ActionListener () 
        { public void actionPerformed (ActionEvent e) 
        { 
        String x4 = search.getText() ;  
        String x5 =  ta.getText();
        if(x5.indexOf(x4)>=0){
        searchResult.setText("Existe");
        }
        else {
        searchResult.setText("N'existe pas");
        }
        } } );

        replace.addActionListener( new ActionListener () 
        { public void actionPerformed (ActionEvent e) 
        {  
        String x8 = ta.getText();
        ta.setText(x8.replaceAll(search.getText(),replace.getText()));
        } } );


       
    }


}
