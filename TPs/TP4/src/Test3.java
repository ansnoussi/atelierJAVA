import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class Test3{
        


	public static void main(String[] args) {
                MenuBar mb = new MenuBar();
                Menu mb1 = new Menu("file");
                MenuItem mi1 = new MenuItem("open");
                MenuItem mi2 = new MenuItem("save");
                MenuItem mi3 = new MenuItem("quit");
                mb1.add(mi1);
                mb1.add(mi2);
                mb1.add(mi3);
                mi3.addActionListener(new ActionListener()
				{public void actionPerformed(ActionEvent e) {
				System.exit(0);}}
				);
             mi2.addActionListener(new ActionListener()
				{
          public void actionPerformed(ActionEvent e) {
				System.out.println("Ce bouton Permet de sauvegarder le fichier courant dans le répertoire");}
        }
				);
                mi1.addActionListener(new ActionListener()
				{public void actionPerformed(ActionEvent e) {
				try
      {
        MyFileDialog mfd = new MyFileDialog(fr);
        mfd.setVisible(true);
        String nomFichier = mfd.getFile();
        String repFichier = mfd.getDirectory();
        String nomComplet = nomFichier + repFichier;
        System.out.println("nomFichier : "+nomFichier);
        System.out.println("repFichier : "+repFichier);
        System.out.println("nomComplet : "+nomComplet);
        File file = new File (mfd.getDirectory()+mfd.getFile());

        }
      catch(Exception e) {e.printStackTrace();}
    };
                   mb.add(mb1);
		MyFrame f = new MyFrame(10,10,400,500,Color.red,true,"Mohamed Lamine Barghouda",mb);
               

                   File fichier = new File("Test.java");
                   System.out.println(fichier.length());
                   fichier.renameTo(new File("Lamine.java"));
	}
}