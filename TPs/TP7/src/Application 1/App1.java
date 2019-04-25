import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class App1 extends Frame {

    TextField tf1= new TextField(15);
    Choice choice = new Choice();
    List list = new List();
    Checkbox cbSolaris = new Checkbox("Solaris");
    Checkbox cbLinux = new Checkbox("Linux");
    Checkbox cbAix = new Checkbox("Aix");
    Checkbox rbSolaris = new Checkbox("Solaris");
    Checkbox rbLinux = new Checkbox("Linux");
    Checkbox rbAix = new Checkbox("Aix");

    public App1(String title){
        super (title);

       
        Panel tfPanel = new Panel(new FlowLayout(FlowLayout.LEFT));
        Label l1 = new Label("TextField");
        tfPanel.add(l1);
        tfPanel.add(tf1);
        tfPanel.setBackground(Color.blue);

    
        Panel chPanel = new Panel(new FlowLayout(FlowLayout.LEFT));
        Label l2 = new Label("Choice");
        chPanel.add(l2);
        choice.addItem("Solaris");
        choice.addItem("Linux");
        choice.addItem("Aix");
        chPanel.add(choice);
        chPanel.setBackground(Color.red);

  
        Panel listPanel = new Panel(new FlowLayout(FlowLayout.LEFT));
        Label l3 = new Label("List");
        listPanel.add(l3);
        list.addItem("Solaris");
        list.addItem("Linux");
        list.addItem("Aix");
        listPanel.add(list);
        listPanel.setBackground(Color.yellow);

        
        Panel cbPanel = new Panel(new FlowLayout(FlowLayout.LEFT));
        Checkbox cbSolaris = new Checkbox("Solaris");
        cbPanel.add(cbSolaris);
        Checkbox cbLinux = new Checkbox("Linux");
        cbPanel.add(cbLinux);
        Checkbox cbAix = new Checkbox("Aix");
        cbPanel.add(cbAix);
        cbPanel.setBackground(Color.green);

        
        Panel rbPanel = new Panel(new FlowLayout(FlowLayout.LEFT));
        CheckboxGroup rbGroup = new CheckboxGroup();
        rbSolaris.setCheckboxGroup(rbGroup);
        rbPanel.add(rbSolaris);
        rbLinux.setCheckboxGroup(rbGroup);
        rbPanel.add(rbLinux);
        rbAix.setCheckboxGroup(rbGroup);
        rbPanel.add(rbAix);
        rbGroup.setSelectedCheckbox(rbSolaris);
        rbPanel.setBackground(Color.CYAN);

       
        Panel btPanel = new Panel(new FlowLayout(FlowLayout.LEFT));
        Button okButton = new Button("Ok");
        okButton.addActionListener(new OkButtonListener(this));
        btPanel.add(okButton);
        Button cancelButton = new Button("Cancel");
        btPanel.add(cancelButton);
        btPanel.setBackground(Color.pink);
        cancelButton.addActionListener(new ActionListener(){
    	public void actionPerformed(ActionEvent e) {
				System.exit(0);
				 }
			});

        
        Menu procMenu = new Menu("Procedural");
        procMenu.add(new MenuItem("Pascal"));
        
        Menu ooMenu = new Menu("Object Oriented");
        ooMenu.add(new MenuItem("SmallTalk"));
        ooMenu.add(new MenuItem("Java"));
        ooMenu.add(new MenuItem("Eiffel"));
        ooMenu.add(new MenuItem("C++"));
        
        Menu funcMenu = new Menu("Functional");
        funcMenu.add(new MenuItem("Lisp"));
        
        Menu languageMenu = new Menu("Languages");
        languageMenu.add(procMenu);
        languageMenu.add(ooMenu);
        languageMenu.add(funcMenu);
        
       
        MenuBar mb = new MenuBar();
        mb.add(languageMenu);

        this.setMenuBar(mb);
        this.setLayout(new GridLayout(6,1)); // 6 lignes et 1 colonne
        this.add(tfPanel);
        this.add(chPanel);
        this.add(listPanel);
        this.add(cbPanel);
        this.add(rbPanel);
        this.add(btPanel);

       
        this.addWindowListener(new WindowAdapter (){
            public void windowClosing (WindowEvent e){
                System.exit(0);
            }
        });


        pack();
        show();
    }
    public static void main(String[] args) {
        App1 f=new App1("My App")  ;
    }
}