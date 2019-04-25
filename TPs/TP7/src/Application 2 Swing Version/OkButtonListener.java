import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class OkButtonListener implements ActionListener {
    App2 app;
    public OkButtonListener(App2 a){
        this.app=a;
    }
    public void actionPerformed(ActionEvent evt) {
    System.out.println("textField = " + app.tf1.getText());
    System.out.println("choice = " + app.choice.getSelectedItem());
    System.out.println("list = " + app.list.getSelectedValue());
    System.out.println("cbSolaris=" +(app.cbSolaris.isSelected() ? "Yes" : "No"));
    System.out.println("cbLinux=" + (app.cbLinux.isSelected() ? "Yes" : "No"));
    System.out.println("cbWindow=" + (app.cbAix.isSelected() ? "Yes" : "No"));
    System.out.println("rbSolaris=" + (app.rbSolaris.isSelected() ? "Yes" : "No"));
    System.out.println("rbLinux=" + (app.rbLinux.isSelected() ? "Yes" : "No"));
    System.out.println("rbWindow=" + (app.rbAix.isSelected() ? "Yes" : "No"));
    }
}