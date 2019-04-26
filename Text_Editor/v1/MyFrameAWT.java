import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.TextEvent;
import java.awt.TextArea;
import java.awt.FileDialog;
import java.io.*;
import java.lang.String;
import java.io.FileWriter;
import java.io.PrintWriter;
class MyFrameAWT extends Frame{
   
	 Panel pNorth=new Panel();
	 Button bOpen=new Button("Open");
     Button bSave=new Button("Save");
     Button bQuit=new Button("Exit");

    Panel pSouth =new Panel();
    TextArea ta = new TextArea("");
    TextArea fileInfo = new TextArea("");
    MyWindowListener x1 = new MyWindowListener();
    

    public MyFrameAWT(){
    	pNorth.setBackground(Color.green);
    	pNorth.add(bOpen);
    	pNorth.add(bSave);
    	pNorth.add(bQuit);
	pNorth.add(fileInfo);
    	pSouth.setBackground(Color.yellow);
    	pSouth.add(ta);

    	this.setBackground(Color.blue);
    	this.setLayout(new GridLayout (2,1));
    	this.add(pNorth);
    	this.add(pSouth);
    	this.setBounds(10,10,500,400);
    	this.setVisible(true);
    	this.addWindowListener(x1);
   	    MyActionListenerForOpen x2 = new MyActionListenerForOpen(this); 
        bOpen.addActionListener(x2);
    	MyActionListenerForSave x3 = new MyActionListenerForSave(this);
    	bSave.addActionListener(x3);
        bQuit.addActionListener(new ActionListener(){
    	public void actionPerformed(ActionEvent e) {
				System.exit(0);
				 }
			});
       
    }


}
