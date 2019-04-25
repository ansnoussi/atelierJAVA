import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class OkButtonListener implements ActionListener {
    App1 app;
    public OkButtonListener(App1 a){
        this.app=a;
    }
    public void actionPerformed(ActionEvent evt) {
    System.out.println("textField = " + app.tf1.getText());
    System.out.println("choice = " + app.choice.getSelectedItem());
    System.out.println("list = " + app.list.getSelectedItem());
    System.out.println("cbSolaris=" +(app.cbSolaris.getState() ? "Yes" : "No"));
    System.out.println("cbLinux=" + (app.cbLinux.getState() ? "Yes" : "No"));
    System.out.println("cbWindow=" + (app.cbAix.getState() ? "Yes" : "No"));
    System.out.println("rbSolaris=" + (app.rbSolaris.getState() ? "Yes" : "No"));
    System.out.println("rbLinux=" + (app.rbLinux.getState() ? "Yes" : "No"));
    System.out.println("rbWindow=" + (app.rbAix.getState() ? "Yes" : "No"));
    }
}