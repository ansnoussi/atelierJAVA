import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.JCheckBox;
import java.util.*;


public class App2 extends JFrame {
    JSplitPane sp1 = new JSplitPane();
    JSplitPane sp2 = new JSplitPane();
    JSplitPane sp3 = new JSplitPane();
    JSplitPane sp4 = new JSplitPane();
    JSplitPane sp5 = new JSplitPane();
    JTextField tf1= new JTextField(15);
    Choice choice = new Choice();
    Vector v = new Vector();
    JList list = new JList(v);
    JCheckBox cbSolaris = new JCheckBox("Solaris");
    JCheckBox cbLinux = new JCheckBox("Linux");
    JCheckBox cbAix = new JCheckBox("Aix");
    JCheckBox rbSolaris = new JCheckBox("Solaris");
    JCheckBox rbLinux = new JCheckBox("Linux");
    JCheckBox rbAix = new JCheckBox("Aix");

    public App2(){

        JPanel tfPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel l1 = new JLabel("TextField");
        tfPanel.add(l1);
        tfPanel.add(tf1);
        tfPanel.setBackground(Color.blue);

    
        JPanel chPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel l2 = new JLabel("Choice");
        chPanel.add(l2);
        choice.addItem("Solaris");
        choice.addItem("Linux");
        choice.addItem("Aix");
        chPanel.add(choice);
        chPanel.setBackground(Color.red);

  
        JPanel listPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel l3 = new JLabel("List");
        listPanel.add(l3);
        v.addElement("Solaris");
        v.addElement("Linux");
        v.addElement("Aix");
        listPanel.add(list);
        listPanel.setBackground(Color.yellow);

        
        JPanel cbPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        cbPanel.add(cbSolaris);
        cbPanel.add(cbLinux);
        cbPanel.add(cbAix);
        cbPanel.setBackground(Color.green);

        
        JPanel rbPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        ButtonGroup rbGroup = new ButtonGroup();
        rbGroup.add(rbSolaris);
        rbGroup.add(rbLinux);
        rbGroup.add(rbAix);
        rbPanel.add(rbSolaris);
        rbPanel.add(rbLinux);
        rbPanel.add(rbAix);
        rbPanel.setBackground(Color.CYAN);

       
        JPanel btPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton okButton = new JButton("Ok");
       okButton.addActionListener(new OkButtonListener(this));
        btPanel.add(okButton);
        JButton cancelButton = new JButton("Cancel");
        btPanel.add(cancelButton);
        btPanel.setBackground(Color.pink);
        cancelButton.addActionListener(new ActionListener(){
    	public void actionPerformed(ActionEvent e) {
				System.exit(0);
				 }
			});

        
        JMenu procMenu = new JMenu("Procedural");
        procMenu.add(new JMenuItem("Pascal"));
        
        JMenu ooMenu = new JMenu("Object Oriented");
        ooMenu.add(new JMenuItem("SmallTalk"));
        ooMenu.add(new JMenuItem("Java"));
        ooMenu.add(new JMenuItem("Eiffel"));
        ooMenu.add(new JMenuItem("C++"));
        
        JMenu funcMenu = new JMenu("Functional");
        funcMenu.add(new JMenuItem("Lisp"));
        
        JMenu languageMenu = new JMenu("Languages");
        languageMenu.add(procMenu);
        languageMenu.add(ooMenu);
        languageMenu.add(funcMenu);
        
       
        JMenuBar mb = new JMenuBar();
        mb.add(languageMenu);
this.setSize(1000,1000);
this.getContentPane().setLayout(new BorderLayout());
this.setVisible(true);
sp1.setTopComponent(tfPanel);
sp1.setBottomComponent(sp2);
sp2.setTopComponent(chPanel);
sp2.setBottomComponent(sp3);
sp3.setTopComponent(listPanel);
sp3.setBottomComponent(sp4);
sp4.setTopComponent(cbPanel);
sp4.setBottomComponent(sp5);
sp5.setTopComponent(rbPanel);
sp5.setBottomComponent(btPanel);
sp1.setOrientation(JSplitPane.VERTICAL_SPLIT);
sp2.setOrientation(JSplitPane.VERTICAL_SPLIT);
sp3.setOrientation(JSplitPane.VERTICAL_SPLIT);
sp4.setOrientation(JSplitPane.VERTICAL_SPLIT);
sp5.setOrientation(JSplitPane.VERTICAL_SPLIT);
this.getContentPane().add(sp1);
       
        this.addWindowListener(new WindowAdapter (){
            public void windowClosing (WindowEvent e){
                System.exit(0);
            }
        });


        pack();
        show();
    }
    public static void main(String[] args) {
        App2 f=new App2()  ;
        f.setSize(400,400);

    }
}